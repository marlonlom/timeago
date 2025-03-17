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
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR
import java.util.ResourceBundle
import java.util.Calendar.getInstance as getCalendarInstance

/**
 * Unit tests class for TimeAgo years usage.
 *
 * @author marlonlom
 * @version 4.1.0
 * @since 2.1.0
 */
@RunWith(JUnit4::class)
internal class YearsAgoTest {

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
   * Should show past date time with almost two years.
   */
  @Test
  fun shouldShowPastDateTimeWithAlmostTwoYears() {
    val calendar = getCalendarInstance().apply {
      add(MONTH, -10)
      add(YEAR, -1)
    }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.ALMOST_TWO_YEARS_PAST.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show future date time with almost two years.
   */
  @Test
  fun shouldShowFutureDateTimeWithAlmostTwoYears() {
    val calendar = getCalendarInstance().apply {
      add(MONTH, 10)
      add(YEAR, 1)
    }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.ALMOST_TWO_YEARS_FUTURE.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show past date time over one year.
   */
  @Test
  fun shouldShowPastDateTimeOverOneYear() {
    val calendar = getCalendarInstance().apply {
      add(MONTH, -4)
      add(YEAR, -1)
    }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.OVER_A_YEAR_PAST.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show past date time with almost one year.
   */
  @Test
  fun shouldShowPastDateTimeWithAlmostOneYear() {
    val calendar = getCalendarInstance().apply { add(MONTH, -12) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.ABOUT_A_YEAR_PAST.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show past date time with more than one year.
   */
  @Test
  fun shouldShowPastDateTimeWithMoreThanOneYear() {
    val calendar = getCalendarInstance().apply { add(YEAR, -2) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.X_YEARS_PAST.propertyKey, 2)
    assertEquals(expected, results)
  }

  /**
   * Should show future date time over one year.
   */
  @Test
  fun shouldShowFutureDateTimeOverOneYear() {
    val calendar = getCalendarInstance().apply {
      add(MONTH, 4)
      add(YEAR, 1)
    }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.OVER_A_YEAR_FUTURE.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show future date time with almost one year.
   */
  @Test
  fun shouldShowFutureDateTimeWithAlmostOneYear() {
    val calendar = getCalendarInstance().apply { add(MONTH, 12) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.ABOUT_A_YEAR_FUTURE.propertyKey)
    assertEquals(expected, results)
  }

  /**
   * Should show future date time with more than one year.
   */
  @Test
  fun shouldShowFutureDateTimeWithMoreThanOneYear() {
    val calendar = getCalendarInstance().apply { add(YEAR, 3) }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.X_YEARS_FUTURE.propertyKey, 3)
    assertEquals(expected, results)
  }
}
