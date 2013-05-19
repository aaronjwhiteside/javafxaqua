package de.zillmann.javafx.aqua.controls.skin.styles.styler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Skin;
import javafx.scene.control.TextField;
import de.zillmann.javafx.aqua.controls.skin.AquaTextFieldSkin;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.IllegalStyleCombinationException;
import de.zillmann.javafx.aqua.controls.skin.styles.StyleDefinition;
import de.zillmann.javafx.aqua.controls.skin.styles.Styler;
import de.zillmann.javafx.aqua.controls.skin.styles.TextFieldType;

public class TextFieldStyler extends Styler<TextField> {

    private TextFieldType type;

    public static TextFieldStyler create() {
        return new TextFieldStyler();
    }

    public TextFieldStyler setType(TextFieldType type) {
        this.type = type;
        check();
        return this;
    }

    @Override public TextFieldStyler setSizeVariant(ControlSizeVariant sizeVariant) {
        return (TextFieldStyler) super.setSizeVariant(sizeVariant);
    }

    @Override public List<StyleDefinition> getAll() {
        List<StyleDefinition> ret = new ArrayList<>(super.getAll());
        ret.add(sizeVariant);
        ret.add(type);
        return ret;
    }

    @Override public void check() {
        if (type != null && type.equals(TextFieldType.SEARCH) && sizeVariant == ControlSizeVariant.MINI) {
            throw new IllegalStyleCombinationException();
        }
    }

    @Override public void style(final TextField textField) {
        super.style(textField);
        textField.setSkin(new AquaTextFieldSkin(textField));
        if (type != null && type == TextFieldType.SEARCH) {
            // Platform.runLater(new Runnable() {
            // @Override public void run() {
            Skin<?> skin = textField.getSkin();
            if (skin != null && skin instanceof AquaTextFieldSkin) {
                ((AquaTextFieldSkin) skin).showSearchIconProperty().setValue(true);
            }
            // }
            // });
        } else if (type != null && type != TextFieldType.SEARCH) {
            // Platform.runLater(new Runnable() {
            // @Override public void run() {
            Skin<?> skin = textField.getSkin();
            if (skin != null && skin instanceof AquaTextFieldSkin) {
                ((AquaTextFieldSkin) skin).showSearchIconProperty().setValue(false);
            }
            // }
            // });
        }
    }
}
