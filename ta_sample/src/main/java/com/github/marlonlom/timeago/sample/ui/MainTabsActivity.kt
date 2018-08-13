/*
 * Copyright (c) 2018, marlonlom
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

package com.github.marlonlom.timeago.sample.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.*
import android.widget.TextView
import com.github.marlonlom.timeago.sample.R
import com.github.marlonlom.timeago.sample.utils.CalendarSampleDataUtil
import com.github.marlonlom.utilities.timeago.TimeAgo
import kotlinx.android.synthetic.main.activity_main_tabs.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * The type Main tabs activity.
 *
 * @author marlonlom
 */
class MainTabsActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tabs)

        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_tabs, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_settings -> true
        else -> super.onOptionsItemSelected(item)
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_main_tabs, container, false)
            prepareInformationByTabNumber(rootView)
            return rootView
        }

        @Suppress("DEPRECATION")
        private fun prepareInformationByTabNumber(rootView: View) {
            val tabRef = arguments!!.getInt(ARG_SECTION_NUMBER)
            val builder = StringBuilder()
            val currentTime = Calendar.getInstance().timeInMillis
            val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())
            val tabDetailTpl = getString(R.string.tabbed_main_detail_item)

            when (tabRef) {
                0 -> builder.append(getString(R.string.tabbed_main_detail_how_to))
                1 -> prepareUsageDatesInformation(builder, currentTime, sdf, tabDetailTpl, true)
                2 -> prepareUsageDatesInformation(builder, currentTime, sdf, tabDetailTpl, false)
            }

            val sectionLabel: TextView = rootView.findViewById(R.id.section_label) as TextView
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
        private fun prepareUsageDatesInformation(builder: StringBuilder, currentTime: Long,
                                                 sdf: SimpleDateFormat, tabDetailTpl: String,
                                                 isPast: Boolean) {
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

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter
    /**
     * Instantiates a new Sections pager adapter.
     *
     * @param fm the fragment manager
     */
    (fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment =
                PlaceholderFragment.newInstance(position)

        override fun getCount(): Int = 3

        override fun getPageTitle(position: Int): CharSequence? = when (position) {
            0 -> getString(R.string.tabbed_main_tab_how_to)
            1 -> getString(R.string.tabbed_main_tab_from)
            2 -> getString(R.string.tabbed_main_tab_until)
            else -> null
        }
    }
}
