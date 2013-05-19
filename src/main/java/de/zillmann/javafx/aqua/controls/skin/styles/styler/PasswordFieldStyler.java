package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.PasswordField;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

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
