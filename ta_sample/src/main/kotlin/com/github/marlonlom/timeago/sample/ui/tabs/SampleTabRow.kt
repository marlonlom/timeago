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

import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun SampleTabRow(pagerState: PagerState, sampleTabs: SampleTabItems, coroutineScope: CoroutineScope) = TabRow(
  containerColor = MaterialTheme.colorScheme.background,
  contentColor = MaterialTheme.colorScheme.onBackground,
  selectedTabIndex = pagerState.currentPage,
) {
  sampleTabs.forEachIndexed { index, item ->
    Tab(
      unselectedContentColor = MaterialTheme.colorScheme.onBackground,
      selectedContentColor = MaterialTheme.colorScheme.primary,
      text = { Text(item.title) },
      icon = { item.icon?.also { Icon(it, null) } },
      selected = pagerState.currentPage == index,
      onClick = {
        coroutineScope.launch {
          pagerState.animateScrollToPage(index)
        }
      },
    )
  }
}
