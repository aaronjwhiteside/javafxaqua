package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ColorPicker;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

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
