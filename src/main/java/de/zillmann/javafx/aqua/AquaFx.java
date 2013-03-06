package de.zillmann.javafx.aqua;

import javafx.application.Application;

public class AquaFx {
	private final static String AQUA_CSS_NAME = AquaFx.class.getResource("mac_os.css").toExternalForm();
	
	public static void style() {
		Application.setUserAgentStylesheet(AQUA_CSS_NAME);
	}
}
