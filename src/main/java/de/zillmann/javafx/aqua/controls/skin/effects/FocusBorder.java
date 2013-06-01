package de.zillmann.javafx.aqua.controls.skin.effects;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

public class FocusBorder extends DropShadow {

    public FocusBorder() {
        InnerShadow innerFocus = new InnerShadow();
        innerFocus.setColor(Color.rgb(104, 155, 201, 0.8));
        innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        innerFocus.setRadius(5.0);
        innerFocus.setChoke(0.8);
        innerFocus.setOffsetX(0.0);
        
        setSpread(0.6);
        setColor(Color.rgb(120, 171, 217));
        setBlurType(BlurType.ONE_PASS_BOX);
        setRadius(6.5);
        setOffsetX(0.0);
        setOffsetY(0.0);
        setInput(innerFocus);
    }
}
