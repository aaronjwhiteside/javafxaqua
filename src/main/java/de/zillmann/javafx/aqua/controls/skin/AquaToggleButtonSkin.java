package de.zillmann.javafx.aqua.controls.skin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.ToggleButtonSkin;

public class AquaToggleButtonSkin extends ToggleButtonSkin {
	private boolean isLast=false;
	
	public AquaToggleButtonSkin(ToggleButton contextMenu) {
		super(contextMenu);

		registerChangeListener(contextMenu.selectedProperty(), "SELECTED");

		if (getSkinnable().isSelected()) {
			setSelectedEffect();
		} 

		EventHandler<Event> stopHandler = new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				getSkinnable().setEffect(null);
			}
		};

		EventHandler<Event> startHandler = new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				getSkinnable().setEffect(new ColorAdjust(0, 0, -0.15, 0));
			}
		};

		/**
		 * a hover-effect when mouse is pressed
		 */
		getSkinnable().setOnMousePressed(startHandler);

		/**
		 * TODO: when hover && pressed a hover, when hovers
		 */
		// getSkinnable().setOnMouseEntered(startHandler);

		/**
		 * when mouse exits, no dark
		 */
		getSkinnable().setOnMouseExited(stopHandler);

		/**
		 * when mouse is released, no dark
		 */
		getSkinnable().setOnMouseReleased(stopHandler);

		int index = getSkinnable().getToggleGroup().getToggles()
				.indexOf(getSkinnable());
		if (index == 0) {
			getSkinnable()
					.setStyle(
							"-fx-background-radius: 3 0 0 3;"
									+ "-fx-border-radius: 3 0 0 3;"
									+ "-fx-background-insets: 0.5 0 0.5 0.5, 1 0 1 1 ;");
		} else if (index == getSkinnable().getToggleGroup().getToggles().size() - 1) {
			isLast=true;
			setLastSelectedBorder(getSkinnable().isSelected());
		}
	}

	@Override
	protected void handleControlPropertyChanged(String p) {
		super.handleControlPropertyChanged(p);
		if (p == "SELECTED") {
			if(getSkinnable().isSelected()){
				setSelectedEffect();
				if(isLast){
					setLastSelectedBorder(true);
				}
			}else{
				if(isLast){
					setLastSelectedBorder(false);
				}
			}
		}
	}
	
	private void setSelectedEffect(){
		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setColor(Color.rgb(94, 94, 94, 0.5));
		innerShadow.setBlurType(BlurType.ONE_PASS_BOX);
		innerShadow.setRadius(5.5);
		innerShadow.setChoke(0.7);
		innerShadow.setOffsetX(0.0);
		innerShadow.setOffsetY(1.0);
		getSkinnable().setEffect(innerShadow);

		//TODO: set shadow of text 
	}
	
	private void setLastSelectedBorder(boolean selected){
		String number= selected ? "-1":"0";
		getSkinnable().setStyle(
				"-fx-background-radius: 0 3 3 0;"
				+ "-fx-border-radius: 0 3 3 0;" +
				"-fx-background-insets: 0.5 0.5 0.5 "+number+", 1 1 1 0 ;");
	}
}
