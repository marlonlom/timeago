package com.github.marlonlom.utilities.timeago

/**
 * Interface definition for handling distance validations or periods.
 *
 * @author marlonlom
 * @version 4.1.0
 * @see Periods
 *
 * @since 1.0.0
 */
internal interface DistancePredicate {
  /**
   * Validate distance minutes boolean.
   *
   * @param distance the distance
   * @return the boolean
   */
  fun validateDistanceMinutes(distance: Long): Boolean
}
