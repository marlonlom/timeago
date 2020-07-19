package com.github.marlonlom.utilities.timeago

import com.github.marlonlom.utilities.timeago.usages.*
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
        MonthsAgoTest::class,
        YearsAgoTest::class
)
class TimeAgoTestsSuite {
    //nothing
}