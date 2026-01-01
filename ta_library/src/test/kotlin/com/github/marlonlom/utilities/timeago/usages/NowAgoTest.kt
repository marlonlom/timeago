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
import java.util.Calendar
import java.util.Calendar.MILLISECOND
import java.util.ResourceBundle

/**
 * Unit tests class for TimeAgo usage for current date time.
 *
 * @author marlonlom
 * @version 4.2.0
 * @since 2.1.0
 */
@RunWith(JUnit4::class)
internal class NowAgoTest {

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
   * Should show actual date time.
   */
  @Test
  fun shouldShowDateTimeNow() {
    val calendar = Calendar.getInstance().apply {
      add(MILLISECOND, (get(MILLISECOND) + 1) * -1)
    }
    val results = useTimeAgo(calendar.timeInMillis, timeAgoMessages)
    val expected = getExpectedMessage(localBundle!!, Periods.NOW.propertyKey)
    assertEquals(expected, results)
  }
}
