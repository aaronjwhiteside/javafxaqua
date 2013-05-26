package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.SplitMenuButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.SplitMenuButtonSkin;

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
        InnerShadow innerFocus = new InnerShadow();
        innerFocus.setColor(Color.rgb(104, 155, 201));
        innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        innerFocus.setRadius(5.5);
        innerFocus.setChoke(0.6);
        innerFocus.setOffsetX(0.0);
        innerFocus.setOffsetY(0.0);

        DropShadow outerFocus = new DropShadow();
        outerFocus.setColor(Color.rgb(120, 171, 217));
        outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        outerFocus.setRadius(5.5);
        outerFocus.setSpread(0.95);
        outerFocus.setOffsetX(0.0);
        outerFocus.setOffsetY(0.0);
        outerFocus.setInput(innerFocus);

        getSkinnable().setEffect(outerFocus);
    }
    
    private void setDropShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(172, 172, 184));
        dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
        dropShadow.setRadius(2.0);
        dropShadow.setSpread(0.1);
        dropShadow.setOffsetX(0.0);
        dropShadow.setOffsetY(0.8);
        getSkinnable().setEffect(dropShadow);
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
