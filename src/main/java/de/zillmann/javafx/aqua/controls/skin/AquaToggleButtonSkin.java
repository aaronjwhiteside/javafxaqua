package de.zillmann.javafx.aqua.controls.skin;

import java.util.List;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.ToggleButtonSkin;

public class AquaToggleButtonSkin extends ToggleButtonSkin {

    public AquaToggleButtonSkin(ToggleButton button) {
        super(button);

        registerChangeListener(button.focusedProperty(), "FOCUSED");
        registerChangeListener(button.selectedProperty(), "SELECTED");

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        } else {
            setDropShadow();
        }

        if (getSkinnable().isSelected()) {
            adjustToggleGroupBorders();
        }

    }

    private void setFocusBorder() {
        InnerShadow innerFocus = new InnerShadow();
        innerFocus.setColor(Color.rgb(104, 155, 201, 0.8));
        innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        innerFocus.setRadius(5.0);
        innerFocus.setChoke(0.8);
        DropShadow outerFocus = new DropShadow();
        outerFocus.setColor(Color.rgb(104, 155, 201, 0.8));
        outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        outerFocus.setRadius(6.5);
        outerFocus.setSpread(0.6);
        outerFocus.setInput(innerFocus);
        getSkinnable().setEffect(outerFocus);
    }

    private void setDropShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(192, 192, 198));
        dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
        dropShadow.setRadius(2.0);
        dropShadow.setSpread(0.2);

        if (getSkinnable().getStyleClass().contains("left-pill")
                || getSkinnable().getStyleClass().contains("center-pill")
                || getSkinnable().getStyleClass().contains("right-pill")) {
            dropShadow.setOffsetX(1.0);
            dropShadow.setOffsetY(0.5);
            dropShadow.setWidth(1.0);
        }
        getSkinnable().setEffect(dropShadow);
    }

    @Override
    protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);
        if (p == "FOCUSED") {
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else if (!getSkinnable().isFocused()
                    || getSkinnable().isDisable()) {
                setDropShadow();
            }
        }
        if (p == "SELECTED") {
            adjustToggleGroupBorders();
        }
    }

    private void adjustToggleGroupBorders() {
        if (getSkinnable().isSelected()
                && getSkinnable().getToggleGroup() != null) {
            List<Toggle> toggles = getSkinnable().getToggleGroup().getToggles();
            int i = toggles.indexOf(getSkinnable().getToggleGroup()
                    .getSelectedToggle());
            if (toggles.size() > i + 1) {
                ToggleButton toggle = (ToggleButton) toggles.get(i + 1);
                toggle.getStyleClass().add("neighbor");
                for (int j = 0; toggles.size() > j; j++) {
                    if (j != i + 1) {
                        ((ToggleButton) toggles.get(j)).getStyleClass().remove(
                                "neighbor");
                    }
                }
            }
        } else if (!getSkinnable().isSelected()
                && getSkinnable().getToggleGroup() != null) {
            List<Toggle> toggles = getSkinnable().getToggleGroup().getToggles();
            int i = toggles.indexOf(getSkinnable());
            if (toggles.size() > i + 1) {
                ToggleButton toggle = (ToggleButton) toggles.get(i + 1);
                
                toggle.getStyleClass().remove("neighbor");
            }
        }
    }
}
