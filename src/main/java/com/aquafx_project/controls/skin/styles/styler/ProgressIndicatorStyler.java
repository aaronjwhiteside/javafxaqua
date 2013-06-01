package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.ProgressIndicator;

public class ProgressIndicatorStyler extends Styler<ProgressIndicator> {

    public static ProgressIndicatorStyler create() {
        return new ProgressIndicatorStyler();
    }
    
    @Override public ProgressIndicatorStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ProgressIndicatorStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
