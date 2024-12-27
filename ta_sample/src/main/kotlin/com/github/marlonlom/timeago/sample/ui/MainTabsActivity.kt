/*
 * Copyright (c) 2024, marlonlom
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
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.github.marlonlom.timeago.sample.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * The type Main tabs activity.
 *
 * @author marlonlom
 */
class MainTabsActivity : AppCompatActivity() {

  /**
   * The [FragmentStateAdapter] that will provide fragments for each of the sections.
   */
  private val mSectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_tabs)

    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)

    val mViewPager = findViewById<ViewPager2>(R.id.container)
    mViewPager.adapter = mSectionsPagerAdapter
    val tabLayout = findViewById<TabLayout>(R.id.tabs)

    attachTabLayout(tabLayout, mViewPager)
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
   * Attaches the tab layout and the viewpager.
   *
   * @param tabLayout Tab layout widget.
   * @param mViewPager Viewpager.
   */
  private fun attachTabLayout(
    tabLayout: TabLayout,
    mViewPager: ViewPager2
  ) {
    TabLayoutMediator(
      tabLayout,
      mViewPager
    ) { tab: TabLayout.Tab, position: Int ->
      tab.text = getPageTitle(position)
    }.attach()
  }

  /**
   * Retrieves page title for selected tab position.
   *
   * @param tabPosition Tab position.
   *
   * @return page title, or empty if position not listed.
   */
  private fun getPageTitle(tabPosition: Int) = when (tabPosition) {
    0 -> getString(R.string.tabbed_main_tab_how_to)
    1 -> getString(R.string.tabbed_main_tab_from)
    2 -> getString(R.string.tabbed_main_tab_until)
    else -> ""
  }

}
