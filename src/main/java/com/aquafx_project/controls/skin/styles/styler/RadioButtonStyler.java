package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.RadioButton;

public class RadioButtonStyler extends Styler<RadioButton> {

    public static RadioButtonStyler create() {
        return new RadioButtonStyler();
    }
    
    @Override public RadioButtonStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (RadioButtonStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
