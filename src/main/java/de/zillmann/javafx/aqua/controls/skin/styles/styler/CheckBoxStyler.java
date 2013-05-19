package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

public class CheckBoxStyler extends Styler<CheckBox> {

    public static CheckBoxStyler create() {
        return new CheckBoxStyler();
    }
    
    @Override public CheckBoxStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (CheckBoxStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
