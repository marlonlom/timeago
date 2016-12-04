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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Unit tests Class for TimeAgo usage.
 *
 * @author marlonlom
 * @version 3.0.1
 * @since 2.1.0
 */
@RunWith(JUnit4.class)
public class TimeAgoTest {

    /**
     * The available languages array.
     */
    private static final String[] LANGUAGES_ARRAY = "es;en;de;fr;it;pt".split(";");
    /**
     * The time ago messages.
     */
    private TimeAgoMessages mTimeAgoMessages;
    /**
     * The Local bundle.
     */
    private ResourceBundle localBundle;

    /**
     * Setup messages resource.
     */
    @Before
    public void setupMessagesResource() {
        final String languageRef = getRandomLanguageRef();
        final Locale languageTag = Locale.forLanguageTag(languageRef);
        final String bundleName = "com.github.marlonlom.utilities.timeago.messages";
        mTimeAgoMessages = new TimeAgoMessages.Builder().withLocale(languageTag).build();
        localBundle = ResourceBundle.getBundle(bundleName, languageTag);
    }

    /**
     * Gets random language reference.
     *
     * @return the random language code
     */
    private String getRandomLanguageRef() {
        final int rnd = new Random().nextInt(LANGUAGES_ARRAY.length);
        return LANGUAGES_ARRAY[rnd];
    }

    /**
     * Gets expected message.
     *
     * @param key    the key
     * @param values the values
     * @return the expected message
     */
    private String getExpectedMessage(String key, Integer... values) {
        final String bundledMessage = localBundle.getString(key);
        if (values.length > 0) {
            return bundledMessage.replace("{0}", String.valueOf(values[0]));
        }
        return bundledMessage;
    }

    /**
     * Should show past date time with almost two years.
     */
    @Test
    public void shouldShowPastDateTimeWithAlmostTwoYears() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -10);
        calendar.add(Calendar.YEAR, -1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.almosttwoyears.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time over one year.
     */
    @Test
    public void shouldShowPastDateTimeOverOneYear() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -4);
        calendar.add(Calendar.YEAR, -1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.overayear.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with almost one year.
     */
    @Test
    public void shouldShowPastDateTimeWithAlmostOneYear() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -12);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.aboutayear.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with six months.
     */
    @Test
    public void shouldShowPastDateTimeWithSixMonths() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -6);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xmonths.past", 6);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with almost one month.
     */
    @Test
    public void shouldShowPastDateTimeWithAlmostOneMonth() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.aboutamonth.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with ten days.
     */
    @Test
    public void shouldShowPastDateTimeWithTenDays() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xdays.past", 10);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with one day.
     */
    @Test
    public void shouldShowPastDateTimeWithOneDay() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.oneday.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with five hours.
     */
    @Test
    public void shouldShowPastDateTimeWithFiveHours() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -3);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xhours.past", 3);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with fifty one minutes.
     */
    @Test
    public void shouldShowPastDateTimeWithFiftyOneMinutes() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -51);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.aboutanhour.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with nine minutes.
     */
    @Test
    public void shouldShowPastDateTimeWithNineMinutes() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -9);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xminutes.past", 9);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show past date time with one minute.
     */
    @Test
    public void shouldShowPastDateTimeWithOneMinute() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.oneminute.past");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with almost two years.
     */
    @Test
    public void shouldShowFutureDateTimeWithAlmostTwoYears() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 10);
        calendar.add(Calendar.YEAR, 1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.almosttwoyears.future");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time over one year.
     */
    @Test
    public void shouldShowFutureDateTimeOverOneYear() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 4);
        calendar.add(Calendar.YEAR, 1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.overayear.future");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with almost one year.
     */
    @Test
    public void shouldShowFutureDateTimeWithAlmostOneYear() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 12);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.aboutayear.future");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with six months.
     */
    @Test
    public void shouldShowFutureDateTimeWithSixMonths() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 6);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xmonths.future", 6);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with almost one month.
     */
    @Test
    public void shouldShowFutureDateTimeWithAlmostOneMonth() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.aboutamonth.future");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with ten days.
     */
    @Test
    public void shouldShowFutureDateTimeWithTenDays() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xdays.future", 10);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with one day.
     */
    @Test
    public void shouldShowFutureDateTimeWithOneDay() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.oneday.future");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with five hours.
     */
    @Test
    public void shouldShowFutureDateTimeWithFiveHours() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 5);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xhours.future", 5);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with fifty one minutes.
     */
    @Test
    public void shouldShowFutureDateTimeWithFiftyOneMinutes() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 51);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.aboutanhour.future");
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with nine minutes.
     */
    @Test
    public void shouldShowFutureDateTimeWithNineMinutes() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 9);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.xminutes.future", 9);
        Assert.assertEquals(expected, results);
    }

    /**
     * Should show future date time with one minute.
     */
    @Test
    public void shouldShowFutureDateTimeWithOneMinute() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 61);
        final String results = TimeAgo.using(calendar.getTimeInMillis(), mTimeAgoMessages);
        final String expected = getExpectedMessage("ml.timeago.oneminute.future");
        Assert.assertEquals(expected, results);
    }
}
