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

package com.github.marlonlom.utilities.timeago.usages

import com.github.marlonlom.utilities.timeago.DataBuilder.getExpectedMessage
import com.github.marlonlom.utilities.timeago.DataBuilder.newLocalBundle
import com.github.marlonlom.utilities.timeago.DataBuilder.newMessagesResource
import com.github.marlonlom.utilities.timeago.DataBuilder.randomLanguageRef
import com.github.marlonlom.utilities.timeago.DataBuilder.useTimeAgo
import com.github.marlonlom.utilities.timeago.TimeAgo.Periods.*
import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.getInstance as getCalendarInstance

/**
 * Unit tests class for TimeAgo weeks usage.
 *
 * @author marlonlom
 * @version 4.1.0
 * @since 4.1.0
 */
@RunWith(JUnit4::class)
class WeeksAgoTest {

    /**
     * Random language code for getting messages and making timeago work.
     */
    private val languageRef: String = randomLanguageRef

    /**
     * The time ago messages.
     */
    private lateinit var timeAgoMessages: TimeAgoMessages

    /**
     * The Local bundle.
     */
    private var localBundle: ResourceBundle? = null

    /**
     * Setup messages resource.
     */
    @Before
    fun setupMessagesResource() {
        println("<${javaClass.simpleName}> Selected language for testing: $languageRef.")
        timeAgoMessages = newMessagesResource(languageRef)
        localBundle = newLocalBundle(languageRef)
    }

    /**
     * Should show past date time with a week.
     */
    @Test
    fun shouldShowPastDateTimeWithAWeek() {
        val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, -8) }
        val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
        val expected = getExpectedMessage(localBundle!!, ONE_WEEK_PAST.propertyKey)
        assertEquals(expected, results)
    }

    /**
     * Should show future date time with a week.
     */
    @Test
    fun shouldShowFutureDateTimeWithAWeek() {
        val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, 8) }
        val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
        val expected = getExpectedMessage(localBundle!!, ONE_WEEK_FUTURE.propertyKey)
        assertEquals(expected, results)
    }

    /**
     * Should show past date time with two weeks.
     */
    @Test
    fun shouldShowPastDateTimeWithTwoWeeks() {
        val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, -16) }
        val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
        val expected = getExpectedMessage(localBundle!!, X_WEEKS_PAST.propertyKey, 2)
        assertEquals(expected, results)
    }

    /**
     * Should show future date time with two weeks.
     */
    @Test
    fun shouldShowFutureDateTimeWithTwoWeeks() {
        val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, 16) }
        val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
        val expected = getExpectedMessage(localBundle!!, X_WEEKS_FUTURE.propertyKey, 2)
        assertEquals(expected, results)
    }

    /**
     * Should show past date time with three weeks.
     */
    @Test
    fun shouldShowPastDateTimeWithThreeWeeks() {
        val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, -23) }
        val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
        val expected = getExpectedMessage(localBundle!!, X_WEEKS_PAST.propertyKey, 3)
        assertEquals(expected, results)
    }

    /**
     * Should show future date time with three weeks.
     */
    @Test
    fun shouldShowFutureDateTimeWithThreeWeeks() {
        val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, 23) }
        val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
        val expected = getExpectedMessage(localBundle!!, X_WEEKS_FUTURE.propertyKey, 3)
        assertEquals(expected, results)
    }
}
