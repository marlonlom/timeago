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

import kotlin.math.roundToLong

/**
 * The enum Periods.
 *
 * @author marlonlom
 * @version 4.1.0
 * @since 2.0.0
 *
 * @property propertyKey Property key.
 * @property predicate Distance predicate definition.
 */
internal enum class Periods(val propertyKey: String, private val predicate: DistancePredicate) {

  /** TimeAgo Period Enum: Now */
  NOW(
    "ml.timeago.now",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 0L..0.99.toLong()
    },
  ),

  /** TimeAgo Period Enum: Past one minute */
  ONE_MINUTE_PAST(
    "ml.timeago.oneminute.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance == 1L
    },
  ),

  /** TimeAgo Period Enum: Past x minute */
  X_MINUTES_PAST(
    "ml.timeago.xminutes.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 2..44
    },
  ),

  /** TimeAgo Period Enum: About an hour in the past. */
  ABOUT_AN_HOUR_PAST(
    "ml.timeago.aboutanhour.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 45..59
    },
  ),

  /** TimeAgo Period Enum: Past one hour. */
  ONE_HOUR_PAST(
    "ml.timeago.onehour.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 60..119
    },
  ),

  /** TimeAgo Period Enum: Past x hours. */
  X_HOURS_PAST(
    "ml.timeago.xhours.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 120..1439
    },
  ),

  /** TimeAgo Period Enum: Past one day. */
  ONE_DAY_PAST(
    "ml.timeago.oneday.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 1440..2519
    },
  ),

  /** TimeAgo Period Enum: Past x day. */
  X_DAYS_PAST(
    "ml.timeago.xdays.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 2520..10079
    },
  ),

  /** TimeAgo Period Enum: Past one week. */
  ONE_WEEK_PAST(
    "ml.timeago.oneweek.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 10080..20159
    },
  ),

  /** TimeAgo Period Enum: Past x weeks. */
  X_WEEKS_PAST(
    "ml.timeago.xweeks.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 20160..43199
    },
  ),

  /** TimeAgo Period Enum: About a month in the past. */
  ABOUT_A_MONTH_PAST(
    "ml.timeago.aboutamonth.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 43200..86399
    },
  ),

  /** TimeAgo Period Enum: Past x months. */
  X_MONTHS_PAST(
    "ml.timeago.xmonths.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 86400..525599
    },
  ),

  /** TimeAgo Period Enum: About one year in the past. */
  ABOUT_A_YEAR_PAST(
    "ml.timeago.aboutayear.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 525600..655199
    },
  ),

  /** TimeAgo Period Enum: Over a year in the past. */
  OVER_A_YEAR_PAST(
    "ml.timeago.overayear.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 655200..914399
    },
  ),

  /** TimeAgo Period Enum: Almost two years in the past. */
  ALMOST_TWO_YEARS_PAST(
    "ml.timeago.almosttwoyears.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 914400..1051199
    },
  ),

  /** TimeAgo Period Enum: Past x years. */
  X_YEARS_PAST(
    "ml.timeago.xyears.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = (distance / 525600).toFloat().roundToLong() > 1
    },
  ),

  /** TimeAgo Period Enum: One minute in the future. */
  ONE_MINUTE_FUTURE(
    "ml.timeago.oneminute.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance.toInt() == -1
    },
  ),

  /** TimeAgo Period Enum: X minutes in the future. */
  X_MINUTES_FUTURE(
    "ml.timeago.xminutes.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -2 && distance >= -44
    },
  ),

  /** TimeAgo Period Enum: About an hour in the future. */
  ABOUT_AN_HOUR_FUTURE(
    "ml.timeago.aboutanhour.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -45 && distance >= -59
    },
  ),

  /** TimeAgo Period Enum: One hour in the future. */
  ONE_HOUR_FUTURE(
    "ml.timeago.onehour.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -60 && distance >= -119
    },
  ),

  /** TimeAgo Period Enum: X hours in the future. */
  X_HOURS_FUTURE(
    "ml.timeago.xhours.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -120 && distance >= -1439
    },
  ),

  /** TimeAgo Period Enum: One day in the future. */
  ONE_DAY_FUTURE(
    "ml.timeago.oneday.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -1440 && distance >= -2519
    },
  ),

  /** TimeAgo Period Enum: X days in the future. */
  X_DAYS_FUTURE(
    "ml.timeago.xdays.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -2520 && distance >= -10079
    },
  ),

  /** TimeAgo Period Enum: One week in the future. */
  ONE_WEEK_FUTURE(
    "ml.timeago.oneweek.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -10080 && distance >= -20159
    },
  ),

  /** TimeAgo Period Enum: X weeks in the future. */
  X_WEEKS_FUTURE(
    "ml.timeago.xweeks.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -20160 && distance >= -43199
    },
  ),

  /** TimeAgo Period Enum: About a month in the future. */
  ABOUT_A_MONTH_FUTURE(
    "ml.timeago.aboutamonth.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -43200 && distance >= -86399
    },
  ),

  /** TimeAgo Period Enum: X months in the future. */
  X_MONTHS_FUTURE(
    "ml.timeago.xmonths.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -86400 && distance >= -525599
    },
  ),

  /** TimeAgo Period Enum: About a year in the future. */
  ABOUT_A_YEAR_FUTURE(
    "ml.timeago.aboutayear.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -525600 && distance >= -655199
    },
  ),

  /** TimeAgo Period Enum: Over a year in the future. */
  OVER_A_YEAR_FUTURE(
    "ml.timeago.overayear.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -655200 && distance >= -914399
    },
  ),

  /** TimeAgo Period Enum: Almost two years in the future. */
  ALMOST_TWO_YEARS_FUTURE(
    "ml.timeago.almosttwoyears.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -914400 && distance >= -1051199
    },
  ),

  /** TimeAgo Period Enum: X years in the future. */
  X_YEARS_FUTURE(
    "ml.timeago.xyears.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = (distance / 525600).toFloat().roundToLong() < -1
    },
  ),
  ;

  companion object {

    /**
     * Find by distance minutes periods.
     *
     * @param distanceMinutes the distance minutes
     * @return the periods
     */
    fun findByDistanceMinutes(distanceMinutes: Long): Periods? {
      val values = entries.toTypedArray()
      for (item in values) {
        val successful = item.predicate
          .validateDistanceMinutes(distanceMinutes)
        if (successful) {
          return item
        }
      }
      return null
    }
  }
}
