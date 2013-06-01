package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;

import com.sun.javafx.scene.control.skin.ColorPickerSkin;

import de.zillmann.javafx.aqua.controls.skin.effects.FocusBorder;
import de.zillmann.javafx.aqua.controls.skin.effects.Shadow;

public class AquaColorPickerSkin extends ColorPickerSkin implements AquaSkin{

    public AquaColorPickerSkin(ColorPicker colorPicker) {
        super(colorPicker);

        registerChangeListener(colorPicker.focusedProperty(), "FOCUSED");
        if (getSkinnable().isFocused()) {
            setFocusBorder();
        } else {
            setDropShadow();
        }
    }

    private void setFocusBorder() {
        getSkinnable().setEffect(new FocusBorder());
    }
    
    private void setDropShadow() {
        getSkinnable().setEffect(new Shadow(false));
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);

        if (p == "FOCUSED") {
            if (!(getSkinnable().getParent() instanceof ComboBox)) {
                if (getSkinnable().isFocused()) {
                    setFocusBorder();
                } else {
                    setDropShadow();
                }
            }
        }
    }
}
