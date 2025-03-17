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
 * @version 4.1.0
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

  fun getPastXMinutesText(resources: TimeAgoMessages, dim: Long, periodKey: String): String =
    resources.getPropertyValue(periodKey, dim)

  fun getPastXHoursText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val hours = (dim / 60f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.aboutanhour.past",
      periodKey,
      hours.toInt(),
    )
  }

  fun getPastXDaysText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val days = (dim / 1440f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneday.past",
      periodKey,
      days.toInt(),
    )
  }

  fun getPastXWeeksText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val weeks = (dim / 10080f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneweek.past",
      periodKey,
      weeks.toInt(),
    )
  }

  fun getPastXMonthsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val months = (dim / 43200f).roundToLong()
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.aboutamonth.past",
      periodKey,
      months.toInt(),
    )
  }

  fun getPastXYearsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val years = (dim / 525600f).roundToLong()
    return resources.getPropertyValue(periodKey, years)
  }

  fun getFutureXMinutesText(resources: TimeAgoMessages, dim: Long, periodKey: String): String =
    resources.getPropertyValue(periodKey, abs(dim.toFloat()))

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

  fun getFutureXDaysText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val days1 = abs((dim / 1440f).roundToLong())
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneday.future",
      periodKey,
      days1.toInt(),
    )
  }

  fun getFutureXWeeksText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val weeks = abs((dim / 10080f).roundToLong())
    return handlePeriodKeyAsPlural(
      resources,
      "ml.timeago.oneweek.future",
      periodKey,
      weeks.toInt(),
    )
  }

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

  fun getFutureXYearsText(resources: TimeAgoMessages, dim: Long, periodKey: String): String {
    val years = abs((dim / 525600f).roundToLong())
    return resources.getPropertyValue(periodKey, years)
  }
}
