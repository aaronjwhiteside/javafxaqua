package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.ProgressBar;

public class ProgressBarStyler extends Styler<ProgressBar> {

    public static ProgressBarStyler create() {
        return new ProgressBarStyler();
    }
    
    @Override public ProgressBarStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ProgressBarStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
