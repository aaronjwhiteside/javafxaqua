package de.zillmann.javafx.aqua;

import javafx.scene.Scene;

public class AquaFx {

	public static void style(Scene scene) {
		scene.getStylesheets().add(
				AquaFx.class.getResource("mac_os.css").toExternalForm());
	}
}
