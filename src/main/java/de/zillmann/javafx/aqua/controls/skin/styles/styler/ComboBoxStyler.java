package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ComboBox;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

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
