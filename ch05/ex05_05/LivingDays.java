package ex05_05;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LivingDays extends Application {
	private final Label errorLabel = new Label();
	
	@SuppressWarnings("serial")
	private final Map<String, JapaneseEra> eraMap = new HashMap<String, JapaneseEra>() {
		{
			put("明治", JapaneseEra.MEIJI);
			put("大正", JapaneseEra.TAISHO);
			put("昭和", JapaneseEra.SHOWA);
			put("平成", JapaneseEra.HEISEI);
		}
	};
	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		Label titleLabel = new Label("生年月日を入力してください");
		ChoiceBox<String> era = new ChoiceBox<String>(FXCollections.observableArrayList("明治", "大正", "昭和", "平成"));
		TextField yearField = new TextField();
		yearField.setMaxWidth(50);
		Label yearLabel = new Label("年");
		TextField monthField = new TextField();
		monthField.setMaxWidth(50);
		Label monthLabel = new Label("月");
		TextField dayField = new TextField();
		dayField.setMaxWidth(50);
		Label dayLabel = new Label("日");
		Button button = new Button("計算");
		Label livingDaysTitleLabel = new Label("生まれてから");
		TextField livingDaysField = new TextField();
		Label livingDaysLabel = new Label("日");
		livingDaysField.setEditable(false);
		livingDaysField.setMaxWidth(50);
		errorLabel.setTextFill(Color.RED);
		button.setOnAction(e -> {
			try {
				errorLabel.setText("");
				long livingDays = this.calLivingDays(era.getValue(), Integer.valueOf(yearField.getText()), Integer.valueOf(monthField.getText()), Integer.valueOf(dayField.getText()));
				if (livingDays < 0) {
					return;
				}
				livingDaysField.setText(String.valueOf(livingDays));
			} catch(NumberFormatException | NullPointerException error ) {
				this.showErrorMsg();
			}
		});
		button.setMaxWidth(Double.MAX_VALUE);
		pane.add(titleLabel, 0, 0, 3, 1);
		pane.add(era, 0, 1);
		pane.add(yearField, 1, 1);
		pane.add(yearLabel, 2, 1);
		pane.add(monthField, 1, 2);
		pane.add(monthLabel, 2, 2);
		pane.add(dayField, 1, 3);
		pane.add(dayLabel, 2, 3);
		pane.add(button, 0, 4, 3, 1);
		pane.add(livingDaysTitleLabel, 0, 5);
		pane.add(livingDaysField, 1, 5);
		pane.add(livingDaysLabel, 2, 5);
		pane.add(errorLabel, 0, 6, 3, 1);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	private void showErrorMsg() {
		errorLabel.setText("入力が不正です。");
	}
	
	private long calLivingDays(String era, int year, int month, int day) {
		try {
			JapaneseDate japaneseDate = JapaneseDate.of(eraMap.get(era), year, month, day);
			return japaneseDate.until(LocalDate.now(), ChronoUnit.DAYS);
		} catch (DateTimeException e) {
			this.showErrorMsg();
			return -1;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
