package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.PasswordField;

public class PasswordFieldStyler extends Styler<PasswordField> {

    public static PasswordFieldStyler create() {
        return new PasswordFieldStyler();
    }
    
    @Override public PasswordFieldStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (PasswordFieldStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
