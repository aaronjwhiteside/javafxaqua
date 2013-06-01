package com.aquafx_project.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import com.aquafx_project.controls.skin.AquaButtonSkin;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.aquafx_project.controls.skin.styles.ControlSizeVariant;
import com.aquafx_project.controls.skin.styles.IllegalStyleCombinationException;
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons;
import com.aquafx_project.controls.skin.styles.StyleDefinition;
import com.aquafx_project.controls.skin.styles.Styler;

import javafx.scene.control.Button;
import javafx.scene.control.Skin;

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
