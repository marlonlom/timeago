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

package com.github.marlonlom.utilities.timeago;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>
 * The Class <b>TimeAgoMessages</b>. it contains a {@link ResourceBundle} for
 * loading and parsing localized messages related to the 'time ago' time syntax.
 * </p>
 * <p>
 * <i>Usage:</i>
 * </p>
 * <p>
 * 1: Using default Locale:
 * <p>
 * <pre>
 * TimeAgoMessages resources = new TimeAgoMessages.Builder().defaultLocale().build();
 * </pre>
 * <p>
 * 2: Using a specific Locale by language tag:
 * <p>
 * <pre>
 * Locale LocaleBylanguageTag = Locale.forLanguageTag("es");
 * TimeAgoMessages resources = new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build();
 * </pre>
 * <p>
 * <i>Tip: available languages for messages: spanish (es), english (en), german
 * (de), french (fr), italian (it), portuguese (pt)</i>
 * </p>
 *
 * @author marlonlom
 * @version 3.0.1
 * @since   1.0.0
 */
public final class TimeAgoMessages {

    /**
     * The property path for MESSAGES.
     */
    private static final String MESSAGES = "com.github.marlonlom.utilities.timeago.messages";
    /**
     * The bundle.
     */
    private ResourceBundle bundle;

    /**
     * Instantiates a new time ago messages.
     */
    private TimeAgoMessages() {
        super();
    }

    /**
     * Gets the bundle.
     *
     * @return the bundle
     */
    private ResourceBundle getBundle() {
        return bundle;
    }

    /**
     * Sets the resource bundle.
     *
     * @param bundle the new resource bundle
     */
    private void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    /**
     * Gets the property value.
     *
     * @param property the property key
     * @return the property value
     */
    public String getPropertyValue(final String property) {
        final String propertyVal = getBundle().getString(property);
        return propertyVal;
    }

    /**
     * Gets the property value.
     *
     * @param property the property key
     * @param values   the property values
     * @return the property value
     */
    public String getPropertyValue(final String property, Object... values) {
        String propertyVal = getPropertyValue(property);
        return MessageFormat.format(propertyVal, values);
    }

    /**
     * The Inner Class Builder for <i>TimeAgoMessages</i>.
     *
     * @author marlonlom
     */
    public static final class Builder {

        /**
         * The inner bundle.
         */
        private ResourceBundle innerBundle;

        /**
         * Builds the TimeAgoMessages instance.
         *
         * @return the time ago messages instance.
         */
        public TimeAgoMessages build() {
            TimeAgoMessages resources = new TimeAgoMessages();
            resources.setBundle(this.getInnerBundle());
            return resources;
        }

        /**
         * Build messages with the default locale.
         *
         * @return the builder
         */
        public Builder defaultLocale() {
            this.setInnerBundle(ResourceBundle.getBundle(TimeAgoMessages.MESSAGES));
            return this;
        }

        /**
         * Gets the inner bundle.
         *
         * @return the inner bundle
         */
        public ResourceBundle getInnerBundle() {
            return innerBundle;
        }

        /**
         * Sets the inner bundle.
         *
         * @param bundle the new inner bundle
         */
        public void setInnerBundle(ResourceBundle bundle) {
            this.innerBundle = bundle;
        }

        /**
         * Build messages with the selected locale.
         *
         * @param locale the locale
         * @return the builder
         */
        public Builder withLocale(Locale locale) {
            this.setInnerBundle(ResourceBundle.getBundle(TimeAgoMessages.MESSAGES, locale));
            return this;
        }
    }
}