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
