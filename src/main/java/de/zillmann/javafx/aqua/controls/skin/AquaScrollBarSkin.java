package de.zillmann.javafx.aqua.controls.skin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.util.Duration;

import com.sun.javafx.scene.control.skin.ScrollBarSkin;

import de.zillmann.javafx.aqua.util.BindableTransition;

public class AquaScrollBarSkin extends ScrollBarSkin {

	private BindableTransition defaultScrollbarTransition;

	public AquaScrollBarSkin(ScrollBar scrollBar) {
		super(scrollBar);

		// scrollBar.setVisible(false);

		registerChangeListener(scrollBar.hoverProperty(), "HOVER");
		registerChangeListener(scrollBar.valueProperty(), "VALUE");
		registerChangeListener(scrollBar.visibleProperty(), "VISIBLE");
	}

	@Override
	protected void handleControlPropertyChanged(String p) {
		super.handleControlPropertyChanged(p);
		if (p == "HOVER") {
			setDefaultScrollbarAnimation();
		}
		if (p == "VALUE") {
			/*
			 * when value changes, scrolling is activated and the scrollbar has
			 * to be visible for some time and disappear again, when there is no
			 * further interaction
			 */
			// System.out.println("scroll");
			// if (!getSkinnable().isVisible()) {
			// getSkinnable().setVisible(true);
			// }
		}
		// if (p=="VISIBLE"){
		// if (getSkinnable().isVisible()){
		// getSkinnable().setVisible(false);
		// }
		// }
	}

	private void setDefaultScrollbarAnimation() {
		if (getSkinnable().isHover()) {

			if (defaultScrollbarTransition == null) {

				final Duration duration = Duration.millis(200);
				defaultScrollbarTransition = new BindableTransition(duration);
				defaultScrollbarTransition.setCycleCount(1);

				final double startWidth = 4;
				final double endWidth = 6;

				defaultScrollbarTransition.fractionProperty().addListener(
						new ChangeListener<Number>() {

							@Override
							public void changed(
									ObservableValue<? extends Number> observable,
									Number oldValue, Number newValue) {

								for (int i = 0; i < getChildren().size(); i++) {
									Node child = getChildren().get(i);
									if (child.getStyleClass().get(0)
											.equals("increment-button")
											|| child.getStyleClass().get(0)
													.equals("decrement-button")) {
										if (getSkinnable().getOrientation() == Orientation.VERTICAL) {
											child.setStyle("-fx-padding: 0.0em "
													+ ((endWidth - startWidth)
															* newValue
																	.doubleValue() + startWidth)
													+ "pt 0.0em 0.0em;}");
										} else if (getSkinnable()
												.getOrientation() == Orientation.HORIZONTAL) {
											child.setStyle("-fx-padding: "
													+ ((endWidth - startWidth)
															* newValue
																	.doubleValue() + startWidth)
													+ "pt  0.0em 0.0em 0.0em;}");
										}
									}
								}
							}
						});
			}
			defaultScrollbarTransition.play();
		} else {
			if (defaultScrollbarTransition != null) {
				defaultScrollbarTransition.stop();
			}
			if (getSkinnable().getOrientation() == Orientation.VERTICAL) {
				getSkinnable().setStyle(" -fx-padding: -1.0 0.0 -1.0 0.0;");
			}else{
				getSkinnable().setStyle(" -fx-padding: 0.0 0.0 0.0 0.0;");
			}
			for (int i = 0; i < getChildren().size(); i++) {
				Node child = getChildren().get(i);
				if (child.getStyleClass().get(0).equals("track")) {
					if (getSkinnable().getOrientation() == Orientation.VERTICAL) {
						child.setStyle("-fx-background-color: linear-gradient(rgb(238.0, 238.0, 238.0, 0.8) 0.0%, rgb(255.0, 255.0, 255.0, 0.8) 100.0%);"
								+ "-fx-border-width: 0.0 0.0 0.0 1.0;"
								+ "-fx-border-insets: 0.0 0.0 0.0 -1.0;"
								+ "-fx-border-color: rgb(198.0, 198.0, 198.0);");
					} else if (getSkinnable().getOrientation() == Orientation.HORIZONTAL) {
						child.setStyle("-fx-background-color: linear-gradient(rgb(238.0, 238.0, 238.0, 0.8) 0.0%, rgb(255.0, 255.0, 255.0, 0.8) 100.0%);"
								+ "-fx-border-width: 1.0 0.0 0.0 0.0;"
								+ "-fx-border-insets: -1.0 0.0 0.0 0.0;"
								+ "-fx-border-color: rgb(198.0, 198.0, 198.0);");
					}
				} else if (child.getStyleClass().get(0).equals("thumb")) {
					if (getSkinnable().getOrientation() == Orientation.VERTICAL) {
						child.setStyle("-fx-background-radius: 6.0;"
								+ "-fx-background-insets: 0.0 2.0 0.0 2.0;");
					} else if (getSkinnable().getOrientation() == Orientation.HORIZONTAL) {
						child.setStyle("-fx-background-radius: 6.0;"
								+ "-fx-background-insets: 2.0 0.0 2.0 0.0;");
					}
				} else if (child.getStyleClass().get(0)
						.equals("increment-button")
						|| child.getStyleClass().get(0)
								.equals("decrement-button")) {
					if (getSkinnable().getOrientation() == Orientation.VERTICAL) {
						child.setStyle("-fx-padding: 0.0em 6.0pt 0.0em 0.0em");
					} else if (getSkinnable().getOrientation() == Orientation.HORIZONTAL) {
						child.setStyle("-fx-padding: 6.0pt 0.0em 0.0em 0.0em");
					}
				}
			}
		}
	}
}
