package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.ColorPicker;

public class ColorPickerStyler extends Styler<ColorPicker> {

    public static ColorPickerStyler create() {
        return new ColorPickerStyler();
    }
    
    @Override public ColorPickerStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ColorPickerStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
