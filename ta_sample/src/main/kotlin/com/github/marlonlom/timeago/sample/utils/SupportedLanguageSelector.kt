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
package com.github.marlonlom.timeago.sample.utils

import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import java.util.Locale

/**
 * Supported language selector single object.
 *
 * @author marlonlom
 */
object SupportedLanguageSelector {

  /** Available supported languages as Map. */
  private val languagesInventory = mapOf(
    "ar" to "Arabic",
    "cs" to "Czech",
    "da" to "Danish",
    "de" to "German",
    "en" to "English",
    "es" to "Spanish",
    "eu" to "Basque",
    "fa" to "Farsi",
    "fr" to "French",
    "hi" to "Hindi",
    "hu" to "Hungarian",
    "in" to "Indonesian",
    "it" to "Italian",
    "nl" to "Dutch",
    "pl" to "Polish",
    "pt" to "Portuguese",
    "tr" to "Turkish",
    "zh" to "Chinese",
    "zh-TW" to "Chinese/Taiwan",
  )

  /** Available supported languages text. */
  val availableLanguageText: String
    get() = languagesInventory.map { entry ->
      "${entry.value} (${entry.key})"
    }.joinToString(", ")

  /**
   * Returns the [TimeAgoMessages] config for selected language code.
   * if [lang] is empty, or is not found in the available languages inventory,
   * returns the default messages config provided by TimeAgo utility.
   *
   * @param lang Language code (es, en, ... etc.)
   *
   * @return [TimeAgoMessages] config.
   */
  fun getTimeAgoMessagesByLang(lang: String): TimeAgoMessages = when {
    languagesInventory.containsKey(lang) -> TimeAgoMessages.Builder()
      .withLocale(Locale.forLanguageTag(lang))
      .build()

    else -> TimeAgoMessages.Builder()
      .defaultLocale().build()
  }

  /**
   * Returns language text for selected language code.
   * if [lang] is empty, or is not found in the available languages inventory,
   * it uses the default language (en) instead.
   *
   * @param lang Language code (es, en, ... etc.)
   *
   * @return Selected language text.
   */
  fun getLanguageTextFor(lang: String): String = languagesInventory[
    when {
      languagesInventory.containsKey(lang) -> lang
      else -> "en"
    },
  ].let { "$it ($lang)" }
}
