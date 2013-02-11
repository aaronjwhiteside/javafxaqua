package de.zillmann.javafx.aqua.controls.skin;

import com.sun.javafx.scene.control.skin.CheckBoxSkin;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class AquaCheckBoxSkin extends CheckBoxSkin {

	private DropShadow shadow;

	public AquaCheckBoxSkin(CheckBox checkbox) {
		super(checkbox);

		registerChangeListener(checkbox.focusedProperty(), "FOCUSED");
		registerChangeListener(checkbox.selectedProperty(), "SELECTED");
		shadow = new DropShadow();
		shadow.setColor(Color.rgb(215, 215, 215));
		shadow.setBlurType(BlurType.GAUSSIAN);
		shadow.setRadius(1.5);
		shadow.setSpread(0.3);
		shadow.setOffsetX(0.0);
		shadow.setOffsetY(1.0);

		for (int i = 0; i < getChildren().size(); i++) {
			Node child = getChildren().get(i);
			if (child instanceof StackPane) {
				child.setEffect(shadow);
			}
		}
	}

	private void setSelectedFocusBorder() {
		InnerShadow innerFocus = new InnerShadow();
		innerFocus.setColor(Color.rgb(122, 170, 217, 0.5));
		innerFocus.setBlurType(BlurType.GAUSSIAN);
		innerFocus.setRadius(1.8);
		innerFocus.setChoke(2.8);
		innerFocus.setOffsetX(0.0);
		innerFocus.setOffsetY(0.0);

		DropShadow outerFocus = new DropShadow();
		outerFocus.setColor(Color.rgb(122, 170, 217));
		outerFocus.setBlurType(BlurType.GAUSSIAN);
		outerFocus.setRadius(7.0);
		outerFocus.setSpread(0.65);
		outerFocus.setOffsetX(0.0);
		outerFocus.setOffsetY(0.0);
		outerFocus.setInput(innerFocus);

		for (int i = 0; i < getChildren().size(); i++) {
			Node child = getChildren().get(i);
			if (child instanceof StackPane) {
				child.setEffect(outerFocus);
			}
		}
	}

	private void setFocusBorder() {
		InnerShadow innerFocus = new InnerShadow();
		innerFocus.setColor(Color.rgb(122, 170, 217, 0.8));
		innerFocus.setBlurType(BlurType.GAUSSIAN);
		innerFocus.setRadius(6.0);
		innerFocus.setChoke(0.6);
		innerFocus.setOffsetX(0.0);
		innerFocus.setOffsetY(0.0);

		DropShadow outerFocus = new DropShadow();
		outerFocus.setColor(Color.rgb(122, 170, 217));
		outerFocus.setBlurType(BlurType.GAUSSIAN);
		outerFocus.setRadius(5.0);
		outerFocus.setSpread(0.6);
		outerFocus.setOffsetX(0.0);
		outerFocus.setOffsetY(0.0);
		outerFocus.setInput(innerFocus);

		for (int i = 0; i < getChildren().size(); i++) {
			Node child = getChildren().get(i);
			if (child instanceof StackPane) {
				child.setEffect(outerFocus);
			}
		}
	}

	@Override
	protected void handleControlPropertyChanged(String p) {
		super.handleControlPropertyChanged(p);
		if (p == "SELECTED") {
			if (getSkinnable().isFocused()) {
				if (getSkinnable().isSelected()) {
					setSelectedFocusBorder();
				} else {
					setFocusBorder();
				}
			}
		}
		if (p == "FOCUSED") {
			if (getSkinnable().isFocused()) {
				if (getSkinnable().isSelected()) {
					setSelectedFocusBorder();
				} else {
					setFocusBorder();
				}
			} else if (!getSkinnable().isFocused()) {
				for (int i = 0; i < getChildren().size(); i++) {
					Node child = getChildren().get(i);
					if (child instanceof StackPane) {
						child.setEffect(shadow);
					}
				}
			}
		}
	}
}
