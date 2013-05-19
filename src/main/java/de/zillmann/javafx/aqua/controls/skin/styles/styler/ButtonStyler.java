package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import de.zillmann.javafx.aqua.controls.skin.AquaButtonSkin;
import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.IllegalStyleCombinationException;
import de.zillmann.javafx.aqua.controls.skin.styles.MacOSDefaultIcons;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;

public class ButtonStyler extends Styler<Button> {

    private ButtonType type;
    private MacOSDefaultIcons icon;

    private ButtonStyler() {}

    public static ButtonStyler create() {
        return new ButtonStyler();
    }

    public ButtonStyler setType(ButtonType type) {
        this.type = type;
        check();
        return this;
    }

    @Override public ButtonStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (ButtonStyler) super.setSizeVariant(sizeVariant);
    }

    public ButtonStyler setIcon(MacOSDefaultIcons icon) {
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

    @Override public void style(final Button button) {
        super.style(button);
        button.setSkin(new AquaButtonSkin(button));
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
