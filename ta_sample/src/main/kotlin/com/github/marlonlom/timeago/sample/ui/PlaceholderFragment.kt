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
    val builder = StringBuilder()
    val currentTime = Calendar.getInstance().timeInMillis
    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())
    val tabDetailTpl = getString(R.string.tabbed_main_detail_item)

    when (tabRef) {
      0 -> builder.append(getString(R.string.tabbed_main_detail_how_to))
      1 -> prepareUsageDatesInformation(builder, currentTime, sdf, tabDetailTpl, true)
      2 -> prepareUsageDatesInformation(builder, currentTime, sdf, tabDetailTpl, false)
    }

    val sectionLabel = rootView.findViewById<TextView>(R.id.section_label)
    sectionLabel.text = Html.fromHtml(builder.toString())
  }

  /**
   * Prepare usage dates information.
   *
   * @param builder      the builder
   * @param currentTime  the current time
   * @param sdf          the simple date format
   * @param tabDetailTpl the tab detail text template
   * @param isPast       true/false if past times handling
   */
  private fun prepareUsageDatesInformation(
    builder: StringBuilder, currentTime: Long,
    sdf: SimpleDateFormat, tabDetailTpl: String,
    isPast: Boolean
  ) {
    val arrayList = ArrayList<Long>()
    arrayList.add(currentTime)
    arrayList.addAll(CalendarSampleDataUtil.buildDateTimeList(currentTime, isPast))
    val builder1 = StringBuilder()
    for (item in arrayList) {
      val calendar = Calendar.getInstance()
      calendar.timeInMillis = item
      val formattedDate = sdf.format(calendar.time)
      val resultText = TimeAgo.using(item)
      builder1.append(String.format(tabDetailTpl, formattedDate, resultText))
    }
    val resId = if (isPast) R.string.tabbed_main_detail_from else R.string.tabbed_main_detail_until
    builder.append(getString(resId, builder1.toString()))
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
