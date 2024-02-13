package com.github.marlonlom.timeago.sample.ui

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.marlonlom.timeago.sample.R
import com.github.marlonlom.timeago.sample.utils.CalendarSampleDataUtil
import com.github.marlonlom.timeago.sample.utils.SupportedLanguageSelector
import com.github.marlonlom.utilities.timeago.TimeAgo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * A placeholder fragment containing a simple view.
 *
 * @author marlonlom
 */
class PlaceholderFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val rootView = inflater.inflate(R.layout.fragment_main_tabs, container, false)
    prepareInformationByTabNumber(rootView)
    return rootView
  }

  @Suppress("DEPRECATION")
  private fun prepareInformationByTabNumber(rootView: View) {
    val tabRef = requireArguments().getInt(ARG_SECTION_NUMBER)
    val stringBuilder = StringBuilder()
    val tabDetailTpl = getString(R.string.tabbed_main_detail_item)
    when (tabRef) {
      0 -> stringBuilder.append(
        getString(
          R.string.tabbed_main_detail_how_to,
          SupportedLanguageSelector.availableLanguageText
        )
      )

      1 -> prepareUsageDatesInformation(
        stringBuilder = stringBuilder,
        tabDetailTpl = tabDetailTpl,
        isPast = true
      )

      2 -> prepareUsageDatesInformation(
        stringBuilder = stringBuilder,
        tabDetailTpl = tabDetailTpl,
        isPast = false
      )
    }

    val sectionLabel = rootView.findViewById<TextView>(R.id.section_label)
    sectionLabel.text = Html.fromHtml(stringBuilder.toString())
  }

  /**
   * Prepare usage dates information.
   *
   * @param stringBuilder String builder.
   * @param tabDetailTpl Tab detail text template.
   * @param isPast True/False if past times handling.
   * @param sdf Simple date format.
   * @param currentTime Current time as millis.
   * @param languageCode Provided language code.
   */
  private fun prepareUsageDatesInformation(
    stringBuilder: StringBuilder,
    tabDetailTpl: String,
    isPast: Boolean,
    sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()),
    currentTime: Long = Calendar.getInstance().timeInMillis,
    /* Change the language code as parameter for the [TimeAgoMessages] config here. */
    languageCode: String = "es"
  ) {
    val arrayList = ArrayList<Long>()
    arrayList.add(currentTime)
    arrayList.addAll(CalendarSampleDataUtil.buildDateTimeList(currentTime, isPast))

    val timeAgoMessages = SupportedLanguageSelector.getTimeAgoMessagesByLang(languageCode)

    val builder1 = StringBuilder()
    builder1.append(getHeadingText(languageCode, isPast))

    for (item in arrayList) {
      val calendar = Calendar.getInstance()
      calendar.timeInMillis = item
      val formattedDate = sdf.format(calendar.time)
      val resultText = TimeAgo.using(item, timeAgoMessages)
      builder1.append(String.format(tabDetailTpl, formattedDate, resultText))
    }

    val resId = if (isPast) R.string.tabbed_main_detail_from else R.string.tabbed_main_detail_until
    stringBuilder.append(getString(resId, builder1.toString()))
  }

  /**
   * Returns heading text for elapsed and remaining tab contents.
   *
   * @param languageCode Provided language code.
   * @param isPast True/False if past times handling.
   *
   * @return Generated heading text.
   */
  private fun getHeadingText(languageCode: String, isPast: Boolean): String {
    val timelineText = when {
      isPast -> getString(R.string.tabbed_main_heading_past)
      else -> getString(R.string.tabbed_main_heading_future)
    }

    val languageText = SupportedLanguageSelector.getLanguageTextFor(languageCode)

    return getString(R.string.tabbed_main_heading, timelineText, languageText)
  }

  companion object {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private const val ARG_SECTION_NUMBER = "section_number"

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     *
     * @param sectionNumber the section number
     * @return the placeholder fragment
     */
    fun newInstance(sectionNumber: Int): PlaceholderFragment {
      val fragment = PlaceholderFragment()
      val args = Bundle()
      args.putInt(ARG_SECTION_NUMBER, sectionNumber)
      fragment.arguments = args
      return fragment
    }
  }
}
