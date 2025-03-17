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
package com.github.marlonlom.utilities.timeago

import com.github.marlonlom.utilities.timeago.usages.DaysAgoTest
import com.github.marlonlom.utilities.timeago.usages.HoursAgoTest
import com.github.marlonlom.utilities.timeago.usages.MinutesAgoTest
import com.github.marlonlom.utilities.timeago.usages.MonthsAgoTest
import com.github.marlonlom.utilities.timeago.usages.NowAgoTest
import com.github.marlonlom.utilities.timeago.usages.WeeksAgoTest
import com.github.marlonlom.utilities.timeago.usages.YearsAgoTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Unit tests suite class for TimeAgo usage.
 *
 * @author marlonlom
 * @version 4.1.0
 * @since 4.1.0
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
  NowAgoTest::class,
  HoursAgoTest::class,
  MinutesAgoTest::class,
  DaysAgoTest::class,
  WeeksAgoTest::class,
  MonthsAgoTest::class,
  YearsAgoTest::class,
)
class TimeAgoTestsSuite {
  // nothing
}
