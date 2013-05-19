package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ToolBar;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

public class ToolBarStyler extends Styler<ToolBar> {

    public static ToolBarStyler create() {
        return new ToolBarStyler();
    }
    
    @Override public ToolBarStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ToolBarStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
