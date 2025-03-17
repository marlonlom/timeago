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
 * TimeAgo.using(new java.util.Date().getTime(), new TimeAgoMessages.Builder().withLocale(LocaleByLanguageTag).build());
 * </pre>
 * <br></br>
 *
 * @author marlonlom
 * @version 4.1.0
 * @see TimeAgoMessages
 *
 * @since 1.0.0
 */
class TimeAgo
/**
 * Instantiates a new Time ago.
 */
private constructor() {

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

      val foundTimePeriod = Periods.findByDistanceMinutes(dim) ?: return timeAgo

      val periodKey = foundTimePeriod.propertyKey
      when (foundTimePeriod) {
        Periods.X_MINUTES_PAST -> {
          timeAgo.append(PeriodMessages.getPastXMinutesText(resources, dim, periodKey))
        }

        Periods.X_HOURS_PAST -> {
          timeAgo.append(
            PeriodMessages.getPastXHoursText(resources, dim, periodKey)
          )
        }

        Periods.X_DAYS_PAST -> {
          timeAgo.append(
            PeriodMessages.getPastXDaysText(resources, dim, periodKey)
          )
        }

        Periods.X_WEEKS_PAST -> {
          timeAgo.append(
            PeriodMessages.getPastXWeeksText(resources, dim, periodKey)
          )
        }

        Periods.X_MONTHS_PAST -> {
          timeAgo.append(
            PeriodMessages.getPastXMonthsText(resources, dim, periodKey)
          )
        }

        Periods.X_YEARS_PAST -> {
          timeAgo.append(
            PeriodMessages.getPastXYearsText(resources, dim, periodKey)
          )
        }

        Periods.X_MINUTES_FUTURE -> {
          timeAgo.append(
            PeriodMessages.getFutureXMinutesText(resources, dim, periodKey)
          )
        }

        Periods.X_HOURS_FUTURE -> {
          timeAgo.append(
            PeriodMessages.getFutureXHoursText(resources, dim, periodKey)
          )
        }

        Periods.X_DAYS_FUTURE -> {
          timeAgo.append(
            PeriodMessages.getFutureXDaysText(resources, dim, periodKey)
          )
        }

        Periods.X_WEEKS_FUTURE -> {
          timeAgo.append(
            PeriodMessages.getFutureXWeeksText(resources, dim, periodKey)
          )
        }

        Periods.X_MONTHS_FUTURE -> {
          timeAgo.append(
            PeriodMessages.getFutureXMonthsText(resources, dim, periodKey)
          )
        }

        Periods.X_YEARS_FUTURE -> {
          timeAgo.append(
            PeriodMessages.getFutureXYearsText(resources, dim, periodKey)
          )
        }

        else -> timeAgo.append(resources.getPropertyValue(periodKey))
      }

      return timeAgo
    }

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
