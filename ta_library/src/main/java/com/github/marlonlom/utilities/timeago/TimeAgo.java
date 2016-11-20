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

        long dim = getTimeDistanceInMinutes(time);

        String timeAgo = null;

        if (dim == 0) {
            return resources.getPropertyValue("ml.timeago.now");
        } else if (dim == 1) {
            timeAgo = resources.getPropertyValue("ml.timeago.oneminute");
        } else if (dim >= 2 && dim <= 44) {
            timeAgo = resources.getPropertyValue("ml.timeago.xminutes", dim);
        } else if (dim >= 45 && dim <= 89) {
            timeAgo = resources.getPropertyValue("ml.timeago.aboutanhour");
        } else if (dim >= 90 && dim <= 1439) {
            int hours = Math.round(dim / 60);
            timeAgo = resources.getPropertyValue("ml.timeago.xhours", hours);
        } else if (dim >= 1440 && dim <= 2519) {
            timeAgo = resources.getPropertyValue("ml.timeago.oneday");
        } else if (dim >= 2520 && dim <= 43199) {
            int days = Math.round(dim / 1440);
            timeAgo = resources.getPropertyValue("ml.timeago.xdays", days);
        } else if (dim >= 43200 && dim <= 86399) {
            timeAgo = resources.getPropertyValue("ml.timeago.aboutamonth");
        } else if (dim >= 86400 && dim <= 525599) {
            int months = Math.round(dim / 43200);
            timeAgo = resources.getPropertyValue("ml.timeago.xmonths", months);
        } else if (dim >= 525600 && dim <= 655199) {
            timeAgo = resources.getPropertyValue("ml.timeago.aboutayear");
        } else if (dim >= 655200 && dim <= 914399) {
            timeAgo = resources.getPropertyValue("ml.timeago.overayear");
        } else if (dim >= 914400 && dim <= 1051199) {
            timeAgo = resources.getPropertyValue("ml.timeago.almosttwoyears");
        } else {
            int years = Math.round(dim / 525600);
            timeAgo = resources.getPropertyValue("ml.timeago.xyears", years);
        }

        return timeAgo;
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
}