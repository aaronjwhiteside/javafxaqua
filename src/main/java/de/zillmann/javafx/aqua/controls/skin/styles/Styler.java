package de.zillmann.javafx.aqua.controls.skin.styles;

import java.util.Collections;
import java.util.List;

import javafx.scene.control.Control;

public class Styler<T extends Control> {

    protected ControlSizeVariant sizeVariant;

    
    public void style(T control) {
        for (StyleDefinition definition : getAll()) {
            if (definition != null) {
                String style = definition.getStyleName();
                if (style != null) {
                    control.getStyleClass().add(style);
                }
            }
        }
    }

    public Styler<T> setSizeVariant(ControlSizeVariant sizeVariant) {
        this.sizeVariant = sizeVariant;
        check();
        return this;
    }
    
    protected List<StyleDefinition> getAll() {
        return Collections.emptyList();
    }

    public void check() {}
}
