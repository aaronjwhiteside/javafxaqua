package com.aquafx_project.controls.skin.styles.styler;

import org.junit.Assert;
import org.junit.Test;

import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.IllegalStyleCombinationException;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;

public class ToggleButtonStylerTest {

    @Test 
    public void testStylerCreation() {
        ToggleButtonStyler styler = ToggleButtonStyler.create();
        Assert.assertNotNull(styler);
    }

    @Test 
    public void testSetSize() {
        ToggleButtonStyler styler = ToggleButtonStyler.create();
        styler.setSizeVariant(ControlSizeVariant.MINI);
        Assert.assertEquals(ControlSizeVariant.MINI, styler.sizeVariant);
    }
    
    @Test 
    public void testSetIcon() {
        ToggleButtonStyler styler = ToggleButtonStyler.create();
        styler.setIcon(MacOSDefaultIcons.SHARE);
        Assert.assertNotNull(styler.icon);
        Assert.assertEquals(styler.icon, MacOSDefaultIcons.SHARE);
    }
    
    @Test 
    public void testSetType() {
        ToggleButtonStyler styler = ToggleButtonStyler.create();
        styler.setType(ButtonType.ROUND_RECT);
        Assert.assertNotNull(styler.type);
        Assert.assertEquals(styler.type, ButtonType.ROUND_RECT);
        Assert.assertTrue(styler.getAll().contains(ButtonType.ROUND_RECT));
    }
    
    @Test(expected = IllegalStyleCombinationException.class) 
    public void testExceptionIsThrown() {
        ToggleButtonStyler styler = ToggleButtonStyler.create();
        styler.setType(ButtonType.HELP).setIcon(MacOSDefaultIcons.SEARCH);
    }

    @Test
    public void testExceptionMessage() {
        try {
            ToggleButtonStyler styler = ToggleButtonStyler.create();
            styler.setType(ButtonType.HELP).setIcon(MacOSDefaultIcons.SEARCH);
            Assert.fail("Exception not thrown");
         } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "The applied StyleDefinitions cannot be combined");
         } 
    }
    
    @Test
    public void testApplyMultipleStyles() {
        try {
            ToggleButtonStyler styler = ToggleButtonStyler.create();
            styler.setType(ButtonType.ROUND_RECT)
                .setIcon(MacOSDefaultIcons.SEARCH)
                .setSizeVariant(ControlSizeVariant.SMALL);
         } catch (Exception e) {
             Assert.fail("No Exception expected");
         } 
    }
}
