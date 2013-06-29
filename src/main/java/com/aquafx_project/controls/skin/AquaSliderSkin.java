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

import javafx.scene.Node;
import javafx.scene.control.Slider;

import com.aquafx_project.controls.skin.effects.FocusBorder;
import com.sun.javafx.scene.control.skin.SliderSkin;


public class AquaSliderSkin extends SliderSkin implements AquaSkin{

    public AquaSliderSkin(Slider slider) {
        super(slider);

        if (getSkinnable().isFocused()) {
            setFocusBorder();
        }
        
        registerChangeListener(slider.focusedProperty(), "FOCUSED");

        if (slider.isShowTickMarks()) {
            slider.getStyleClass().add("alternative-thumb");
        }
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);

        if (p == "FOCUSED") {
            if (getSkinnable().isFocused()) {
                setFocusBorder();
            } else {
                for (Node child : getChildren()) {
                    if (child.getStyleClass().get(0).equals("thumb")) {
                        child.setEffect(null);
                    }
                }
            }
        }
    }

    private void setFocusBorder() {
        for (Node child : getChildren()) {
            if (child.getStyleClass().get(0).equals("thumb")) {
                child.setEffect(new FocusBorder());
                getSkinnable().impl_reapplyCSS();
            }
        }
    }

}
