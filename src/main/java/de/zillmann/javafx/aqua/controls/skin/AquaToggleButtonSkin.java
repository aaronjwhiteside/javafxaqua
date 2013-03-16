package de.zillmann.javafx.aqua.controls.skin;

import javafx.event.Event;
import javafx.event.EventHandler;
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

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        } else {
            setDropShadow();
        }
        /**
         * if the button is a default button, it has to stop blinking when
         * pressed
         */
        getSkinnable().setOnMousePressed(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                if (getSkinnable().isFocused()) {
                    setFocusBorder();
                }

            }
        });

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
        dropShadow.setOffsetX(0.0);
        dropShadow.setOffsetY(0.0);
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
    }

}
