package com.github.marlonlom.utilities.timeago

import kotlin.math.roundToLong

/**
 * The enum Periods.
 *
 * @author marlonlom
 * @version 4.1.0
 * @since 2.0.0
 */
internal enum class Periods(
  /**
   * The property key.
   */
  val propertyKey: String,
  /**
   * The predicate.
   */
  private val predicate: DistancePredicate,
) {

  NOW(
    "ml.timeago.now",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 0L..0.99.toLong()
    },
  ),
  ONE_MINUTE_PAST(
    "ml.timeago.oneminute.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance == 1L
    },
  ),
  X_MINUTES_PAST(
    "ml.timeago.xminutes.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 2..44
    },
  ),
  ABOUT_AN_HOUR_PAST(
    "ml.timeago.aboutanhour.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 45..89
    },
  ),
  X_HOURS_PAST(
    "ml.timeago.xhours.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 90..1439
    },
  ),
  ONE_DAY_PAST(
    "ml.timeago.oneday.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 1440..2519
    },
  ),
  X_DAYS_PAST(
    "ml.timeago.xdays.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 2520..10079
    },
  ),
  ONE_WEEK_PAST(
    "ml.timeago.oneweek.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 10080..20159
    },
  ),
  X_WEEKS_PAST(
    "ml.timeago.xweeks.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 20160..43199
    },
  ),
  ABOUT_A_MONTH_PAST(
    "ml.timeago.aboutamonth.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 43200..86399
    },
  ),
  X_MONTHS_PAST(
    "ml.timeago.xmonths.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 86400..525599
    },
  ),
  ABOUT_A_YEAR_PAST(
    "ml.timeago.aboutayear.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 525600..655199
    },
  ),
  OVER_A_YEAR_PAST(
    "ml.timeago.overayear.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 655200..914399
    },
  ),
  ALMOST_TWO_YEARS_PAST(
    "ml.timeago.almosttwoyears.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance in 914400..1051199
    },
  ),
  X_YEARS_PAST(
    "ml.timeago.xyears.past",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = (distance / 525600).toFloat().roundToLong() > 1
    },
  ),
  ONE_MINUTE_FUTURE(
    "ml.timeago.oneminute.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance.toInt() == -1
    },
  ),
  X_MINUTES_FUTURE(
    "ml.timeago.xminutes.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -2 && distance >= -44
    },
  ),
  ABOUT_AN_HOUR_FUTURE(
    "ml.timeago.aboutanhour.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -45 && distance >= -89
    },
  ),
  X_HOURS_FUTURE(
    "ml.timeago.xhours.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -90 && distance >= -1439
    },
  ),
  ONE_DAY_FUTURE(
    "ml.timeago.oneday.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -1440 && distance >= -2519
    },
  ),
  X_DAYS_FUTURE(
    "ml.timeago.xdays.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -2520 && distance >= -10079
    },
  ),
  ONE_WEEK_FUTURE(
    "ml.timeago.oneweek.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -10080 && distance >= -20159
    },
  ),
  X_WEEKS_FUTURE(
    "ml.timeago.xweeks.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -20160 && distance >= -43199
    },
  ),
  ABOUT_A_MONTH_FUTURE(
    "ml.timeago.aboutamonth.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -43200 && distance >= -86399
    },
  ),
  X_MONTHS_FUTURE(
    "ml.timeago.xmonths.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -86400 && distance >= -525599
    },
  ),
  ABOUT_A_YEAR_FUTURE(
    "ml.timeago.aboutayear.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -525600 && distance >= -655199
    },
  ),
  OVER_A_YEAR_FUTURE(
    "ml.timeago.overayear.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -655200 && distance >= -914399
    },
  ),
  ALMOST_TWO_YEARS_FUTURE(
    "ml.timeago.almosttwoyears.future",
    object : DistancePredicate {
      override fun validateDistanceMinutes(distance: Long): Boolean = distance <= -914400 && distance >= -1051199
    },
  ),
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
