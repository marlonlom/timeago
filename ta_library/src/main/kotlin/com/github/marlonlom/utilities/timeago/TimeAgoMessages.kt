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

import java.text.MessageFormat
import java.util.*

/**
 * The Class **TimeAgoMessages**. it contains a [ResourceBundle] for
 * loading and parsing localized messages related to the 'time ago' time syntax.
 *
 * Usage:*
 *
 * 1: Using default Locale:
 *
 * <pre>
 * TimeAgoMessages resources = new TimeAgoMessages.Builder().defaultLocale().build();
 * </pre>
 *
 * 2: Using a specific Locale by language tag:
 *
 * <pre>
 * Locale localeByLanguageTag = Locale.forLanguageTag("es");
 * TimeAgoMessages resources = new TimeAgoMessages.Builder().withLocale(localeByLanguageTag).build();
 * </pre>
 *
 *
 * *Tip: available languages for messages: spanish (es), english (en), german
 * (de), french (fr), italian (it), portuguese (pt) and more...*
 *
 *
 * @author marlonlom
 * @version 4.2.0
 * @since 1.0.0
 */
class TimeAgoMessages private constructor() {
  /**
   * The resource bundle for holding the language messages.
   */
  private var bundle: ResourceBundle? = null

  /**
   * Gets the property value.
   *
   * @param property the property key
   * @return the property value
   */
  fun getPropertyValue(property: String): String = bundle!!.getString(property)

  /**
   * Gets the property value.
   *
   * @param property the property key
   * @param values   the property values
   * @return the property value
   */
  fun getPropertyValue(property: String, vararg values: Any): String {
    val propertyVal = getPropertyValue(property)
    return MessageFormat.format(propertyVal, *values)
  }

  /**
   * The Inner Class Builder for *TimeAgoMessages*.
   *
   * @author marlonlom
   */
  class Builder {

    /**
     * The inner bundle.
     */
    private var innerBundle: ResourceBundle? = null

    /**
     * Builds the TimeAgoMessages instance.
     *
     * @return the time ago messages instance.
     */
    fun build(): TimeAgoMessages {
      val resources = TimeAgoMessages()
      resources.bundle = this.innerBundle
      return resources
    }

    /**
     * Build messages with the default locale.
     *
     * @return the builder
     */
    fun defaultLocale(): Builder {
      this.innerBundle = ResourceBundle.getBundle(MESSAGES)
      return this
    }

    /**
     * Build messages with the selected locale.
     *
     * @param locale the locale
     * @return the builder
     */
    fun withLocale(locale: Locale): Builder {
      this.innerBundle = ResourceBundle.getBundle(MESSAGES, locale)
      return this
    }
  }

  companion object {

    /**
     * The property path for MESSAGES.
     */
    private const val MESSAGES = "com.github.marlonlom.utilities.timeago.messages"
  }
}
