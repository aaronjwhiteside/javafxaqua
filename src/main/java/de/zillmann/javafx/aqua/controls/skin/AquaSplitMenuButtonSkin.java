package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.SplitMenuButton;

import com.sun.javafx.scene.control.skin.SplitMenuButtonSkin;

import de.zillmann.javafx.aqua.controls.skin.effects.FocusBorder;
import de.zillmann.javafx.aqua.controls.skin.effects.Shadow;

public class AquaSplitMenuButtonSkin extends SplitMenuButtonSkin implements AquaSkin{

    public AquaSplitMenuButtonSkin(SplitMenuButton menuButton) {
        super(menuButton);

        registerChangeListener(menuButton.focusedProperty(), "FOCUSED");
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
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else {
                setDropShadow();
            }
        }
    }
}
