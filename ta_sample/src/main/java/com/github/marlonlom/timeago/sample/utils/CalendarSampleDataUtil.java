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

package com.github.marlonlom.timeago.sample.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Calendar sample data util.
 */
public final class CalendarSampleDataUtil {

    /**
     * Instantiates a new Calendars util.
     */
    private CalendarSampleDataUtil() {
    }

    /**
     * Build date time list.
     *
     * @param currentTime the current time
     * @param isPast      true/false if past time
     * @return the list
     */
    public static List<Long> buildDateTimeList(final long currentTime, final boolean isPast) {
        final List<Long> listing = new ArrayList<>();
        addDateTimeWithOneMinute(listing, currentTime, isPast);
        addDateTimeWithNineMinutes(listing, currentTime, isPast);
        addDateTimeWithFiftyOneMinutes(listing, currentTime, isPast);
        addDateTimeWithFiveHours(listing, currentTime, isPast);
        addDateTimeWithOneDay(listing, currentTime, isPast);
        addDateTimeWithTenDays(listing, currentTime, isPast);
        addDateTimeWithAlmostOneMonth(listing, currentTime, isPast);
        addDateTimeWithSixMonths(listing, currentTime, isPast);
        addDateTimeWithAlmostOneYear(listing, currentTime, isPast);
        addDateTimeOverOneYear(listing, currentTime, isPast);
        addDateTimeWithAlmostTwoYears(listing, currentTime, isPast);
        addDateTimeWithFiveYears(listing, currentTime, isPast);
        return listing;
    }

    /**
     * Add date time with five years.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithFiveYears(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MONTH, isPast ? -10 : 10);
        calendar.add(Calendar.YEAR, isPast ? -5 : 5);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with almost two years.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithAlmostTwoYears(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MONTH, isPast ? -10 : 10);
        calendar.add(Calendar.YEAR, isPast ? -1 : 1);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time over one year.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeOverOneYear(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MONTH, isPast ? -4 : 4);
        calendar.add(Calendar.YEAR, isPast ? -1 : 1);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with almost one year.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithAlmostOneYear(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MONTH, isPast ? -12 : 12);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with six months.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithSixMonths(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MONTH, isPast ? -6 : 6);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with almost one month.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithAlmostOneMonth(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.DAY_OF_MONTH, isPast ? -30 : 30);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with ten days.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithTenDays(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.DAY_OF_MONTH, isPast ? -10 : 10);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with one day.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithOneDay(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.DAY_OF_MONTH, isPast ? -1 : 1);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with five hours.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithFiveHours(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.HOUR, isPast ? -3 : 3);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with fifty one minutes.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithFiftyOneMinutes(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MINUTE, isPast ? -51 : 51);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with nine minutes.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithNineMinutes(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.MINUTE, isPast ? -9 : 9);
        listing.add(calendar.getTimeInMillis());
    }

    /**
     * Add date time with one minute.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private static void addDateTimeWithOneMinute(final List<Long> listing, final long currentTime, final boolean isPast) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        if (isPast) {
            calendar.add(Calendar.MINUTE, -1);
        } else {
            calendar.add(Calendar.SECOND, 62);
        }
        listing.add(calendar.getTimeInMillis());
    }
}
