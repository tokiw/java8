package ex04_05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		String defaultMessage = "Hello FX!";
		TextField text = new TextField(defaultMessage);
		Label message = new Label(defaultMessage);
		Button button = new Button("表示");
		message.setFont(new Font(100));
		button.setOnAction((e) -> message.textProperty().setValue(text.getText()));
		button.disableProperty().bind(Observer.observe(t -> t.length() > 10, text.textProperty()));
		HBox hbox = new HBox(text, button);
		VBox vbox = new VBox(hbox, message);
		stage.setScene(new Scene(vbox));
		stage.setTitle("Hello");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
