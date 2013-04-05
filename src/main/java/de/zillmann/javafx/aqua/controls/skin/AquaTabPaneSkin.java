package de.zillmann.javafx.aqua.controls.skin;

import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import com.sun.javafx.scene.control.skin.TabPaneSkin;

public class AquaTabPaneSkin extends TabPaneSkin {

    public AquaTabPaneSkin(TabPane tabPane) {
        super(tabPane);

        definePillPosition();
    }

    @Override protected void handleControlPropertyChanged(String property) {
        super.handleControlPropertyChanged(property);
        if ("SIDE".equals(property)) {
            definePillPosition();
        }
    }

    private void definePillPosition() {
        ObservableList<Tab> list = getSkinnable().getTabs();
        if (getSkinnable().getSide() == Side.TOP || getSkinnable().getSide() == Side.RIGHT) {
            list.get(0).getStyleClass().add("first-tab");
            list.get(list.size() - 1).getStyleClass().add("last-tab");
        } else if (getSkinnable().getSide() == Side.BOTTOM || getSkinnable().getSide() == Side.LEFT) {
            list.get(0).getStyleClass().add("last-tab");
            list.get(list.size() - 1).getStyleClass().add("first-tab");
        }
    }
}
