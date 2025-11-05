package com.github.marlonlom.utilities.timeago;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArabicPluralTest {

    @Test
    public void testArabicSingularForm() {
        // Test singular: 1 item
        TimeAgo timeAgo = TimeAgo.using(1000); // 1 minute ago
        String result = timeAgo.toString();
        assertEquals("منذ دقيقة", result);
    }

    @Test
    public void testArabicDualForm() {
        // Test dual: exactly 2 items
        TimeAgo timeAgo = TimeAgo.using(120000); // 2 minutes ago
        String result = timeAgo.toString();
        assertEquals("منذ 2 دقيقتين", result);
    }

    @Test
    public void testArabicPluralForm() {
        // Test plural: 3+ items
        TimeAgo timeAgo = TimeAgo.using(300000); // 5 minutes ago
        String result = timeAgo.toString();
        assertEquals("منذ 5 دقائق", result);
    }

    @Test
    public void testArabicPluralFormLarge() {
        // Test edge case: large numbers >10
        TimeAgo timeAgo = TimeAgo.using(720000); // 12 minutes ago
        String result = timeAgo.toString();
        assertEquals("منذ 12 دقائق", result);
    }

    @Test
    public void testArabicZeroItems() {
        // Test edge case: 0 items (should handle gracefully)
        TimeAgo timeAgo = TimeAgo.using(0);
        String result = timeAgo.toString();
        // Verify no exceptions thrown
        assertNotNull(result);
    }
}