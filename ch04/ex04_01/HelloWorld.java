package ex04_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		String defaultMessage = "Hello FX!";
		TextField text = new TextField(defaultMessage);
		Label message = new Label(defaultMessage);
		message.setFont(new Font(100));
		message.textProperty().bind(text.textProperty());
		VBox vbox = new VBox(text, message);
		stage.setScene(new Scene(vbox));
		stage.setTitle("Hello");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
