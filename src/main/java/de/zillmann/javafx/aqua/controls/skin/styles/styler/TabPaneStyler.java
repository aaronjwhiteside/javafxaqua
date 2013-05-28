package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.IllegalStyleCombinationException;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;
import de.zillmann.javafx.aqua.controls.skin.styles.TabPaneType;

public class TabPaneStyler extends Styler<TabPane> {

    private TabPaneType type;

    public static TabPaneStyler create() {
        return new TabPaneStyler();
    }

    @Override public TabPaneStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (TabPaneStyler) super.setSizeVariant(sizeVariant);
    }

    public TabPaneStyler setType(TabPaneType type) {
        this.type = type;
        check();
        return this;
    }

    @Override public void check() {
        if (type != null && type.equals(TabPaneType.SMALL_ICON_BUTTONS) && sizeVariant != null) {
            throw new IllegalStyleCombinationException();
        }
    }

    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        ret.add(type);
        return ret;
    }

    @Override public void style(final TabPane tabPane) {
        super.style(tabPane);
        if (type != null && type == TabPaneType.ICON_BUTTONS) {
            Platform.runLater(new Runnable() {
                
                @Override public void run() {
                    for (Tab tab : tabPane.getTabs()) {
                        if (tab.getGraphic() != null) {
                            tab.getGraphic().getStyleClass().add("icon");
                        }
                    }
                }
            });
            
        }
    }
}
