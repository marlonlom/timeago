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
import com.github.marlonlom.utilities.timeago.Periods
import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.HOUR
import java.util.Calendar.MONTH
import java.util.ResourceBundle
import java.util.Calendar.getInstance as getCalendarInstance

/**
 * Unit tests class for TimeAgo months usage.
 *
 * @author marlonlom
 * @version 4.1.0
 * @since 2.1.0
 */
@RunWith(JUnit4::class)
class MonthsAgoTest {

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
   * Should show past date time with almost one month.
   */
  @Test
  fun shouldShowPastDateTimeWithAlmostOneMonth() {
    val calendar = getCalendarInstance().apply { add(DAY_OF_MONTH, -30) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.ABOUT_A_MONTH_PAST.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show future date time with almost one month.
   */
  @Test
  fun shouldShowFutureDateTimeWithAlmostOneMonth() {
    val calendar = getCalendarInstance().apply {
      add(DAY_OF_MONTH, 30)
      add(HOUR, 15)
    }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.ABOUT_A_MONTH_FUTURE.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show past date time with six months.
   */
  @Test
  fun shouldShowPastDateTimeWithSixMonths() {
    val calendar = getCalendarInstance().apply { add(MONTH, -6) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.X_MONTHS_PAST.propertyKey, 6)
    assertEquals(expected, results)
  }

  /**
   * Should show future date time with six months.
   */
  @Test
  fun shouldShowFutureDateTimeWithSixMonths() {
    val calendar = getCalendarInstance().apply { add(MONTH, 6) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.X_MONTHS_FUTURE.propertyKey, 6)
    assertEquals(expected, results)
  }
}
