package ex04_06;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Layout extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		Button top = new Button("Top");
		Button left = new Button("Left");
		Button center = new Button("Center");
		Button right = new Button("Right");
		Button bottom = new Button("Bottom");
		pane.add(top, 1, 0);
		pane.add(left, 0, 1);
		pane.add(center, 1, 1);
		pane.add(right, 2, 1);
		pane.add(bottom, 1, 2);
		top.setMaxWidth(Double.MAX_VALUE);
		left.setMaxWidth(Double.MAX_VALUE);
		center.setMaxWidth(Double.MAX_VALUE);
		right.setMaxWidth(Double.MAX_VALUE);
		bottom.setMaxWidth(Double.MAX_VALUE);
		GridPane.setHalignment(top, HPos.CENTER);
		GridPane.setHalignment(center, HPos.CENTER);
		GridPane.setHalignment(bottom, HPos.CENTER);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
