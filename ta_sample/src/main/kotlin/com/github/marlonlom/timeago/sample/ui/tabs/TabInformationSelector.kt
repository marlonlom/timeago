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
package com.github.marlonlom.timeago.sample.ui.tabs

import android.content.res.Resources
import com.github.marlonlom.timeago.sample.R
import com.github.marlonlom.timeago.sample.utils.CalendarSampleDataUtil
import com.github.marlonlom.timeago.sample.utils.SupportedLanguageSelector
import com.github.marlonlom.utilities.timeago.TimeAgo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Sample tab information selector single object.
 *
 * @author marlonlom
 */
object TabInformationSelector {

  /**
   * Prepare usage dates information.
   *
   * @param resources Application context.
   * @param tabDetailTpl Tab detail text template.
   * @param isPast True/False if past times handling.
   * @param sdf Simple date format.
   * @param currentTime Current time as millis.
   * @param languageCode Provided language code. See [SupportedLanguageSelector] for available languages.
   *
   * @see SupportedLanguageSelector
   *
   * @return Dates usage information as text.
   */
  fun prepareUsageDatesInformation(
    resources: Resources,
    tabDetailTpl: String,
    isPast: Boolean,
    sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()),
    currentTime: Long = Calendar.getInstance().timeInMillis,
    /* Change the language code as parameter for the [TimeAgoMessages] config here. */
    languageCode: String = Locale.getDefault().language,
  ): String {
    val arrayList = ArrayList<Long>()
    arrayList.add(currentTime)
    arrayList.addAll(CalendarSampleDataUtil.buildDateTimeList(currentTime, isPast))

    val timeAgoMessages = SupportedLanguageSelector.getTimeAgoMessagesByLang(languageCode)

    val builder1 = StringBuilder()
    builder1.append(getHeadingText(resources, languageCode, isPast))

    for (item in arrayList) {
      val calendar = Calendar.getInstance()
      calendar.timeInMillis = item
      val formattedDate = sdf.format(calendar.time)
      val resultText = TimeAgo.using(item, timeAgoMessages)
      builder1.append(String.format(tabDetailTpl, formattedDate, resultText))
    }

    val resId = if (isPast) R.string.tabbed_main_detail_from else R.string.tabbed_main_detail_until
    return resources.getString(resId, builder1.toString())
  }

  /**
   * Returns heading text for elapsed and remaining tab contents.
   *
   * @param resources Application context.
   * @param languageCode Provided language code.
   * @param isPast True/False if past times handling.
   *
   * @return Generated heading text.
   */
  private fun getHeadingText(resources: Resources, languageCode: String, isPast: Boolean): String {
    val timelineText = when {
      isPast -> resources.getString(R.string.tabbed_main_heading_past)
      else -> resources.getString(R.string.tabbed_main_heading_future)
    }
    val languageText = SupportedLanguageSelector.getLanguageTextFor(languageCode)
    return resources.getString(R.string.tabbed_main_heading, timelineText, languageText)
  }
}
