package com.aquafx_project.controls.skin.styles;

public enum ButtonType implements StyleDefinition {
    DEFAULT,
    HELP,
    ROUND_RECT,
    LEFT_PILL,
    CENTER_PILL,
    RIGHT_PILL;

    //TODO: Alle übernehmen aus https://developer.apple.com/library/mac/#technotes/tn2007/tn2196.html
    
    @Override public String getStyleName() {
        String prefix = "button-type";
        if (this.equals(HELP)) {
            return prefix + "-" + "help";
        }
        if (this.equals(ROUND_RECT)) {
            return prefix + "-" + "round-rect";
        }
        if (this.equals(LEFT_PILL)) {
            return "left-pill";
        }
        if (this.equals(CENTER_PILL)) {
            return "center-pill";
        }
        if (this.equals(RIGHT_PILL)) {
            return "right-pill";
        }
        return null;
    }

}
