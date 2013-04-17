package de.zillmann.javafx.aqua.controls.skin;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

import com.sun.javafx.scene.control.skin.TabPaneSkin;

public class AquaTabPaneSkin extends TabPaneSkin {

    public AquaTabPaneSkin(TabPane tabPane) {
        super(tabPane);

        definePillPosition();
        adjustBorders();

        /**
         * Tabs are not closeable in Aqua
         */
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

    }

    @Override protected void handleControlPropertyChanged(String property) {
        super.handleControlPropertyChanged(property);
        if ("SIDE".equals(property)) {
            definePillPosition();
        }
        if ("SELECTED_TAB".equals(property)) {
            adjustBorders();
        }
    }

    private void definePillPosition() {
        ObservableList<Tab> list = getSkinnable().getTabs();
        if (list.size() > 1) {
            if (getSkinnable().getSide() == Side.TOP || getSkinnable().getSide() == Side.RIGHT) {
                list.get(0).getStyleClass().add("first-tab");
                list.get(list.size() - 1).getStyleClass().add("last-tab");
            } else if (getSkinnable().getSide() == Side.BOTTOM || getSkinnable().getSide() == Side.LEFT) {
                list.get(0).getStyleClass().add("last-tab");
                list.get(list.size() - 1).getStyleClass().add("first-tab");
            }
        } else {
            list.get(0).getStyleClass().add("single-tab");
        }
    }

    private void adjustBorders() {
        boolean foundSelected = false;
        List<Tab> tabs = getSkinnable().getTabs();
        Tab selectedTab = getSkinnable().getSelectionModel().getSelectedItem();
        for (Tab tab : tabs) {
            tab.getStyleClass().remove("neighbor");
            if (foundSelected) {
                tab.getStyleClass().add("neighbor");
                foundSelected = false;
            }
            if (tab.equals(selectedTab)) {
                foundSelected = true;
            }
        }
    }
}
