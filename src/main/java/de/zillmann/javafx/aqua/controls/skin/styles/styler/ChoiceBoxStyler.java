package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ChoiceBox;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

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
