package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.control.PasswordField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.PasswordFieldSkin;

public class AquaPasswordFieldSkin extends PasswordFieldSkin {

	public AquaPasswordFieldSkin(PasswordField passwordfield) {
		super(passwordfield);

		registerChangeListener(passwordfield.focusedProperty(), "FOCUSED");
	}

	private void setFocusBorder() {
		InnerShadow innerFocus = new InnerShadow();
		innerFocus.setColor(Color.rgb(104, 155, 201, 0.8));
		innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
		innerFocus.setRadius(5.5);
		innerFocus.setChoke(0.6);
		innerFocus.setOffsetX(0.0);
		innerFocus.setOffsetY(0.0);

		DropShadow outerFocus = new DropShadow();
		outerFocus.setColor(Color.rgb(96, 156, 209, 0.8));
		outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
		outerFocus.setRadius(7.0);
		outerFocus.setSpread(1.0);
		outerFocus.setOffsetX(0.0);
		outerFocus.setOffsetY(0.0);
		outerFocus.setInput(innerFocus);

		getSkinnable().setEffect(outerFocus);
	}

	@Override
	protected void handleControlPropertyChanged(String p) {
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
