package de.zillmann.javafx.aqua.controls.skin;

import javafx.animation.Animation.Status;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import com.sun.javafx.scene.control.skin.ButtonSkin;

import de.zillmann.javafx.aqua.util.BindableTransition;

public class AquaButtonSkin extends ButtonSkin {

	private DropShadow shadow;

	private BindableTransition defaulButtonTransition;

	public AquaButtonSkin(Button button) {
		super(button);

		registerChangeListener(button.defaultButtonProperty(), "BUTTON_SIZE");
		registerChangeListener(button.pressedProperty(), "PRESSED");

		if (getSkinnable().isDefaultButton()) {
			/*
			 * * were we already the defaultButton, before the listener was
			 * added?* don't laugh, it can happen....
			 */
			setDefaultButtonAnimation();
		}

		if ((String) getSkinnable().getProperties().get("BUTTON_SIZE") != null) {
			String property = (String) getSkinnable().getProperties().get(
					"BUTTON_SIZE");
			if (property.equals("small")) {
				getSkinnable().getStyleClass().setAll("button_small");
			} else if (property.equals("medium")) {

			} else if (property.equals("large")) {

			}
		}

		shadow = new DropShadow();
		shadow.setColor(Color.rgb(215, 215, 215));
		shadow.setBlurType(BlurType.GAUSSIAN);
		shadow.setRadius(1.5);
		shadow.setSpread(0.3);
		shadow.setOffsetX(0.0);
		shadow.setOffsetY(1.0);
		getSkinnable().setEffect(shadow);

		/**
		 * TODO: pressed muss blinken bei default beenden und pressed-style
		 * zeigen zieht man die gedrückte maus raus, dann normalen button
		 * anzeigen hover darf kein neu-zeichnen auslösen...
		 */
		getSkinnable().setOnMousePressed(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				if (getSkinnable().isDefaultButton()) {
					defaulButtonTransition.stop();
					firstDefaultCssUpdate = true;
				}
			}
		});

		getSkinnable().setOnMouseReleased(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				if (getSkinnable().isDefaultButton()) {
					defaulButtonTransition.play();
					firstDefaultCssUpdate = false;
				}
			}
		});

		getSkinnable().setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {

				if (getSkinnable().isDefaultButton()
						&& getSkinnable().isArmed()) {
					firstDefaultCssUpdate = true;
//					impl_processCSS(true);
				}
			}
		});

		final ChangeListener<Boolean> windowFocusChangedListener = new ChangeListener<Boolean>() {

			@Override
			public void changed(
					ObservableValue<? extends Boolean> observableValue,
					Boolean oldValue, Boolean newValue) {
				if (newValue != null) {
					if (newValue.booleanValue()) {
						if (getSkinnable().isDefaultButton()
								&& defaulButtonTransition != null
								&& defaulButtonTransition.getStatus() != Status.RUNNING) {
							setDefaultButtonAnimation();
						}
					} else {
						if (getSkinnable().isDefaultButton()
								&& defaulButtonTransition != null
								&& defaulButtonTransition.getStatus() == Status.RUNNING) {
							setDefaultButtonAnimation();
//							impl_processCSS(true);
						}
					}
				}
			}
		};

		getSkinnable().sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(
					ObservableValue<? extends Scene> observableValue,
					Scene oldScene, Scene newScene) {
				if (oldScene != null && oldScene.getWindow() != null) {
					oldScene.getWindow().focusedProperty()
							.removeListener(windowFocusChangedListener);
				}
				if (newScene != null && newScene.getWindow() != null) {
					newScene.getWindow().focusedProperty()
							.addListener(windowFocusChangedListener);
				}

			}
		});

		if (getSkinnable().getScene() != null
				&& getSkinnable().getScene().getWindow() != null) {
			getSkinnable().getScene().getWindow().focusedProperty()
					.addListener(windowFocusChangedListener);
		}
	}

	private void setFocusBorder() {
		InnerShadow innerFocus = new InnerShadow();
		innerFocus.setColor(Color.rgb(122, 170, 217, 0.5));
		innerFocus.setBlurType(BlurType.GAUSSIAN);
		innerFocus.setRadius(5.0);
		innerFocus.setChoke(0.8);
		innerFocus.setOffsetX(0.0);
		innerFocus.setOffsetY(0.0);

		DropShadow outerFocus = new DropShadow();
		outerFocus.setColor(Color.rgb(122, 170, 217));
		outerFocus.setBlurType(BlurType.GAUSSIAN);
		outerFocus.setRadius(6.0);
		outerFocus.setSpread(0.6);
		outerFocus.setOffsetX(0.0);
		outerFocus.setOffsetY(0.0);
		outerFocus.setInput(innerFocus);
		getSkinnable().setEffect(outerFocus);
	}

	@Override
	protected void handleControlPropertyChanged(String p) {
		super.handleControlPropertyChanged(p);
		if (p == "PRESSED") {
			// TODO: FOKUSWECHSEL VERHINDERN...

			if (getSkinnable().isFocused() ) {
				setFocusBorder();
			}
		}
		if (p == "FOCUSED") {

			if (getSkinnable().isFocused() && getSkinnable().isDefaultButton()) {
				DropShadow outerFocus = new DropShadow();
				outerFocus.setColor(Color.rgb(122, 170, 217));
				outerFocus.setBlurType(BlurType.GAUSSIAN);
				outerFocus.setRadius(6.0);
				outerFocus.setSpread(0.6);
				outerFocus.setOffsetX(0.0);
				outerFocus.setOffsetY(0.0);
				getSkinnable().setEffect(outerFocus);
			} else if (getSkinnable().isFocused()) {
				setFocusBorder();
			} else if (!getSkinnable().isFocused()) {
				getSkinnable().setEffect(shadow);
			}
		}
		if (p == "DEFAULT_BUTTON") {
			setDefaultButtonAnimation();
		}
		if (p == "BUTTON_SIZE") {
			String property = (String) getSkinnable().getProperties().get(
					"BUTTON_SIZE");
			if (property.equals("small")) {
				getSkinnable().getStyleClass().setAll("button_small");
			} else if (property.equals("medium")) {

			} else if (property.equals("large")) {

			}
		}

	}

	private void setDefaultButtonAnimation() {
		if (defaulButtonTransition != null
				&& defaulButtonTransition.getStatus() == Status.RUNNING) {
			defaulButtonTransition.stop();
			firstDefaultCssUpdate = true;
		} else {
			final Duration duration = Duration.millis(500);
			defaulButtonTransition = new BindableTransition(duration);
			defaulButtonTransition.setCycleCount(Timeline.INDEFINITE);
			defaulButtonTransition.setAutoReverse(true);

			// The gradient
			final Color startColor1 = Color.rgb(207, 229, 243);
			final Color endColor1 = Color.rgb(175, 203, 247);
			final Color startColor2 = Color.rgb(120, 176, 238);
			final Color endColor2 = Color.rgb(74, 138, 217);
			final Color startColor3 = Color.rgb(192, 227, 243);
			final Color endColor3 = Color.rgb(152, 201, 238);

//			defaulButtonTransition.fractionProperty().addListener(
//					new ChangeListener<Number>() {
//
//						@Override
//						/**
//						 * Very very very bad bad bad (!!) hack to simulate the blinking of a default-button.
//						 * Because the background-color of a button cannot be changed by code I needed this dirty thing. Should be changed as soon as possible..
//						 * Thanks to hendrikebbers for his BindableTransition.
//						 * 
//						 * The gradient rgb(207, 229, 243) 0%, rgb(120, 176, 238) 51%, rgb(192, 227, 243) 100% changes to rgb(165, 193,238) 0%, rgb(74, 138, 217) 50%, rgb(152, 201, 238) 100% and back
//						 * 
//						 * @param observableValue
//						 * @param oldValue
//						 * @param newValue
//						 */
//						public void changed(
//								ObservableValue<? extends Number> observableValue,
//								Number oldValue, Number newValue) {
//
//							List<BackgroundFill> liste = new ArrayList<BackgroundFill>();
//							liste.add(// the border
//							BackgroundFillCreator.create(
//									LinearGradientBuilder
//											.create()
//											.startX(1.0)
//											.stops(new Stop(0f, Color.rgb(82,
//													83, 170)),
//													new Stop(1f, Color.rgb(69,
//															69, 112))).build(),
//									5.0, Insets.EMPTY));
//							liste.add(BackgroundFillCreator.create(
//									LinearGradientBuilder
//											.create()
//											.startX(1.0)
//											.stops(new Stop(
//													0f,
//													Color.color(
//															(endColor1.getRed() - startColor1
//																	.getRed())
//																	* newValue
//																			.doubleValue()
//																	+ startColor1
//																			.getRed(),
//															(endColor1
//																	.getGreen() - startColor1
//																	.getGreen())
//																	* newValue
//																			.doubleValue()
//																	+ startColor1
//																			.getGreen(),
//															(endColor1
//																	.getBlue() - startColor1
//																	.getBlue())
//																	* newValue
//																			.doubleValue()
//																	+ startColor1
//																			.getBlue())),
//													new Stop(
//															0.51f,
//															Color.color(
//																	(endColor2
//																			.getRed() - startColor2
//																			.getRed())
//																			* newValue
//																					.doubleValue()
//																			+ startColor2
//																					.getRed(),
//																	(endColor2
//																			.getGreen() - startColor2
//																			.getGreen())
//																			* newValue
//																					.doubleValue()
//																			+ startColor2
//																					.getGreen(),
//																	(endColor2
//																			.getBlue() - startColor2
//																			.getBlue())
//																			* newValue
//																					.doubleValue()
//																			+ startColor2
//																					.getBlue())),
//													new Stop(
//															1f,
//															Color.color(
//																	(endColor3
//																			.getRed() - startColor3
//																			.getRed())
//																			* newValue
//																					.doubleValue()
//																			+ startColor3
//																					.getRed(),
//																	(endColor3
//																			.getGreen() - startColor3
//																			.getGreen())
//																			* newValue
//																					.doubleValue()
//																			+ startColor3
//																					.getGreen(),
//																	(endColor3
//																			.getBlue() - startColor3
//																			.getBlue())
//																			* newValue
//																					.doubleValue()
//																			+ startColor3
//																					.getBlue())))
//											.build(), 4.0, new Insets(1.0)));
//
//							AquaButtonSkin.this.impl_setBackgroundFills(liste);
//						}
//					});

			firstDefaultCssUpdate = false;
			defaulButtonTransition.play();
		}
	}

	private boolean firstDefaultCssUpdate = true;

//	@Override
//	public void impl_processCSS(boolean reapply) {
//		if (defaulButtonTransition != null
//				&& defaulButtonTransition.getStatus() == Status.RUNNING
//				&& firstDefaultCssUpdate) {
//			return;
//		} else {
//			super.impl_processCSS(reapply);
//			if (defaulButtonTransition != null
//					&& defaulButtonTransition.getStatus() == Status.RUNNING) {
//				firstDefaultCssUpdate = true;
//			}
//		}
//	}
}
