package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.ChoiceBox;

public class ChoiceBoxStyler extends Styler<ChoiceBox<?>> {

    public static ChoiceBoxStyler create() {
        return new ChoiceBoxStyler();
    }
    
    @Override public ChoiceBoxStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ChoiceBoxStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
