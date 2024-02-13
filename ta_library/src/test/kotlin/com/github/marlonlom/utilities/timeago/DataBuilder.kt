package com.github.marlonlom.utilities.timeago

import java.util.*

object DataBuilder {

    /**
     * The available languages array.
     */
    private val LANGUAGES_ARRAY = "ar;cs;da;de;en;es;eu;fa;fr;in;it;nl;pt;tr;zh;zh_tw".split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

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