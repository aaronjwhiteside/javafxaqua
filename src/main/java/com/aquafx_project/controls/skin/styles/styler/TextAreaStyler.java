package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.TextArea;

public class TextAreaStyler extends Styler<TextArea> {

    public static TextAreaStyler create() {
        return new TextAreaStyler();
    }
    
    @Override public TextAreaStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (TextAreaStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
