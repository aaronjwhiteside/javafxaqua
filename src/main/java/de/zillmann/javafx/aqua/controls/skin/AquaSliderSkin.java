package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.SliderSkin;

public class AquaSliderSkin extends SliderSkin implements AquaSkin{

    public AquaSliderSkin(Slider slider) {
        super(slider);

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        }
        
        registerChangeListener(slider.focusedProperty(), "FOCUSED");

        if (slider.isShowTickMarks()) {
            slider.getStyleClass().add("alternative-thumb");
        }
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);

        if (p == "FOCUSED") {
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else {
                for (Node child : getChildren()) {
                    if (child.getStyleClass().get(0).equals("thumb")) {
                        child.setEffect(null);
                    }
                }
            }
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
        outerFocus.setColor(Color.rgb(104, 155, 201));
        outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        outerFocus.setRadius(7.0);
        outerFocus.setSpread(0.5);
        outerFocus.setOffsetX(0.0);
        outerFocus.setOffsetY(0.0);
        outerFocus.setInput(innerFocus);

        for (Node child : getChildren()) {
            if (child.getStyleClass().get(0).equals("thumb")) {
                child.setEffect(outerFocus);
                getSkinnable().impl_reapplyCSS();
            }
        }
    }

}
