package de.zillmann.javafx.aqua;

import javafx.application.Application;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleFactory;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ButtonStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.CheckBoxStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ChoiceBoxStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ColorPickerStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ComboBoxStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.LabelStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.PasswordFieldStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ProgressBarStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ProgressIndicatorStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.RadioButtonStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ScrollBarStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.SliderStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.TabPaneStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.TextAreaStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.TextFieldStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ToggleButtonStyler;
import de.zillmann.javafx.aqua.controls.skin.styles.styler.ToolBarStyler;

public class AquaFx {

    private final static String AQUA_CSS_NAME = AquaFx.class.getResource("mac_os.css").toExternalForm();

    private static StyleFactory styleFactory = new StyleFactory();

    public static void style() {
        Application.setUserAgentStylesheet(AQUA_CSS_NAME);
    }

    public static void styleStage(Stage stage, StageStyle style) {
        stage.initStyle(style);
    }

    public static <T extends Control> void resizeControl(T control, ControlSizeVariant controlSizeVariant) {
        styleFactory.addStyles(control, controlSizeVariant);
    }

    // public static void skin(Button button, ControlSizeVariant controlSizeVariant) {
    // skin(button, ButtonType.DEFAULT, controlSizeVariant);
    // }
    //
    // public static void skin(Button button, ButtonType buttonType) {
    // skin(button, buttonType, ControlSizeVariant.REGULAR);
    // }
    //
    // public static void skin(Button button, ButtonType buttonType, ControlSizeVariant
    // controlSizeVariant) {
    // ButtonStyler.create().setSizeVariant(controlSizeVariant).setType(buttonType).style(button);
    // }
    //
    // public static void setButtonIcon(Button button, MacOSDefaultIcons icon) {
    // ButtonStyler.create().setIcon(icon).style(button);
    // }
    //
    // public static void setShareButton(Button button) {
    // ButtonStyler.create().setIcon(MacOSDefaultIcons.SHARE).style(button);
    // }
    //
    // public static void styleSearchField(TextField textField) {
    // textField.getStyleClass().add(MacOSDefaultIcons.SEARCH.getStyleName());
    // }

    public static void setGroupBox(Pane pane) {
        pane.getStyleClass().add("aqua-group-box");
    }

    /***************************************************************
     * * StylerClasses for skinned Controls * *
     **************************************************************/

    public static ButtonStyler createButtonStyler() {
        return ButtonStyler.create();
    }

    public static ToggleButtonStyler createToggleButtonStyler() {
        return ToggleButtonStyler.create();
    }

    public static LabelStyler createLabelStyler() {
        return LabelStyler.create();
    }

    public static TextFieldStyler createTextFieldStyler() {
        return TextFieldStyler.create();
    }

    public static TextAreaStyler createTextAreaStyler() {
        return TextAreaStyler.create();
    }

    public static PasswordFieldStyler createPasswordFieldStyler() {
        return PasswordFieldStyler.create();
    }

    public static CheckBoxStyler createCheckBoxStyler() {
        return CheckBoxStyler.create();
    }

    public static RadioButtonStyler createRadioButtonStyler() {
        return RadioButtonStyler.create();
    }

    public static ChoiceBoxStyler createChoiceBoxStyler() {
        return ChoiceBoxStyler.create();
    }

    public static ComboBoxStyler createComboBoxStyler() {
        return ComboBoxStyler.create();
    }

    public static ColorPickerStyler createColorPickerStyler() {
        return ColorPickerStyler.create();
    }

    public static ProgressBarStyler createProgressBarStyler() {
        return ProgressBarStyler.create();
    }

    public static ProgressIndicatorStyler createProgressIndicatorStyler() {
        return ProgressIndicatorStyler.create();
    }

    public static SliderStyler createSliderStyler() {
        return SliderStyler.create();
    }

    public static ScrollBarStyler createScrollBarStyler() {
        return ScrollBarStyler.create();
    }

    public static TabPaneStyler createTabPaneStyler() {
        return TabPaneStyler.create();
    }

    public static ToolBarStyler createToolBarStyler() {
        return ToolBarStyler.create();
    }
}
