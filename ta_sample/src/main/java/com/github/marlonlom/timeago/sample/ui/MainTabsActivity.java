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

package com.github.marlonlom.timeago.sample.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.marlonlom.timeago.sample.R;
import com.github.marlonlom.timeago.sample.utils.CalendarSampleDataUtil;
import com.github.marlonlom.utilities.timeago.TimeAgo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * The type Main tabs activity.
 */
public class MainTabsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Instantiates a new Placeholder fragment.
         */
        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         *
         * @param sectionNumber the section number
         * @return the placeholder fragment
         */
        public static PlaceholderFragment newInstance(final int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main_tabs, container, false);
            prepareInformationByTabNumber(rootView);
            return rootView;
        }

        private void prepareInformationByTabNumber(final View rootView) {
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            final int tabRef = getArguments().getInt(ARG_SECTION_NUMBER);
            final StringBuilder builder = new StringBuilder();
            final long currentTime = Calendar.getInstance().getTimeInMillis();
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
            final String tabDetailTpl = getString(R.string.tabbed_main_detail_item);
            switch (tabRef) {
                case 0:
                    builder.append(getString(R.string.tabbed_main_detail_how_to));
                    break;
                case 1:
                    prepareUsageDatesInformation(builder, currentTime, sdf, tabDetailTpl, true);
                    break;
                case 2:
                    prepareUsageDatesInformation(builder, currentTime, sdf, tabDetailTpl, false);
                    break;
            }
            textView.setText(Html.fromHtml(builder.toString()));
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
        private void prepareUsageDatesInformation(final StringBuilder builder, final long currentTime,
                                                  final SimpleDateFormat sdf, final String tabDetailTpl,
                                                  final boolean isPast) {
            final List<Long> arrayList = new ArrayList<>();
            arrayList.add(currentTime);
            arrayList.addAll(CalendarSampleDataUtil.buildDateTimeList(currentTime, isPast));
            final StringBuilder builder1 = new StringBuilder();
            for (final Long item : arrayList) {
                final Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(item);
                final String formattedDate = sdf.format(calendar.getTime());
                final String resultText = TimeAgo.using(item);
                builder1.append(String.format(tabDetailTpl, formattedDate, resultText));
            }
            final int resId = isPast ? R.string.tabbed_main_detail_from : R.string.tabbed_main_detail_until;
            builder.append(getString(resId, builder1.toString()));
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        /**
         * Instantiates a new Sections pager adapter.
         *
         * @param fm the fragment manager
         */
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.tabbed_main_tab_how_to);
                case 1:
                    return getString(R.string.tabbed_main_tab_from);
                case 2:
                    return getString(R.string.tabbed_main_tab_until);
            }
            return null;
        }
    }
}
