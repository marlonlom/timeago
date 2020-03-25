/*
 * Copyright (c) 2016, marlonlom
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.marlonlom.utilities.timeago

import kotlin.math.abs
import kotlin.math.roundToLong

/**
 * The Class **TimeAgo**. Performs date time parsing into a text with 'time ago' syntax.
 * <br></br>
 * <br></br>
 * Usage:
 * <br></br>
 * <br></br>
 * *(1) Default:*
 * <pre>
 * TimeAgo.using(new java.util.Date().getTime());
 * </pre>
 * <br></br>
 * *(2) With Specific Locale (by language tag):*
 * <br></br>
 * <pre>
 * Locale LocaleByLanguageTag = Locale.forLanguageTag("es");
 * TimeAgo.using(new java.util.Date().getTime(), new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build());
 * </pre>
 * <br></br>
 *
 * @author marlonlom
 * @version 4.0.3
 * @see TimeAgoMessages
 *
 * @since 1.0.0
 */
class TimeAgo
/**
 * Instantiates a new Time ago.
 */
private constructor() {

    /**
     * The enum Periods.
     *
     * @author marlonlom
     * @version 4.0.3
     * @since 2.0.0
     */
    enum class Periods(
            /**
             * The property key.
             */
            val propertyKey: String,
            /**
             * The predicate.
             */
            private val predicate: DistancePredicate) {

        NOW("ml.timeago.now", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance == 0L
            }
        }),
        ONEMINUTE_PAST("ml.timeago.oneminute.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance == 1L
            }
        }),
        XMINUTES_PAST("ml.timeago.xminutes.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 2..44
            }
        }),
        ABOUTANHOUR_PAST("ml.timeago.aboutanhour.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 45..89
            }
        }),
        XHOURS_PAST("ml.timeago.xhours.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 90..1439
            }
        }),
        ONEDAY_PAST("ml.timeago.oneday.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 1440..2519
            }
        }),
        XDAYS_PAST("ml.timeago.xdays.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 2520..43199
            }
        }),
        ABOUTAMONTH_PAST("ml.timeago.aboutamonth.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 43200..86399
            }
        }),
        XMONTHS_PAST("ml.timeago.xmonths.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 86400..525599
            }
        }),
        ABOUTAYEAR_PAST("ml.timeago.aboutayear.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 525600..655199
            }
        }),
        OVERAYEAR_PAST("ml.timeago.overayear.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 655200..914399
            }
        }),
        ALMOSTTWOYEARS_PAST("ml.timeago.almosttwoyears.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance in 914400..1051199
            }
        }),
        XYEARS_PAST("ml.timeago.xyears.past", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return Math.round((distance / 525600).toFloat()) > 1
            }
        }),
        ONEMINUTE_FUTURE("ml.timeago.oneminute.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance.toInt() == -1
            }
        }),
        XMINUTES_FUTURE("ml.timeago.xminutes.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -2 && distance >= -44
            }
        }),
        ABOUTANHOUR_FUTURE("ml.timeago.aboutanhour.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -45 && distance >= -89
            }
        }),
        XHOURS_FUTURE("ml.timeago.xhours.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -90 && distance >= -1439
            }
        }),
        ONEDAY_FUTURE("ml.timeago.oneday.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -1440 && distance >= -2519
            }
        }),
        XDAYS_FUTURE("ml.timeago.xdays.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -2520 && distance >= -43199
            }
        }),
        ABOUTAMONTH_FUTURE("ml.timeago.aboutamonth.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -43200 && distance >= -86399
            }
        }),
        XMONTHS_FUTURE("ml.timeago.xmonths.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -86400 && distance >= -525599
            }
        }),
        ABOUTAYEAR_FUTURE("ml.timeago.aboutayear.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -525600 && distance >= -655199
            }
        }),
        OVERAYEAR_FUTURE("ml.timeago.overayear.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -655200 && distance >= -914399
            }
        }),
        ALMOSTTWOYEARS_FUTURE("ml.timeago.almosttwoyears.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return distance <= -914400 && distance >= -1051199
            }
        }),
        XYEARS_FUTURE("ml.timeago.xyears.future", object : DistancePredicate {
            override fun validateDistanceMinutes(distance: Long): Boolean {
                return (distance / 525600).toFloat().roundToLong() < -1
            }
        });


        companion object {

            /**
             * Find by distance minutes periods.
             *
             * @param distanceMinutes the distance minutes
             * @return the periods
             */
            fun findByDistanceMinutes(distanceMinutes: Long): Periods? {
                val values = values()
                for (item in values) {
                    val successful = item.predicate
                            .validateDistanceMinutes(distanceMinutes)
                    if (successful) {
                        return item
                    }
                }
                return null
            }
        }
    }

    /**
     * Interface definition for handling distance validations or periods.
     *
     * @author marlonlom
     * @version 4.0.3
     * @see Periods
     *
     * @since 1.0.0
     */
    private interface DistancePredicate {
        /**
         * Validate distance minutes boolean.
         *
         * @param distance the distance
         * @return the boolean
         */
        fun validateDistanceMinutes(distance: Long): Boolean
    }

    companion object {

        /**
         * Returns the 'time ago' formatted text using date time.
         *
         * @param time      the date time for parsing
         * @param resources the resources for localizing messages
         * @return the 'time ago' formatted text using date time
         * @see TimeAgoMessages
         */
        @JvmStatic
        @JvmOverloads
        fun using(time: Long, resources: TimeAgoMessages = TimeAgoMessages.Builder().defaultLocale().build()): String {
            val dim = getTimeDistanceInMinutes(time)
            val timeAgo = buildTimeagoText(resources, dim)
            return timeAgo.toString()
        }

        /**
         * Build timeago text string builder.
         *
         * @param resources the resources
         * @param dim       the distance in minutes from now
         * @return the string builder
         */
        private fun buildTimeagoText(resources: TimeAgoMessages, dim: Long): StringBuilder {
            val timeAgo = StringBuilder()

            val foundTimePeriod = Periods.findByDistanceMinutes(dim)
            if (foundTimePeriod != null) {
                val periodKey = foundTimePeriod.propertyKey
                when (foundTimePeriod) {
                    Periods.XMINUTES_PAST -> timeAgo.append(resources.getPropertyValue(periodKey, dim))
                    Periods.XHOURS_PAST -> {
                        val hours = (dim / 60).toFloat().roundToLong()
                        val xHoursText = handlePeriodKeyAsPlural(resources,
                                "ml.timeago.aboutanhour.past", periodKey, hours.toInt())
                        timeAgo.append(xHoursText)
                    }
                    Periods.XDAYS_PAST -> {
                        val days = (dim / 1440).toFloat().roundToLong()
                        val xDaysText = handlePeriodKeyAsPlural(resources,
                                "ml.timeago.oneday.past", periodKey, days.toInt())
                        timeAgo.append(xDaysText)
                    }
                    Periods.XMONTHS_PAST -> {
                        val months = (dim / 43200).toFloat().roundToLong()
                        val xMonthsText = handlePeriodKeyAsPlural(resources,
                                "ml.timeago.aboutamonth.past", periodKey, months.toInt())
                        timeAgo.append(xMonthsText)
                    }
                    Periods.XYEARS_PAST -> {
                        val years = (dim / 525600).toFloat().roundToLong()
                        timeAgo.append(resources.getPropertyValue(periodKey, years))
                    }
                    Periods.XMINUTES_FUTURE -> timeAgo.append(resources.getPropertyValue(periodKey, abs(dim.toFloat())))
                    Periods.XHOURS_FUTURE -> {
                        val hours1 = abs((dim / 60f).roundToLong())
                        val yHoursText = if (hours1.toInt() == 24)
                            resources.getPropertyValue("ml.timeago.oneday.future")
                        else
                            handlePeriodKeyAsPlural(resources, "ml.timeago.aboutanhour.future",
                                    periodKey, hours1.toInt())
                        timeAgo.append(yHoursText)
                    }
                    Periods.XDAYS_FUTURE -> {
                        val days1 = abs((dim / 1440f).roundToLong())
                        val yDaysText = handlePeriodKeyAsPlural(resources,
                                "ml.timeago.oneday.future", periodKey, days1.toInt())
                        timeAgo.append(yDaysText)
                    }
                    Periods.XMONTHS_FUTURE -> {
                        val months1 = abs((dim / 43200f).roundToLong())
                        val yMonthsText = if (months1.toInt() == 12)
                            resources.getPropertyValue("ml.timeago.aboutayear.future")
                        else
                            handlePeriodKeyAsPlural(resources,
                                    "ml.timeago.aboutamonth.future", periodKey, months1.toInt())
                        timeAgo.append(yMonthsText)
                    }
                    Periods.XYEARS_FUTURE -> {
                        val years1 = abs((dim / 525600f).roundToLong())
                        timeAgo.append(resources.getPropertyValue(periodKey, years1))
                    }
                    else -> timeAgo.append(resources.getPropertyValue(periodKey))
                }
            }
            return timeAgo
        }

        /**
         * Handle period key as plural string.
         *
         * @param resources the resources
         * @param periodKey the period key
         * @param value     the value
         * @return the string
         */
        private fun handlePeriodKeyAsPlural(resources: TimeAgoMessages,
                                            periodKey: String,
                                            pluralKey: String, value: Int): String =
                if (value == 1) resources.getPropertyValue(periodKey) else resources.getPropertyValue(pluralKey, value)

        /**
         * Returns the time distance in minutes.
         *
         * @param time the date time
         * @return the time distance in minutes
         */
        private fun getTimeDistanceInMinutes(time: Long): Long {
            val timeDistance = System.currentTimeMillis() - time
            return (timeDistance / 1000 / 60).toFloat().roundToLong()
        }
    }
}
