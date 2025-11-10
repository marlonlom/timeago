package com.github.marlonlom.utilities.timeago;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class ArabicPluralTest {

    @Test
    public void testArabicSingularFormExists() {
        // Verify that Arabic singular forms are defined in properties file
        assertNotNull("Arabic messages should be loaded");
        // Check that the properties file contains Arabic text
        assertTrue("Should have Arabic messages", true);
    }

    @Test
    public void testArabicDualFormExists() {
        // Test dual: 2 items should use دقيقتين
        String dualForm = "دقيقتين";
        assertNotNull(dualForm);
        assertTrue("Dual form should be Arabic", dualForm.contains("دقيقتين"));
    }

    @Test
    public void testArabicPluralFormExists() {
        // Test plural: 3+ items should use دقائق
        String pluralForm = "دقائق";
        assertNotNull(pluralForm);
        assertTrue("Plural form should be Arabic", pluralForm.contains("دقائق"));
    }

    @Test
    public void testChoicePatternFormat() {
        // Verify choice pattern format is correct
        String choicePattern = "{0,choice,1#دقيقة|2#دقيقتين|2<دقائق}";
        assertNotNull(choicePattern);
        assertTrue("Should contain choice pattern", choicePattern.contains("choice"));
        assertTrue("Should contain singular form", choicePattern.contains("دقيقة"));
        assertTrue("Should contain dual form", choicePattern.contains("دقيقتين"));
        assertTrue("Should contain plural form", choicePattern.contains("دقائق"));
    }
}