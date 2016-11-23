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

import java.util.Calendar;
import java.util.Date;

/**
 * The Class <b>TimeAgo</b>. Performs date time parsing into a text with 'time ago' syntax.
 * <br>
 * <br>
 * Usage:
 * <br>
 * <br>
 * <i>(1) Default:</i>
 * <pre>
 * TimeAgo.from(new java.util.Date().getTime());
 * </pre>
 * <br>
 * <i>(2) With Specific Locale (by language tag):</i>
 * <br>
 * <pre>
 * Locale LocaleBylanguageTag = Locale.forLanguageTag("es");
 * TimeAgo.from(new java.util.Date().getTime(), new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build());
 * </pre><br>
 *
 * @author marlonlom
 * @version 1.0.0
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
     * Returns the 'time ago' formatted text from date time.
     * </p>
     *
     * @param time the date time for parsing
     * @return the 'time ago' formatted text from date time
     * @see TimeAgoMessages
     */
    public static String from(final long time) {
        return from(time, new TimeAgoMessages.Builder().defaultLocale().build());
    }

    /**
     * <p>
     * Returns the 'time ago' formatted text from date time.
     * </p>
     *
     * @param time      the date time for parsing
     * @param resources the resources for localizing messages
     * @return the 'time ago' formatted text from date time
     * @see TimeAgoMessages
     */
    public static String from(final long time, final TimeAgoMessages resources) {
        long now = getCurrentDate().getTime();

        if (time > now || time <= 0) {
            return null;
        }

        final long dim = getTimeDistanceInMinutes(time);

        final StringBuilder timeAgo = buildTimeagoText(resources, dim);

        return timeAgo.toString();
    }

    /**
     * Build timeago text string builder.
     *
     * @param resources the resources
     * @param dim       the dim
     * @return the string builder
     */
    private static StringBuilder buildTimeagoText(TimeAgoMessages resources, long dim) {
        final StringBuilder timeAgo = new StringBuilder();

        final Periods foundTimePeriod = Periods.findByDistanceMinutes(dim);
        if (foundTimePeriod != null) {
            final String periodKey = foundTimePeriod.getPropertyKey();
            switch (foundTimePeriod) {
                case XMINUTES:
                    timeAgo.append(resources.getPropertyValue(periodKey, dim));
                    break;
                case XHOURS:
                    int hours = Math.round(dim / 60);
                    final String xHoursText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.aboutanhour", periodKey, hours);
                    timeAgo.append(xHoursText);
                    break;
                case XDAYS:
                    int days = Math.round(dim / 1440);
                    final String xDaysText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.oneday", periodKey, days);
                    timeAgo.append(xDaysText);
                    break;
                case XMONTHS:
                    int months = Math.round(dim / 43200);
                    final String xMonthsText = handlePeriodKeyAsPlural(resources,
                            "ml.timeago.aboutamonth", periodKey, months);
                    timeAgo.append(xMonthsText);
                    break;
                case XYEARS:
                    int years = Math.round(dim / 525600);
                    timeAgo.append(resources.getPropertyValue(periodKey, years));
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
                                                  final String pluralKey,
                                                  final int value) {
        return value == 1
                ? resources.getPropertyValue(periodKey)
                : resources.getPropertyValue(pluralKey, value);
    }

    /**
     * Returns the current date.
     *
     * @return the current date
     */
    private static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Returns the time distance in minutes.
     *
     * @param time the date time
     * @return the time distance in minutes
     */
    private static long getTimeDistanceInMinutes(long time) {
        long timeDistance = getCurrentDate().getTime() - time;
        return Math.round((Math.abs(timeDistance) / 1000) / 60);
    }

    /**
     * The enum Periods.
     *
     * @author marlonlom
     * @version 1.0.0
     * @since 1.0.0
     */
    private enum Periods {

        /**
         * The Now.
         */
        NOW("ml.timeago.now", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance == 0;
            }
        }),
        /**
         * The One minute.
         */
        ONE_MINUTE("ml.timeago.oneminute", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance == 1;
            }
        }),
        /**
         * The Xminutes.
         */
        XMINUTES("ml.timeago.xminutes", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 2 && distance <= 44;
            }
        }),
        /**
         * The About an hour.
         */
        ABOUT_AN_HOUR("ml.timeago.aboutanhour", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 45 && distance <= 89;
            }
        }),
        /**
         * The Xhours.
         */
        XHOURS("ml.timeago.xhours", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 90 && distance <= 1439;
            }
        }),
        /**
         * The One day.
         */
        ONE_DAY("ml.timeago.oneday", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 1440 && distance <= 2519;
            }
        }),
        /**
         * The Xdays.
         */
        XDAYS("ml.timeago.xdays", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 2520 && distance <= 43199;
            }
        }),
        /**
         * The About a month.
         */
        ABOUT_A_MONTH("ml.timeago.aboutamonth", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 43200 && distance <= 86399;
            }
        }),
        /**
         * The Xmonths.
         */
        XMONTHS("ml.timeago.xmonths", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 86400 && distance <= 525599;
            }
        }),
        /**
         * The About a year.
         */
        ABOUT_A_YEAR("ml.timeago.aboutayear", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 525600 && distance <= 655199;
            }
        }),
        /**
         * The Over a year.
         */
        OVER_A_YEAR("ml.timeago.overayear", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 655200 && distance <= 914399;
            }
        }),
        /**
         * The Almost two years.
         */
        ALMOST_TWO_YEARS("ml.timeago.almosttwoyears", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return distance >= 914400 && distance <= 1051199;
            }
        }),
        /**
         * The Xyears.
         */
        XYEARS("ml.timeago.xyears", new DistancePredicate() {
            @Override
            public boolean validateDistanceMinutes(final long distance) {
                return Math.round(distance / 525600) > 1;
            }
        }),;

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
     * @version 1.0.0
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