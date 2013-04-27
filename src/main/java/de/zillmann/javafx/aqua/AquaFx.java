package de.zillmann.javafx.aqua;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.MacOSDefaultIcons;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleFactory;

public class AquaFx {

    private final static String AQUA_CSS_NAME = AquaFx.class.getResource("mac_os.css").toExternalForm();

    private static StyleFactory styleFactory = new StyleFactory();

    public static void style() {
        Application.setUserAgentStylesheet(AQUA_CSS_NAME);
    }

    public static void skin(Button button, ControlSizeVariant controlSizeVariant) {
        skin(button, ButtonType.DEFAULT, controlSizeVariant);
    }

    public static void skin(Button button, ButtonType buttonType) {
        skin(button, buttonType, ControlSizeVariant.REGULAR);
    }

    public static void skin(Button button, ButtonType buttonType, ControlSizeVariant controlSizeVariant) {
        styleFactory.addStyles(button, buttonType, controlSizeVariant);
    }

    public static void setButtonIcon(Button button, MacOSDefaultIcons icon) {
        Region svgIcon = new Region();
        svgIcon.getStyleClass().add(icon.getStyleName());
        button.setGraphic(svgIcon);
    }

    public static void styleSearchField(TextField textField, MacOSDefaultIcons icon) {
        // Region svgIcon = new Region();
        // svgIcon.getStyleClass().add(icon.getStyleName());
        textField.getStyleClass().add(icon.getStyleName());
    }

    public static void setGroupBox(Pane pane) {
        pane.getStyleClass().add("aqua-group-box");
    }

    /**
     * TODO: hilfsmethoden, die eine stage bekommen und dann das initStyle durchführen!
     */
}
