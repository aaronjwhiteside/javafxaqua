package de.zillmann.javafx.aqua.controls.skin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
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
        setBoxShadow();

        registerChangeListener(checkbox.focusedProperty(), "FOCUSED");
        registerChangeListener(checkbox.selectedProperty(), "SELECTED");

        final ChangeListener<Boolean> windowFocusChangedListener = new ChangeListener<Boolean>() {

            @Override
            public void changed(
                    ObservableValue<? extends Boolean> observableValue,
                    Boolean oldValue, Boolean newValue) {
                if (newValue != null) {
                    if (!newValue.booleanValue()) {
                        if (getSkinnable().isSelected()
                                | getSkinnable().isIndeterminate()) {

                            for (int i = 0; i < getChildren().size(); i++) {
                                Node child = getChildren().get(i);
                                if (child.getStyleClass().get(0).equals("box")) {
                                    child.setStyle("   -fx-border-radius: 2.5;"
                                            + "-fx-border-width: 0.5;"
                                            + "-fx-border-color: rgb(129, 129, 129);"
                                            + "-fx-background-color: rgb(250, 250, 250),"
                                            + "	linear-gradient(rgb(255, 255, 255) 0%, rgb(253,253,253) 25%,  "
                                            + "	rgb(244, 244, 244) 50%, rgb(236, 236, 236) 51%, rgb(243, 243, 243) 100% );"
                                            + "-fx-background-insets: 0, 1;"
                                            + "-fx-background-radius: 2.5, 2.5;"
                                            + "-fx-padding: 6;");
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < getChildren().size(); i++) {
                            Node child = getChildren().get(i);
                            if (child.getStyleClass().get(0).equals("box")) {
                                child.setStyle(null);
                            }
                        }
                    }
                }

            }
        };

        getSkinnable().sceneProperty().addListener(new ChangeListener<Scene>() {

            @Override
            public void changed(
                    ObservableValue<? extends Scene> observableValue,
                    Scene oldScene, Scene newScene) {
                if (oldScene != null && oldScene.getWindow() != null) {
                    oldScene.getWindow().focusedProperty()
                            .removeListener(windowFocusChangedListener);
                }
                if (newScene != null && newScene.getWindow() != null) {
                    newScene.getWindow().focusedProperty()
                            .addListener(windowFocusChangedListener);
                }

            }
        });

        if (getSkinnable().getScene() != null
                && getSkinnable().getScene().getWindow() != null) {
            getSkinnable().getScene().getWindow().focusedProperty()
                    .addListener(windowFocusChangedListener);
        }

    }

    private void setBoxShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(172, 172, 184));
        shadow.setBlurType(BlurType.ONE_PASS_BOX);
        shadow.setRadius(2.0);
        shadow.setSpread(0.1);
        shadow.setOffsetX(0.0);
        shadow.setOffsetY(0.8);

        for (int i = 0; i < getChildren().size(); i++) {
            Node child = getChildren().get(i);
            if (child.getStyleClass().get(0).equals("box")) {
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
