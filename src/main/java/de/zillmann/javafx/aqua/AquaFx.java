package de.zillmann.javafx.aqua;

import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleFactory;
import javafx.application.Application;
import javafx.scene.control.Button;

public class AquaFx {
    
    private final static String AQUA_CSS_NAME = AquaFx.class.getResource("mac_os.css").toExternalForm();

    private static StyleFactory styleFactory = new StyleFactory();
    
    public static void style() {
        Application.setUserAgentStylesheet(AQUA_CSS_NAME);
    }

    public static void skin(Button button, ControlSizeVariant controlSizeVariant) {
        skin(button, ButtonType.DEFAULT, controlSizeVariant);
    }

    public static void skin(Button button, ButtonType buttonStyle) {
        skin(button, buttonStyle, ControlSizeVariant.REGULAR);
    }

    public static void skin(Button button, ButtonType buttonStyle, ControlSizeVariant controlSizeVariant) {
        styleFactory.addStyles(button, buttonStyle, controlSizeVariant);
    }

    /**
     * TODO: hilfsmethoden, die eine stage bekommen und dann das initStyle durchführen!
     */
}
