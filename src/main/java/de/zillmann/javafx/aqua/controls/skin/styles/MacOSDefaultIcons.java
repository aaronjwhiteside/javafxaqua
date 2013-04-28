package de.zillmann.javafx.aqua.controls.skin.styles;

public enum MacOSDefaultIcons implements StyleDefinition {
    LEFT,
    RIGHT,
    SHARE,
    SEARCH;

    @Override public String getStyleName() {
        String prefix = "icon";
        if (this.equals(LEFT)) {
            return prefix + "-" + "left";
        }
        if (this.equals(RIGHT)) {
            return prefix + "-" + "right";
        }
        if (this.equals(SHARE)) {
            return prefix + "-" + "share";
        }
        if (this.equals(SEARCH)) {
            return prefix + "-" + "search";
        }
        return null;
    }
}
