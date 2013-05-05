package de.zillmann.javafx.aqua;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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

    public static <T extends Control> void resizeControl(T control, ControlSizeVariant controlSizeVariant) {
        styleFactory.addStyles(control, controlSizeVariant);
    }

    public static void setButtonIcon(Button button, MacOSDefaultIcons icon) {
        Region svgIcon = new Region();
        svgIcon.getStyleClass().add(icon.getStyleName());
        svgIcon.getStyleClass().add("aquaicon");
        button.setGraphic(svgIcon);
        button.getStyleClass().add("button-"+icon.getStyleName());
    }

    public static void setShareButton(Button button) {
        StackPane stack = new StackPane();
        String iconBase = MacOSDefaultIcons.SHARE.getStyleName();
        stack.getStyleClass().add("aquaicon");

        Region svgIcon = new Region();
        svgIcon.getStyleClass().add(iconBase + "-square");
        stack.getChildren().add(svgIcon);

        Region svgIcon2 = new Region();
        svgIcon2.getStyleClass().add(iconBase + "-arrow");
        stack.getChildren().add(svgIcon2);

        button.setGraphic(stack);
    }

    public static void styleSearchField(TextField textField, MacOSDefaultIcons icon) {
        textField.getStyleClass().add(icon.getStyleName());
    }

    public static void setGroupBox(Pane pane) {
        pane.getStyleClass().add("aqua-group-box");
    }

    public static void styleStage(Stage stage, StageStyle style) {
        stage.initStyle(style);
    }
}
