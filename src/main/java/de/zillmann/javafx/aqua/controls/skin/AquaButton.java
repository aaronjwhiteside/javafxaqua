package de.zillmann.javafx.aqua.controls.skin;

import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AquaButton extends Button {

	@Override
	@Deprecated
	protected void impl_processCSS() {
		System.out.println(getPseudoClassStates());
		super.impl_processCSS();
	}
	
	
	protected javafx.scene.control.Skin<?> createDefaultSkin() {
		return new AquaButtonSkin(this);
	};
	
	public void setOnPseudoClassChanged(EventHandler<?> eventHandler) {
		
	}
}
