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

import kotlin.math.abs
import kotlin.math.roundToLong

/**
 * Period messages builder object.
 *
 * @author marlonlom
 * @version 4.2.0
 * @since 4.1.0
 */
internal object PeriodMessages {

  /**
   * Handle period key as plural string.
   *
   * @param resources the resources
   * @param periodKey the period key
   * @param value     the value
   * @return the string
   */
  private fun handlePeriodKeyAsPlural(
    resources: TimeAgoMessages,
    periodKey: String,
    pluralKey: String,
    value: Int,
  ): String = if (value == 1) resources.getPropertyValue(periodKey) else resources.getPropertyValue(pluralKey, value)

  /**
   * Returns text for past x minutes.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x minutes.
   */
  fun getPastXMinutesText(resources: TimeAgoMessages, dim: Long, periodKey: String): String =
    resources.getPropertyValue(periodKey, dim)

  /**
   * Returns text for past x hours.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x hours.
   */
  fun getPastXHoursText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val hours = (dim / 60f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.aboutanhour.past",
      periodKey,
      hours.toInt(),
    )
  }

  /**
   * Returns text for past x days.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x days.
   */
  fun getPastXDaysText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val days = (dim / 1440f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneday.past",
      periodKey,
      days.toInt(),
    )
  }

  /**
   * Returns text for past x weeks.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x weeks.
   */
  fun getPastXWeeksText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val weeks = (dim / 10080f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneweek.past",
      periodKey,
      weeks.toInt(),
    )
  }

  /**
   * Returns text for past x months.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x months.
   */
  fun getPastXMonthsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val months = (dim / 43200f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.aboutamonth.past",
      periodKey,
      months.toInt(),
    )
  }

  /**
   * Returns text for past x years.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x years.
   */
  fun getPastXYearsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val years = (dim / 525600f).roundToLong()
    return resources.getPropertyValue(periodKey, years)
  }

  /**
   * Returns text for future x minutes.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x minutes.
   */
  fun getFutureXMinutesText(resources: TimeAgoMessages, dim: Long, periodKey: String): String =
    resources.getPropertyValue(periodKey, abs(dim.toFloat()))

  /**
   * Returns text for future x hours.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x hours.
   */
  fun getFutureXHoursText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val hours = abs((dim / 60f).roundToLong())
    return if (hours.toInt() == 24) {
      resources.getPropertyValue("ml.timeago.oneday.future")
    } else {
      handlePeriodKeyAsPlural(
        resources,
        "ml.timeago.aboutanhour.future",
        periodKey,
        hours.toInt(),
      )
    }
  }

  /**
   * Returns text for future x days.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x daye.
   */
  fun getFutureXDaysText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val days1 = abs((dim / 1440f).roundToLong())
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneday.future",
      periodKey,
      days1.toInt(),
    )
  }

  /**
   * Returns text for future x weeks.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x weeks.
   */
  fun getFutureXWeeksText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val weeks = abs((dim / 10080f).roundToLong())
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneweek.future",
      periodKey,
      weeks.toInt(),
    )
  }

  /**
   * Returns text for future x months.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x months.
   */
  fun getFutureXMonthsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val months = abs((dim / 43200f).roundToLong())
    return if (months.toInt() == 12) {
      resources.getPropertyValue("ml.timeago.aboutayear.future")
    } else {
      handlePeriodKeyAsPlural(
        resources,
        "ml.timeago.aboutamonth.future",
        periodKey,
        months.toInt(),
      )
    }
  }

  /**
   * Returns text for future x years.
   *
   * @param resources TimeAgo messages bundle.
   * @param dim Difference in minutes calculation result.
   * @param periodKey Period key name.
   * @return text for future x years.
   */
  fun getFutureXYearsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val years = abs((dim / 525600f).roundToLong())
    return resources.getPropertyValue(periodKey, years)
  }
}
