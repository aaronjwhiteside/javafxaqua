package de.zillmann.javafx.aqua.controls.skin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;

public class AquaComboBoxListViewSkin<T> extends ComboBoxListViewSkin {

    public AquaComboBoxListViewSkin(ComboBox comboBox) {
        super(comboBox);

        for (int i = 0; i < getChildren().size(); i++) {

            Node child = (Node) getChildren().get(i);
            child.focusedProperty().addListener(focusListener);
        }
        if (comboBox.isEditable()) {
            getDisplayNode().focusedProperty().addListener(focusListener);
        }
        getListView().focusedProperty().addListener(focusListener);
        getSkinnable().focusedProperty().addListener(focusListener);
    }

    private ChangeListener focusListener = new ChangeListener() {

        @Override public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            if ((Boolean) newValue) {
                setFocusBorder();
                System.out.println("focused");
            } else {
                getSkinnable().setEffect(null);
            }
        }
    };

    private void setFocusBorder() {
        InnerShadow innerFocus = new InnerShadow();
        innerFocus.setColor(Color.rgb(104, 155, 201));
        innerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        innerFocus.setRadius(5.5);
        innerFocus.setChoke(0.6);
        innerFocus.setOffsetX(0.0);
        innerFocus.setOffsetY(0.0);

        DropShadow outerFocus = new DropShadow();
        outerFocus.setColor(Color.rgb(96, 156, 209, 0.8));
        outerFocus.setBlurType(BlurType.ONE_PASS_BOX);
        outerFocus.setRadius(10.0);
        outerFocus.setSpread(0.5);
        outerFocus.setOffsetX(0.0);
        outerFocus.setOffsetY(0.0);
        outerFocus.setInput(innerFocus);

        getSkinnable().setEffect(outerFocus);
    }

}
