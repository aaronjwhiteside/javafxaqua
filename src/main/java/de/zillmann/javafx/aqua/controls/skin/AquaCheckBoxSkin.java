package de.zillmann.javafx.aqua.controls.skin;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.CheckBoxSkin;

public class AquaCheckBoxSkin extends CheckBoxSkin {


	public AquaCheckBoxSkin(CheckBox checkbox) {
		super(checkbox);

		registerChangeListener(checkbox.focusedProperty(), "FOCUSED");
		registerChangeListener(checkbox.selectedProperty(), "SELECTED");
		setBoxShadow();
	}

	private void setBoxShadow() {
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.rgb(172, 172, 184));
		shadow.setBlurType(BlurType.ONE_PASS_BOX);
		shadow.setRadius(2.0);
		shadow.setSpread(0.2);
		shadow.setOffsetX(0.0);
		shadow.setOffsetY(0.8); 
		
		for (int i = 0; i < getChildren().size(); i++) {
			Node child = getChildren().get(i);
			if (child.getStyleClass().get(0).equals("box") ) {
				child.setEffect(shadow);
			}
		}
	}
	
	private void setSelectedFocusBorder() {
		InnerShadow innerFocus = new InnerShadow();
		innerFocus.setColor(Color.rgb(104, 155, 201, 0.7));
		innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
		innerFocus.setRadius(6.5);
		innerFocus.setChoke(0.7);
		innerFocus.setOffsetX(0.0);
		innerFocus.setOffsetY(0.0);

		DropShadow outerFocus = new DropShadow();
		outerFocus.setColor(Color.rgb(104, 155, 201));
		outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
		outerFocus.setRadius(7.0);
		outerFocus.setSpread(0.7);
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
				setBoxShadow();
			}
		}
	}
}
