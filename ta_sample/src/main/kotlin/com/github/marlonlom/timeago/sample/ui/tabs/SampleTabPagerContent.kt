package com.github.marlonlom.timeago.sample.ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.marlonlom.timeago.sample.R


@Composable
internal fun SampleTabPagerContent(
  pagerState: PagerState,
  sampleTabs: SampleTabItems
) {
  val context = LocalContext.current
  val topMargin = context.resources.getDimension(R.dimen.appbar_padding_top)
  val horizontalMargin = context.resources.getDimension(R.dimen.activity_horizontal_margin)
  HorizontalPager(
    modifier = Modifier
      .fillMaxSize()
      .padding(
        PaddingValues(
          top = topMargin.dp,
          start = horizontalMargin.dp,
          end = horizontalMargin.dp
        )
      ),
    verticalAlignment = Alignment.Top,
    state = pagerState
  ) {
    sampleTabs[it].also {
      val annotatedString = buildAnnotatedString {
        append(AnnotatedString.fromHtml(it.information))
      }
      Column(
        Modifier.verticalScroll(rememberScrollState())
      ) {
        Text(
          modifier = Modifier
            .fillMaxWidth(),
          text = annotatedString,
          textAlign = TextAlign.Start,
          color = MaterialTheme.colorScheme.onSurface
        )
      }
    }
  }
}
