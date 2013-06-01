package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.ScrollBar;

public class ScrollBarStyler extends Styler<ScrollBar> {

    public static ScrollBarStyler create() {
        return new ScrollBarStyler();
    }
    
    @Override public ScrollBarStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ScrollBarStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
