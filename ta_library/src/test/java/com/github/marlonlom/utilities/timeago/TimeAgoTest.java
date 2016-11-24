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
import java.util.Date;
import java.util.Locale;

/**
 * Unit tests Class for TimeAgo usage.
 *
 * @author marlonlom
 * @version 2.1.0
 * @since 2.1.0
 */
@RunWith(JUnit4.class)
public class TimeAgoTest {

    /**
     * The resources.
     */
    private TimeAgoMessages resources;

    /**
     * Setup messages resource.
     */
    @Before
    public void setupMessagesResource() {
        resources = new TimeAgoMessages.Builder().withLocale(Locale.forLanguageTag("fr")).build();
    }

    /**
     * Should not show half hour.
     */
    @Test
    public void shouldNotShowHalfHour() {
        Calendar calendar = Calendar.getInstance();
        int currMinutes = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.MINUTE, currMinutes - 31);
        final Date date = calendar.getTime();
        final String propertyValue = resources.getPropertyValue("ml.timeago.xminutes", 30);
        String timeAgo = TimeAgo.from(date.getTime(), resources);
        Assert.assertNotEquals(propertyValue, timeAgo);
    }

    /**
     * Should not show two hours.
     */
    @Test
    public void shouldNotShowTwoHours() {
        Calendar calendar = Calendar.getInstance();
        int currHours = calendar.get(Calendar.HOUR);
        calendar.set(Calendar.HOUR, currHours - 5);
        final Date date = calendar.getTime();
        final String propertyValue = resources.getPropertyValue("ml.timeago.xhours", 2);
        String timeAgo = TimeAgo.from(date.getTime(), resources);
        Assert.assertNotEquals(propertyValue, timeAgo);
    }

    /**
     * Should show five minutes.
     */
    @Test
    public void shouldShowFiveMinutes() {
        Calendar calendar = Calendar.getInstance();
        int currMinutes = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.MINUTE, currMinutes - 5);
        final Date date = calendar.getTime();
        final String propertyValue = resources.getPropertyValue("ml.timeago.xminutes", 5);
        String timeAgo = TimeAgo.from(date.getTime(), resources);
        Assert.assertEquals(propertyValue, timeAgo);
    }

    /**
     * Should show four hours.
     */
    @Test
    public void shouldShowFourHours() {
        Calendar calendar = Calendar.getInstance();
        int currHour = calendar.get(Calendar.HOUR);
        calendar.set(Calendar.HOUR, currHour - 4);
        final Date date = calendar.getTime();
        final String propertyValue = resources.getPropertyValue("ml.timeago.xhours", 4);
        String timeAgo = TimeAgo.from(date.getTime(), resources);
        Assert.assertEquals(propertyValue, timeAgo);
    }

    /**
     * Should show just now.
     */
    @Test
    public void shouldShowJustNow() {
        final String propertyValue = resources.getPropertyValue("ml.timeago.now");
        String timeAgo = TimeAgo.from(new Date().getTime(), resources);
        Assert.assertEquals(propertyValue, timeAgo);
    }

    /**
     * Should show nine years.
     */
    @Test
    public void shouldShowNineYears() {
        Calendar calendar = Calendar.getInstance();
        int currYear = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR, currYear - 9);
        final Date date = calendar.getTime();
        final String propertyValue = resources.getPropertyValue("ml.timeago.xyears", 9);
        String timeAgo = TimeAgo.from(date.getTime(), resources);
        Assert.assertEquals(propertyValue, timeAgo);
    }

    /**
     * Should show one minute.
     */
    @Test
    public void shouldShowOneMinute() {
        Calendar calendar = Calendar.getInstance();
        int currYear = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.MINUTE, currYear - 1);
        final Date date = calendar.getTime();
        final String propertyValue = resources.getPropertyValue("ml.timeago.oneminute");
        String timeAgo = TimeAgo.from(date.getTime(), resources);
        Assert.assertEquals(propertyValue, timeAgo);
    }

}
