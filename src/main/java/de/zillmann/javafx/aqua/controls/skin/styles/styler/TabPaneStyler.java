package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TabPane;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

public class TabPaneStyler extends Styler<TabPane> {

    public static TabPaneStyler create() {
        return new TabPaneStyler();
    }
    
    @Override public TabPaneStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (TabPaneStyler) super.setSizeVariant(sizeVariant);
    }
    
    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        return ret;
    }
}
