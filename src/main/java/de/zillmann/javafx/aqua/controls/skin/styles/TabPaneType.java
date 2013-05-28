package de.zillmann.javafx.aqua.controls.skin.styles;

public enum TabPaneType implements StyleDefinition {
    DEFAULT,
    ICON_BUTTONS,
    SMALL_ICON_BUTTONS;

    @Override public String getStyleName() {
        String prefix = "tabpane-type";
        if (this.equals(ICON_BUTTONS)) {
            return prefix + "-" + "icon-buttons";
        }
        if (this.equals(SMALL_ICON_BUTTONS)) {
            return prefix + "-" + "small-icon-buttons";
        }
        return null;
    }
}
