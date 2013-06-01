package com.aquafx_project.controls.skin.styles;

import javafx.scene.control.Control;

public class StyleFactory {

    public StyleFactory() {
    }
    
    public <T extends Control> void addStyles(T control, StyleDefinition... definitions) {
        for(StyleDefinition definition : definitions) {
            String style = definition.getStyleName();
            if(style != null) {
                control.getStyleClass().add(style);
            }
        }
    }
}
