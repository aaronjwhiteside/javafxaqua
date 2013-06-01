package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.PasswordField;

import com.sun.javafx.scene.control.skin.PasswordFieldSkin;

import de.zillmann.javafx.aqua.controls.skin.effects.FocusBorder;

public class AquaPasswordFieldSkin extends PasswordFieldSkin implements AquaSkin{

    public AquaPasswordFieldSkin(PasswordField passwordfield) {
        super(passwordfield);
        
        if (getSkinnable().isFocused()) {
            setFocusBorder();
        }

        registerChangeListener(passwordfield.focusedProperty(), "FOCUSED");
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
