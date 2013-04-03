package de.zillmann.javafx.aqua.controls.skin;

import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import com.sun.javafx.scene.control.skin.TabPaneSkin;

public class AquaTabPaneSkin extends TabPaneSkin {

    public AquaTabPaneSkin(TabPane tabPane) {
        super(tabPane);

        ObservableList<Tab> list = getSkinnable().getTabs();
        list.get(0).getStyleClass().add("first-tab");
        list.get(list.size() - 1).getStyleClass().add("last-tab");

    }
}
