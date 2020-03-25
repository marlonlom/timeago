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

import com.github.marlonlom.utilities.timeago.TimeAgo.Periods
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

/**
 * Unit tests Class for TimeAgo usage.
 *
 * @author marlonlom
 * @version 4.0.3
 * @since 2.1.0
 */
@RunWith(JUnit4::class)
class TimeAgoTest {
    /**
     * The time ago messages.
     */
    private lateinit var mTimeAgoMessages: TimeAgoMessages

    /**
     * The Local bundle.
     */
    private var localBundle: ResourceBundle? = null

    /**
     * Gets random language reference.
     *
     * @return the random language code
     */
    private val randomLanguageRef: String
        get() {
            val rnd = Random().nextInt(LANGUAGES_ARRAY.size)
            return LANGUAGES_ARRAY[rnd]
        }

    /**
     * Setup messages resource.
     */
    @Before
    fun setupMessagesResource() {
        val languageTag = Locale.forLanguageTag(randomLanguageRef)
        mTimeAgoMessages = TimeAgoMessages.Builder().withLocale(languageTag).build()
        localBundle = ResourceBundle.getBundle(BUNDLE_NAME, languageTag)
    }

    /**
     * Gets expected message.
     *
     * @param key    the key
     * @param values the values
     * @return the expected message
     */
    private fun getExpectedMessage(key: String, vararg values: Int): String {
        val bundledMessage = localBundle!!.getString(key)
        return if (values.isNotEmpty()) bundledMessage.replace("{0}", values[0].toString()) else bundledMessage
    }

    /**
     * Should show past date time with almost two years.
     */
    @Test
    fun shouldShowPastDateTimeWithAlmostTwoYears() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -10)
        calendar.add(Calendar.YEAR, -1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ALMOSTTWOYEARS_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time over one year.
     */
    @Test
    fun shouldShowPastDateTimeOverOneYear() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -4)
        calendar.add(Calendar.YEAR, -1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.OVERAYEAR_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with almost one year.
     */
    @Test
    fun shouldShowPastDateTimeWithAlmostOneYear() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -12)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ABOUTAYEAR_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with six months.
     */
    @Test
    fun shouldShowPastDateTimeWithSixMonths() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -6)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XMONTHS_PAST.propertyKey, 6)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with almost one month.
     */
    @Test
    fun shouldShowPastDateTimeWithAlmostOneMonth() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -30)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ABOUTAMONTH_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with ten days.
     */
    @Test
    fun shouldShowPastDateTimeWithTenDays() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -10)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XDAYS_PAST.propertyKey, 10)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with one day.
     */
    @Test
    fun shouldShowPastDateTimeWithOneDay() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ONEDAY_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with five hours.
     */
    @Test
    fun shouldShowPastDateTimeWithFiveHours() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.HOUR, -3)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XHOURS_PAST.propertyKey, 3)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with fifty one minutes.
     */
    @Test
    fun shouldShowPastDateTimeWithFiftyOneMinutes() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, -51)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ABOUTANHOUR_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with nine minutes.
     */
    @Test
    fun shouldShowPastDateTimeWithNineMinutes() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, -9)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XMINUTES_PAST.propertyKey, 9)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show past date time with one minute.
     */
    @Test
    fun shouldShowPastDateTimeWithOneMinute() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, -1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ONEMINUTE_PAST.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with almost two years.
     */
    @Test
    fun shouldShowFutureDateTimeWithAlmostTwoYears() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 10)
        calendar.add(Calendar.YEAR, 1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ALMOSTTWOYEARS_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time over one year.
     */
    @Test
    fun shouldShowFutureDateTimeOverOneYear() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 4)
        calendar.add(Calendar.YEAR, 1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.OVERAYEAR_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with almost one year.
     */
    @Test
    fun shouldShowFutureDateTimeWithAlmostOneYear() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 12)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ABOUTAYEAR_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with six months.
     */
    @Test
    fun shouldShowFutureDateTimeWithSixMonths() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 6)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XMONTHS_FUTURE.propertyKey, 6)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with almost one month.
     */
    @Test
    fun shouldShowFutureDateTimeWithAlmostOneMonth() {
        val calendar = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, 30)
            add(Calendar.HOUR, 15)
        }
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ABOUTAMONTH_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with ten days.
     */
    @Test
    fun shouldShowFutureDateTimeWithTenDays() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 10)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XDAYS_FUTURE.propertyKey, 10)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with one day.
     */
    @Test
    fun shouldShowFutureDateTimeWithOneDay() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ONEDAY_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with five hours.
     */
    @Test
    fun shouldShowFutureDateTimeWithFiveHours() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.HOUR, 5)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XHOURS_FUTURE.propertyKey, 5)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with fifty one minutes.
     */
    @Test
    fun shouldShowFutureDateTimeWithFiftyOneMinutes() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, 51)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ABOUTANHOUR_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with nine minutes.
     */
    @Test
    fun shouldShowFutureDateTimeWithNineMinutes() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, 9)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.XMINUTES_FUTURE.propertyKey, 9)
        Assert.assertEquals(expected, results)
    }

    /**
     * Should show future date time with one minute.
     */
    @Test
    fun shouldShowFutureDateTimeWithOneMinute() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, 61)
        val results = TimeAgo.using(calendar.timeInMillis, mTimeAgoMessages)
        val expected = getExpectedMessage(Periods.ONEMINUTE_FUTURE.propertyKey)
        Assert.assertEquals(expected, results)
    }

    companion object {

        /**
         * The available languages array.
         */
        private val LANGUAGES_ARRAY = "ar;cs;da;de;en;es;eu;fa;fr;in;it;nl;pt;tr".split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        /**
         * Constant for bundle name
         */
        const val BUNDLE_NAME = "com.github.marlonlom.utilities.timeago.messages"

    }
}
