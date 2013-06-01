package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.ChoiceBox;

import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;

import de.zillmann.javafx.aqua.controls.skin.effects.FocusBorder;
import de.zillmann.javafx.aqua.controls.skin.effects.Shadow;

public class AquaChoiceBoxSkin<T> extends ChoiceBoxSkin<T> implements AquaSkin{

    public AquaChoiceBoxSkin(ChoiceBox<T> choiceBox) {
        super(choiceBox);

        registerChangeListener(choiceBox.focusedProperty(), "FOCUSED");
        registerChangeListener(choiceBox.disabledProperty(), "DISABLED");

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        } else if(!getSkinnable().isFocused() && !getSkinnable().isDisabled()) {
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
        if (p == "DISABLED") {
            if (getSkinnable().isDisabled()) {
                getSkinnable().setEffect(null);
            } else {
                setDropShadow();
            }
        }
    }
}
