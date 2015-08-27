package ex04_10;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Browser extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		String url = "http://google.com";
		HBox header = new HBox(5);
		header.setPadding(new Insets(10));
		VBox window = new VBox();
		
		Button returnButton = new Button("←");
		TextField tf = new TextField(url);
		tf.prefWidthProperty().bind(stage.widthProperty());
		header.getChildren().addAll(returnButton, tf);
		
		WebView webView = new WebView();
		window.getChildren().addAll(header, webView);
		Scene scene = new Scene(window, 800, 600);
		
		WebEngine engine = webView.getEngine();
		stage.setScene(scene);
		engine.load(url);
		stage.titleProperty().bind(engine.titleProperty());
		tf.setOnAction(e -> {
			engine.load(tf.getText());
		});

		engine.getLoadWorker().stateProperty().addListener((property, oldValue, newValue) -> {
			tf.setText(engine.getLocation());
			returnButton.setDisable(engine.getHistory().getCurrentIndex() == 0);
		});
		
		returnButton.setOnAction(e -> {
			WebHistory webHistory = engine.getHistory();
			int historyIndex = webHistory.getCurrentIndex();
			List<WebHistory.Entry> histories = webHistory.getEntries();
			
			if (historyIndex == 0) {
				returnButton.setDisable(true);
			} else if (historyIndex > 0 && historyIndex < histories.size()) {
				webHistory.go(-1);
			}
		});
		stage.show();
		
	}

}
