package ex04_04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleApp extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Circle circle = new Circle(60, Paint.valueOf("red"));
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		Scene scene = new Scene(pane, 400, 400);
		circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));
		circle.radiusProperty().bind(Bindings.createDoubleBinding(() -> {
			Double width = scene.getWidth();
			Double height = scene.getHeight();
			if (scene.getHeight() > scene.getWidth()) {
				return width / 2;
			} else {
				return height / 2;
			}
		}, scene.widthProperty(), scene.heightProperty()));
		stage.setScene(scene);
		stage.setTitle("Hello");
		stage.show();
	}

}
