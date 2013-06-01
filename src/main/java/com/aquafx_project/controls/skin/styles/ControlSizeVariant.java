package com.aquafx_project.controls.skin.styles;

public enum ControlSizeVariant implements StyleDefinition {
    REGULAR,
    SMALL,
    MINI;

    @Override public String getStyleName() {
        String prefix = "size-variant";
        if (this.equals(SMALL)) {
            return prefix + "-" + "small";
        }
        if (this.equals(MINI)) {
            return prefix + "-" + "mini";
        }
        return null;
    }
}
