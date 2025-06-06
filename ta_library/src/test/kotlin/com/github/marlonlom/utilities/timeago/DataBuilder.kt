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

import java.util.*

object DataBuilder {

  /**
   * The available languages array.
   */
  private val LANGUAGES_ARRAY = "ar;cs;da;de;en;es;eu;fa;fil;fr;in;it;ja;ko;nl;pt;tr;zh;zh_tw".split(
    ";".toRegex(),
  ).dropLastWhile {
    it.isEmpty()
  }.toTypedArray()

  /**
   * Constant for bundle name
   */
  private const val BUNDLE_NAME = "com.github.marlonlom.utilities.timeago.messages"

  /**
   * Gets random language reference.
   *
   * @return the random language code
   */
  val randomLanguageRef: String
    get() = LANGUAGES_ARRAY[Random().nextInt(LANGUAGES_ARRAY.size)]

  /**
   * Gets expected message.
   *
   * @param bundle the resource bundle for getting messages by key
   * @param key    the key
   * @param values the values
   * @return the expected message
   */
  fun getExpectedMessage(bundle: ResourceBundle, key: String, vararg values: Int): String {
    val bundledMessage = bundle.getString(key)
    return if (values.isNotEmpty()) bundledMessage.replace("{0}", values[0].toString()) else bundledMessage
  }

  /**
   * Builds a new TimeAgo messages bundle with selected language code.
   *
   * @param languageRef language code for getting locale tag.
   * @return new messages bundle.
   */
  fun newMessagesResource(languageRef: String): TimeAgoMessages =
    TimeAgoMessages.Builder().withLocale(Locale.forLanguageTag(languageRef)).build()

  /**
   * Generates a new Resource bundle with selected language code.
   *
   * @param languageRef language code for getting locale tag.
   * @return new resource bundle.
   */
  fun newLocalBundle(languageRef: String): ResourceBundle =
    ResourceBundle.getBundle(BUNDLE_NAME, Locale.forLanguageTag(languageRef))

  /**
   * Uses the TimeAgo utility for getting 'time ago' formatted text.
   *
   * @param timeInMillis time in milliseconds for time comparison.
   * @param messages messages bundle for language related messaging.
   *
   * @return formatted text with 'time ago' format applied.
   */
  fun useTimeAgo(timeInMillis: Long, messages: TimeAgoMessages): String = TimeAgo.using(timeInMillis, messages)
}
