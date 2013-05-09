package de.zillmann.javafx.aqua.controls.skin;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundFillBuilder;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.util.Duration;

import com.sun.javafx.scene.control.skin.ProgressBarSkin;

import de.zillmann.javafx.aqua.util.BindableTransition;

public class AquaProgressBarSkin extends ProgressBarSkin {

    private BindableTransition indeterminateProgressTransition;

    public AquaProgressBarSkin(ProgressBar progressBar) {
        super(progressBar);

        // Bar bar = progressBar.lookup("bar");
        if (progressBar.isIndeterminate()) {
            setIndeterminateProgressAnimation();
        }
        registerChangeListener(progressBar.disabledProperty(), "DISABLED");
    }

    @Override protected void handleControlPropertyChanged(String propertyReference) {
        super.handleControlPropertyChanged(propertyReference);

        if (propertyReference == "DISABLED") {
            if (getSkinnable().isIndeterminate()) {
                if (getSkinnable().isDisabled() && indeterminateProgressTransition != null && indeterminateProgressTransition.getStatus() != Status.RUNNING) {
                    indeterminateProgressTransition.stop();
                } else {
                    setIndeterminateProgressAnimation();
                }
            }
        }
    }

    private void setIndeterminateProgressAnimation() {
        if (!getSkinnable().isDisabled()) {
            if (indeterminateProgressTransition != null && indeterminateProgressTransition.getStatus() == Status.RUNNING) {
                indeterminateProgressTransition.stop();
            } else {

                final Duration duration = Duration.millis(2000);
                indeterminateProgressTransition = new BindableTransition(duration);
                indeterminateProgressTransition.setCycleCount(Timeline.INDEFINITE);
                indeterminateProgressTransition.setAutoReverse(false);
                indeterminateProgressTransition.setInterpolator(Interpolator.LINEAR);

                indeterminateProgressTransition.fractionProperty().addListener(new ChangeListener<Number>() {

                    @Override public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                        double startX = newValue.doubleValue() * 0.94;
                        double endX = newValue.doubleValue() * 0.94 + 0.05d;

                        List<BackgroundFill> list = new ArrayList<>();

                        list.add(BackgroundFillBuilder.create().fill(
                                LinearGradientBuilder.create().startX(1.0).stops(new Stop(0.0f, Color.rgb(176, 176, 176)),
                                        new Stop(1f, Color.rgb(207, 207, 207))).build()).radii(new CornerRadii(2.0)).build());

                        // the animated fill
                        list.add(BackgroundFillBuilder.create().fill(
                                LinearGradientBuilder.create().startX(startX).startY(0.45).endX(endX).endY(0.0).cycleMethod(
                                        CycleMethod.REFLECT).stops(new Stop(0.5f, Color.rgb(84, 169, 239)),
                                        new Stop(0.5f, Color.rgb(236, 236, 236))).build()).radii(new CornerRadii(2.0)).build());

                        list.add(BackgroundFillBuilder.create().fill(
                                LinearGradientBuilder.create().startX(1.0).stops(new Stop(0.05f, Color.rgb(255, 255, 255, 0.7)),
                                        new Stop(0.05f, Color.rgb(255, 255, 255, 0.55)),
                                        new Stop(0.5f, Color.rgb(255, 255, 255, 0.1)),
                                        new Stop(0.5f, Color.rgb(255, 255, 255, 0.0)),
                                        new Stop(0.6f, Color.rgb(255, 255, 255, 0.0)),
                                        new Stop(0.85f, Color.rgb(255, 255, 255, 0.4)),
                                        new Stop(1f, Color.rgb(245, 245, 245, 0.7))).build()).radii(new CornerRadii(2.0)).build());
                        getSkinnable().setBackground(new Background(list, null));
                    }

                });

                indeterminateProgressTransition.play();
            }
        }
    }

}
