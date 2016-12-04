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

package com.github.marlonlom.utilities.timeago;

/**
 * The Class <b>TimeAgo</b>. Performs date time parsing into a text with 'time ago' syntax.
 * <br>
 * <br>
 * Usage:
 * <br>
 * <br>
 * <i>(1) Default:</i>
 * <pre>
 * TimeAgo.using(new java.util.Date().getTime());
 * </pre>
 * <br>
 * <i>(2) With Specific Locale (by language tag):</i>
 * <br>
 * <pre>
 * Locale LocaleByLanguageTag = Locale.forLanguageTag("es");
 * TimeAgo.using(new java.util.Date().getTime(), new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build());
 * </pre><br>
 *
 * @author marlonlom
 * @version 3.0.1
 * @see TimeAgoMessages
 * @since 1.0.0
 */
public final class TimeAgo {


    /**
     * Instantiates a new Time ago.
     */
    private TimeAgo() {
        super();
    }

    /**
     * <p>
     * Returns the 'time ago' formatted text using date time.
     * </p>
     *
     * @param time the date time for parsing
     * @return the 'time ago' formatted text using date time
     * @see TimeAgoMessages
     */
    public static String using(final long time) {
        return using(time, new TimeAgoMessages.Builder().defaultLocale().build());
    }

    /**
     * <p>
     * Returns the 'time ago' formatted text using date time.
     * </p>
     *
     * @param time      the date time for parsing
     * @param resources the resources for localizing messages
     * @return the 'time ago' formatted text using date time
     * @see TimeAgoMessages
     */
    public static String using(final long time, final TimeAgoMessages resources) {
        final long dim = getTimeDistanceInMinutes(time);
        final StringBuilder timeAgo = buildTimeagoText(resources, dim);
        return timeAgo.toString();
    }

    /**
     * Build timeago text string builder.
     *
     * @param resources the resources
     * @param dim       the distance in minutes from now
     * @return the string builder
     */
    private static StringBuilder buildTimeagoText(TimeAgoMessages resources, long dim) {
        final StringBuilder timeAgo = new StringBuilder();

        final Periods foundTimePeriod = Periods.findByDistanceMinutes(dim);
        if (foundTimePeriod != null) {
            final String periodKey = foundTimePeriod.getPropertyKey();
            switch (foundTimePeriod) {
                case XMINUTES_PAST:
                    timeAgo.append(resources.getPropertyValue(periodKey, dim));
                    break;
                case XHOURS_PAST:
                    int hours = Math.round(dim / 60);
                    final String xHoursText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.aboutanhour.past", periodKey, hours);
                    timeAgo.append(xHoursText);
                    break;
                case XDAYS_PAST:
                    int days = Math.round(dim / 1440);
                    final String xDaysText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.oneday.past", periodKey, days);
                    timeAgo.append(xDaysText);
                    break;
                case XMONTHS_PAST:
                    int months = Math.round(dim / 43200);
                    final String xMonthsText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.aboutamonth.past", periodKey, months);
                    timeAgo.append(xMonthsText);
                    break;
                case XYEARS_PAST:
                    int years = Math.round(dim / 525600);
                    timeAgo.append(resources.getPropertyValue(periodKey, years));
                    break;
                case XMINUTES_FUTURE:
                    timeAgo.append(resources.getPropertyValue(periodKey, Math.abs((float) dim)));
                    break;
                case XHOURS_FUTURE:
                    int hours1 = Math.abs(Math.round(dim / 60f));
                    final String yHoursText = hours1 == 24
                            ? resources.getPropertyValue("ml.timeago.oneday.future")
                            : handlePeriodKeyAsPlural(resources, "ml.timeago.aboutanhour.future",
                            periodKey, hours1);
                    timeAgo.append(yHoursText);
                    break;
                case XDAYS_FUTURE:
                    int days1 = Math.abs(Math.round(dim / 1440f));
                    final String yDaysText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.oneday.future", periodKey, days1);
                    timeAgo.append(yDaysText);
                    break;
                case XMONTHS_FUTURE:
                    int months1 = Math.abs(Math.round(dim / 43200f));
                    final String yMonthsText = months1 == 12
                            ? resources.getPropertyValue("ml.timeago.aboutayear.future")
                            : handlePeriodKeyAsPlural(resources,
                            "ml.timeago.aboutamonth.future", periodKey, months1);
                    timeAgo.append(yMonthsText);
                    break;
                case XYEARS_FUTURE:
                    int years1 = Math.abs(Math.round(dim / 525600f));
                    timeAgo.append(resources.getPropertyValue(periodKey, years1));
                    break;
                default:
                    timeAgo.append(resources.getPropertyValue(periodKey));
                    break;
            }
        }
        return timeAgo;
    }

    /**
     * Handle period key as plural string.
     *
     * @param resources the resources
     * @param periodKey the period key
     * @param value     the value
     * @return the string
     */
    private static String handlePeriodKeyAsPlural(final TimeAgoMessages resources,
                                                  final String periodKey,
                                                  final String pluralKey, final int value) {
        return value == 1
                ? resources.getPropertyValue(periodKey)
                : resources.getPropertyValue(pluralKey, value);
    }

    /**
     * Returns the time distance in minutes.
     *
     * @param time the date time
     * @return the time distance in minutes
     */
    private static long getTimeDistanceInMinutes(long time) {
        long timeDistance = System.currentTimeMillis() - time;
        return Math.round((timeDistance / 1000) / 60);
    }

    /**
     * The enum Periods.
     *
     * @author marlonlom
     * @version 3.0.1
     * @since 2.0.0
     */
    private enum Periods {

        NOW("ml.timeago.now", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance == 0;
            }
        }),
        ONEMINUTE_PAST("ml.timeago.oneminute.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance == 1;
            }
        }),
        XMINUTES_PAST("ml.timeago.xminutes.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 2 && distance <= 44;
            }
        }),
        ABOUTANHOUR_PAST("ml.timeago.aboutanhour.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 45 && distance <= 89;
            }
        }),
        XHOURS_PAST("ml.timeago.xhours.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 90 && distance <= 1439;
            }
        }),
        ONEDAY_PAST("ml.timeago.oneday.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 1440 && distance <= 2519;
            }
        }),
        XDAYS_PAST("ml.timeago.xdays.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 2520 && distance <= 43199;
            }
        }),
        ABOUTAMONTH_PAST("ml.timeago.aboutamonth.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 43200 && distance <= 86399;
            }
        }),
        XMONTHS_PAST("ml.timeago.xmonths.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 86400 && distance <= 525599;
            }
        }),
        ABOUTAYEAR_PAST("ml.timeago.aboutayear.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 525600 && distance <= 655199;
            }
        }),
        OVERAYEAR_PAST("ml.timeago.overayear.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 655200 && distance <= 914399;
            }
        }),
        ALMOSTTWOYEARS_PAST("ml.timeago.almosttwoyears.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 914400 && distance <= 1051199;
            }
        }),
        XYEARS_PAST("ml.timeago.xyears.past", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return Math.round(distance / 525600) > 1;
            }
        }),
        ONEMINUTE_FUTURE("ml.timeago.oneminute.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance == -1;
            }
        }),
        XMINUTES_FUTURE("ml.timeago.xminutes.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -2 && distance >= -44;
            }
        }),
        ABOUTANHOUR_FUTURE("ml.timeago.aboutanhour.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -45 && distance >= -89;
            }
        }),
        XHOURS_FUTURE("ml.timeago.xhours.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -90 && distance >= -1439;
            }
        }),
        ONEDAY_FUTURE("ml.timeago.oneday.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -1440 && distance >= -2519;
            }
        }),
        XDAYS_FUTURE("ml.timeago.xdays.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -2520 && distance >= -43199;
            }
        }),
        ABOUTAMONTH_FUTURE("ml.timeago.aboutamonth.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -43200 && distance >= -86399;
            }
        }),
        XMONTHS_FUTURE("ml.timeago.xmonths.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -86400 && distance >= -525599;
            }
        }),
        ABOUTAYEAR_FUTURE("ml.timeago.aboutayear.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -525600 && distance >= -655199;
            }
        }),
        OVERAYEAR_FUTURE("ml.timeago.overayear.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -655200 && distance >= -914399;
            }
        }),
        ALMOSTTWOYEARS_FUTURE("ml.timeago.almosttwoyears.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance <= -914400 && distance >= -1051199;
            }
        }),
        XYEARS_FUTURE("ml.timeago.xyears.future", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return Math.round(distance / 525600) < -1;
            }
        });

        /**
         * The property key.
         */
        private String mPropertyKey;
        /**
         * The predicate.
         */
        private DistancePredicate mPredicate;

        Periods(String propertyKey, DistancePredicate predicate) {
            this.mPropertyKey = propertyKey;
            this.mPredicate = predicate;
        }

        /**
         * Find by distance minutes periods.
         *
         * @param distanceMinutes the distance minutes
         * @return the periods
         */
        public static Periods findByDistanceMinutes(final long distanceMinutes) {
            final Periods[] values = Periods.values();
            for (final Periods item : values) {
                final boolean successful = item.getPredicate()
                        .validateDistanceMinutes(distanceMinutes);
                if (successful) {
                    return item;
                }
            }
            return null;
        }

        /**
         * Gets predicate.
         *
         * @return the predicate
         */
        private DistancePredicate getPredicate() {
            return mPredicate;
        }

        /**
         * Gets property key.
         *
         * @return the property key
         */
        public String getPropertyKey() {
            return mPropertyKey;
        }
    }

    /**
     * Interface definition for handling distance validations or periods.
     *
     * @author marlonlom
     * @version 3.0.1
     * @see Periods
     * @since 1.0.0
     */
    private interface DistancePredicate {
        /**
         * Validate distance minutes boolean.
         *
         * @param distance the distance
         * @return the boolean
         */
        boolean validateDistanceMinutes(final long distance);
    }
}