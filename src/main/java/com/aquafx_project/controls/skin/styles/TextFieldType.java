package com.aquafx_project.controls.skin.styles;

public enum TextFieldType implements StyleDefinition {
    DEFAULT,
    SEARCH,
    ROUND_RECT;

    @Override public String getStyleName() {
        String prefix = "textfield-type";
        if (this.equals(SEARCH)) {
            return prefix + "-" + "search";
        }
        if (this.equals(ROUND_RECT)) {
            return prefix + "-" + "round-rect";
        }
        return null;
    }

}
