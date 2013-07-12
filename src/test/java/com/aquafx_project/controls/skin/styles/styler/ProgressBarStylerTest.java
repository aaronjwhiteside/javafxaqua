package com.aquafx_project.controls.skin.styles.styler;

import org.junit.Assert;
import org.junit.Test;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;

public class ProgressBarStylerTest {

    @Test 
    public void testStylerCreation() {
        ProgressBarStyler styler = ProgressBarStyler.create();
        Assert.assertNotNull(styler);
    }

    @Test 
    public void testSetSize() {
        ProgressBarStyler styler = ProgressBarStyler.create();
        styler.setSizeVariant(ControlSizeVariant.MINI);
        Assert.assertEquals(ControlSizeVariant.MINI, styler.sizeVariant);
    }
    
    @Test
    public void testApplyMultipleStyles() {
        try {
            ProgressBarStyler styler = ProgressBarStyler.create();
            styler.setSizeVariant(ControlSizeVariant.SMALL);
            Assert.assertEquals(ControlSizeVariant.SMALL, styler.sizeVariant);
            styler.setSizeVariant(ControlSizeVariant.MINI);
            Assert.assertEquals(ControlSizeVariant.MINI, styler.sizeVariant);
         } catch (Exception e) {
             Assert.fail("No Exception expected");
         } 
    }
}
