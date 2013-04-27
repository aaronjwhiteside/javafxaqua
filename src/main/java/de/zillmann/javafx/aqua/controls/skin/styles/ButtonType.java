package de.zillmann.javafx.aqua.controls.skin.styles;

public enum ButtonType implements StyleDefinition {
    DEFAULT,
    HELP,
    ROUND_RECT;

    //TODO: Alle übernehmen aus https://developer.apple.com/library/mac/#technotes/tn2007/tn2196.html
    
    @Override public String getStyleName() {
        String prefix = "button-type";
        if (this.equals(HELP)) {
            return prefix + "-" + "help";
        }
        if (this.equals(ROUND_RECT)) {
            return prefix + "-" + "round-rect";
        }
        return null;
    }

}
