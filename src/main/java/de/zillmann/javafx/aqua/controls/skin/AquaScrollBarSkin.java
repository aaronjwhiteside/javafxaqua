package de.zillmann.javafx.aqua.controls.skin;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;

import com.sun.javafx.scene.control.skin.ScrollBarSkin;

public class AquaScrollBarSkin extends ScrollBarSkin {

	public AquaScrollBarSkin(ScrollBar scrollBar) {
		super(scrollBar);

//		scrollBar.setVisible(false);
		registerChangeListener(scrollBar.hoverProperty(), "HOVER");
		registerChangeListener(scrollBar.valueProperty(), "VALUE");
		registerChangeListener(scrollBar.visibleProperty(), "VISIBLE");
		


	}


	@Override
	protected void handleControlPropertyChanged(String p) {
		super.handleControlPropertyChanged(p);
		if (p == "HOVER") {
			System.out.println("hover");
		}if (p == "VALUE"){
			System.out.println("scroll");
		}
//		if (p=="VISIBLE"){
//			if (getSkinnable().isVisible()){
//				getSkinnable().setVisible(false);
//			}
//		}
	}
}
