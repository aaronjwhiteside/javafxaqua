package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Skin;
import javafx.scene.control.ToggleButton;
import de.zillmann.javafx.aqua.controls.skin.AquaButtonSkin;
import de.zillmann.javafx.aqua.controls.skin.AquaToggleButtonSkin;
import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.IllegalStyleCombinationException;
import de.zillmann.javafx.aqua.controls.skin.styles.MacOSDefaultIcons;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

public class ToggleButtonStyler extends Styler<ToggleButton> {

    private ButtonType type;
    private MacOSDefaultIcons icon;

    private ToggleButtonStyler() {}

    public static ToggleButtonStyler create() {
        return new ToggleButtonStyler();
    }

    public ToggleButtonStyler setType(ButtonType type) {
        this.type = type;
        check();
        return this;
    }

    @Override public ToggleButtonStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ToggleButtonStyler) super.setSizeVariant(sizeVariant);
    }

    public ToggleButtonStyler setIcon(MacOSDefaultIcons icon) {
        this.icon = icon;
        check();
        return this;
    }

    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        ret.add(type);
        return ret;
    }

    @Override public void check() {
        if (type != null && type.equals(ButtonType.HELP) && icon != null) {
            throw new IllegalStyleCombinationException();
        }
    }

    @Override public void style(final ToggleButton button) {
        super.style(button);
        button.setSkin(new AquaToggleButtonSkin(button));
        // Platform.runLater(new Runnable() {
        // @Override public void run() {
        Skin<?> skin = button.getSkin();
        if (skin != null && skin instanceof AquaButtonSkin) {
            ((AquaButtonSkin) skin).iconProperty().setValue(icon);
        }
        // }
        // });
    }
}
