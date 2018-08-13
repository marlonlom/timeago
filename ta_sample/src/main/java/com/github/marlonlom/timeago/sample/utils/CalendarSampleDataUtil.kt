/*
 * Copyright (c) 2018, marlonlom
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

package com.github.marlonlom.timeago.sample.utils

import java.util.ArrayList
import java.util.Calendar

/**
 * The type Calendar sample data util.
 *
 * @author marlonlom
 */
object CalendarSampleDataUtil {

    /**
     * Build date time list.
     *
     * @param currentTime the current time
     * @param isPast      true/false if past time
     * @return the list
     */
    fun buildDateTimeList(currentTime: Long, isPast: Boolean): List<Long> {
        val listing = ArrayList<Long>()
        addDateTimeWithOneMinute(listing, currentTime, isPast)
        addDateTimeWithNineMinutes(listing, currentTime, isPast)
        addDateTimeWithFiftyOneMinutes(listing, currentTime, isPast)
        addDateTimeWithFiveHours(listing, currentTime, isPast)
        addDateTimeWithOneDay(listing, currentTime, isPast)
        addDateTimeWithTenDays(listing, currentTime, isPast)
        addDateTimeWithAlmostOneMonth(listing, currentTime, isPast)
        addDateTimeWithSixMonths(listing, currentTime, isPast)
        addDateTimeWithAlmostOneYear(listing, currentTime, isPast)
        addDateTimeOverOneYear(listing, currentTime, isPast)
        addDateTimeWithAlmostTwoYears(listing, currentTime, isPast)
        addDateTimeWithFiveYears(listing, currentTime, isPast)
        return listing
    }

    /**
     * Add date time with five years.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithFiveYears(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MONTH, if (isPast) -10 else 10)
        calendar.add(Calendar.YEAR, if (isPast) -5 else 5)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with almost two years.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithAlmostTwoYears(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MONTH, if (isPast) -10 else 10)
        calendar.add(Calendar.YEAR, if (isPast) -1 else 1)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time over one year.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeOverOneYear(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MONTH, if (isPast) -4 else 4)
        calendar.add(Calendar.YEAR, if (isPast) -1 else 1)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with almost one year.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithAlmostOneYear(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MONTH, if (isPast) -12 else 12)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with six months.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithSixMonths(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MONTH, if (isPast) -6 else 6)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with almost one month.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithAlmostOneMonth(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.DAY_OF_MONTH, if (isPast) -30 else 30)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with ten days.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithTenDays(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.DAY_OF_MONTH, if (isPast) -10 else 10)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with one day.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithOneDay(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.DAY_OF_MONTH, if (isPast) -1 else 1)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with five hours.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithFiveHours(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.HOUR, if (isPast) -3 else 3)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with fifty one minutes.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithFiftyOneMinutes(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MINUTE, if (isPast) -51 else 51)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with nine minutes.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithNineMinutes(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.add(Calendar.MINUTE, if (isPast) -9 else 9)
        listing.add(calendar.timeInMillis)
    }

    /**
     * Add date time with one minute.
     *
     * @param listing     the listing
     * @param currentTime the current time
     * @param isPast      true/false if past time
     */
    private fun addDateTimeWithOneMinute(listing: MutableList<Long>, currentTime: Long, isPast: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        if (isPast) {
            calendar.add(Calendar.MINUTE, -1)
        } else {
            calendar.add(Calendar.SECOND, 62)
        }
        listing.add(calendar.timeInMillis)
    }
}
