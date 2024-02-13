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

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 *
 * @author marlonlom
 *
 * @constructor
 * Instantiates a new Sections pager adapter.
 *
 * @param fragmentActivity Fragment activity.
 */
class SectionsPagerAdapter(
  fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

  override fun getItemCount(): Int = 3

  override fun createFragment(position: Int): Fragment =
    PlaceholderFragment.newInstance(position)

}
