/**
 * Copyright (c) 2013, Claudine Zillmann
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of AquaFX, the website aquafx-project.com, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL CLAUDINE ZILLMANN BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.aquafx_project.controls.skin;

import java.util.List;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;

import com.aquafx_project.controls.skin.effects.FocusBorder;
import com.aquafx_project.controls.skin.effects.Shadow;
import com.aquafx_project.controls.skin.styles.ButtonType;
import com.sun.javafx.scene.control.skin.ToggleButtonSkin;


public class AquaToggleButtonSkin extends ToggleButtonSkin implements AquaSkin{

    public AquaToggleButtonSkin(ToggleButton button) {
        super(button);

        registerChangeListener(button.focusedProperty(), "FOCUSED");
        registerChangeListener(button.selectedProperty(), "SELECTED");

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        } else {
            setDropShadow();
        }

        if (getSkinnable().isSelected()) {
            adjustToggleGroupBorders();
        }

    }

    private void setFocusBorder() {
        getSkinnable().setEffect(new FocusBorder());
    }

    private void setDropShadow() {
        boolean isPill = false;
        if (getSkinnable().getStyleClass().contains(ButtonType.LEFT_PILL.getStyleName()) || getSkinnable().getStyleClass().contains(
                ButtonType.CENTER_PILL.getStyleName()) || getSkinnable().getStyleClass().contains(
                ButtonType.RIGHT_PILL.getStyleName())) {
            isPill = true;
        }
        getSkinnable().setEffect(new Shadow(isPill));
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);
        if (p == "FOCUSED") {
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else if (!getSkinnable().isFocused() || getSkinnable().isDisable()) {
                setDropShadow();
            }
        }
        if (p == "SELECTED") {
            adjustToggleGroupBorders();
        }
    }

    private void adjustToggleGroupBorders() {
        if (getSkinnable().isSelected() && getSkinnable().getToggleGroup() != null) {
            List<Toggle> toggles = getSkinnable().getToggleGroup().getToggles();
            int i = toggles.indexOf(getSkinnable().getToggleGroup().getSelectedToggle());
            if (toggles.size() > i + 1) {
                ToggleButton toggle = (ToggleButton) toggles.get(i + 1);
                toggle.getStyleClass().add("neighbor");
                for (int j = 0; toggles.size() > j; j++) {
                    if (j != i + 1) {
                        ((ToggleButton) toggles.get(j)).getStyleClass().remove("neighbor");
                    }
                }
            }
        } else if (!getSkinnable().isSelected() && getSkinnable().getToggleGroup() != null) {
            List<Toggle> toggles = getSkinnable().getToggleGroup().getToggles();
            int i = toggles.indexOf(getSkinnable());
            if (toggles.size() > i + 1) {
                ToggleButton toggle = (ToggleButton) toggles.get(i + 1);
                toggle.getStyleClass().remove("neighbor");
            }
        }
    }
}
