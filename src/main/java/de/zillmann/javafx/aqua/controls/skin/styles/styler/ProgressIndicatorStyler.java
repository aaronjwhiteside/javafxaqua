package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ProgressIndicator;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

public class ProgressIndicatorStyler extends Styler<ProgressIndicator> {

    public static ProgressIndicatorStyler create() {
        return new ProgressIndicatorStyler();
    }
    
    @Override public ProgressIndicatorStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ProgressIndicatorStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
