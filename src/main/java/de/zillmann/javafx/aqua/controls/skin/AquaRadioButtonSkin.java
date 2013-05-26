package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.RadioButtonSkin;

public class AquaRadioButtonSkin extends RadioButtonSkin implements AquaSkin{

    public AquaRadioButtonSkin(RadioButton radioButton) {
        super(radioButton);
        if (getSkinnable().isFocused()) {
            setFocusBorder();
        } else {
            setDropShadow();
        }
        registerChangeListener(radioButton.focusedProperty(), "FOCUSED");

    }

    private void setFocusBorder() {
        InnerShadow innerFocus = new InnerShadow();
        innerFocus.setColor(Color.rgb(104, 155, 201));
        innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        innerFocus.setRadius(6.5);
        innerFocus.setChoke(0.7);
        innerFocus.setOffsetX(0.0);
        innerFocus.setOffsetY(0.0);

        DropShadow outerFocus = new DropShadow();
        outerFocus.setColor(Color.rgb(104, 155, 201));
        outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        outerFocus.setRadius(5.0);
        outerFocus.setSpread(0.6);
        outerFocus.setOffsetX(0.0);
        outerFocus.setOffsetY(0.0);
        outerFocus.setInput(innerFocus);

        for (Node child : getChildren()) {
            if (child instanceof StackPane) {
                child.setEffect(outerFocus);
            }
        }
    }

    private void setDropShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(192, 192, 198));
        dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
        dropShadow.setRadius(2.0);
        dropShadow.setSpread(0.1);
        dropShadow.setOffsetX(0.0);
        dropShadow.setOffsetY(0.0);

        for (Node child : getChildren()) {
            if (child.getStyleClass().get(0).equals("radio")) {
                child.setEffect(dropShadow);
            }
        }
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);
        if (p == "FOCUSED") {
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else if (!getSkinnable().isFocused()) {
                setDropShadow();
            }
        }
    }
}
