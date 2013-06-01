package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.ComboBox;

public class ComboBoxStyler extends Styler<ComboBox<?>> {

    public static ComboBoxStyler create() {
        return new ComboBoxStyler();
    }
    
    @Override public ComboBoxStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ComboBoxStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
