package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;


import javafx.scene.control.Label;

public class LabelStyler extends Styler<Label> {

    public static LabelStyler create() {
        return new LabelStyler();
    }
    
    @Override public LabelStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (LabelStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
