package com.aquafx_project.controls.skin.styles.styler;

import org.junit.Assert;
import org.junit.Test;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;

public class ComboBoxStylerTest {

    @Test 
    public void testStylerCreation() {
        ComboBoxStyler styler = ComboBoxStyler.create();
        Assert.assertNotNull(styler);
    }

    @Test 
    public void testSetSize() {
        ComboBoxStyler styler = ComboBoxStyler.create();
        styler.setSizeVariant(ControlSizeVariant.MINI);
        Assert.assertEquals(ControlSizeVariant.MINI, styler.sizeVariant);
    }
    
    @Test
    public void testApplyMultipleStyles() {
        try {
            ComboBoxStyler styler = ComboBoxStyler.create();
            styler.setSizeVariant(ControlSizeVariant.SMALL);
            Assert.assertEquals(ControlSizeVariant.SMALL, styler.sizeVariant);
            styler.setSizeVariant(ControlSizeVariant.MINI);
            Assert.assertEquals(ControlSizeVariant.MINI, styler.sizeVariant);
         } catch (Exception e) {
             Assert.fail("No Exception expected");
         } 
    }
}
