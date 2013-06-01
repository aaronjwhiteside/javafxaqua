package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.TextArea;

import com.sun.javafx.scene.control.skin.TextAreaSkin;

import de.zillmann.javafx.aqua.controls.skin.effects.FocusBorder;

public class AquaTextAreaSkin extends TextAreaSkin implements AquaSkin{

    public AquaTextAreaSkin(TextArea textarea) {
        super(textarea);

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        }
        
        registerChangeListener(textarea.focusedProperty(), "FOCUSED");
    }

    private void setFocusBorder() {
        getSkinnable().setEffect(new FocusBorder());
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);

        if (p == "FOCUSED") {
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else {
                getSkinnable().setEffect(null);
            }
        }
    }
}
