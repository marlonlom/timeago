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
package com.github.marlonlom.timeago.sample.ui.tabs

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.github.marlonlom.timeago.sample.R
import com.github.marlonlom.timeago.sample.utils.SupportedLanguageSelector

/**
 * Sample tab screen composable.
 *
 * @author marlonlom
 */
@Composable
internal fun SampleTabScreen() {
  val context = LocalContext.current

  val tabDetailTpl = context.getString(R.string.tabbed_main_detail_item)
  val sampleTabs = listOf(
    SampleTab(
      icon = Icons.TwoTone.Info,
      title = context.getString(R.string.tabbed_main_tab_how_to),
      information = context.getString(
        R.string.tabbed_main_detail_how_to,
        SupportedLanguageSelector.availableLanguageText,
      ),
    ),
    SampleTab(
      title = context.getString(R.string.tabbed_main_tab_from),
      information = TabInformationSelector.prepareUsageDatesInformation(
        context = context,
        tabDetailTpl = tabDetailTpl,
        isPast = true,
      ),
    ),
    SampleTab(
      title = context.getString(R.string.tabbed_main_tab_until),
      information = TabInformationSelector.prepareUsageDatesInformation(
        context = context,
        tabDetailTpl = tabDetailTpl,
        isPast = false,
      ),
    ),
  )

  val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })
  val coroutineScope = rememberCoroutineScope()

  SampleTabRow(pagerState, sampleTabs, coroutineScope)
  SampleTabPagerContent(pagerState, sampleTabs)
}

/**
 * Type alias that represent a list of [SampleTab] items.
 *
 * @author marlonlom
 *
 */
typealias SampleTabItems = List<SampleTab>

/**
 * Sample tab item data class.
 *
 * @author marlonlom
 *
 * @property title Tab title.
 * @property information Tab detailed information.
 * @property icon Tab optional icon as [ImageVector].
 */
data class SampleTab(val title: String, val information: String, val icon: ImageVector? = null)
