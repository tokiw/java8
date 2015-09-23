package ex04_08;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {
	@FXML JFrameContainer frame;  
	
	@FXML JPanelContainer panel;
	
	public static void main(String[] args) {
		new LoginController().show();
	}
	
	public void show() {
		URL fxml = getClass().getResource("login.fxml");
		if (fxml == null) {
			System.out.println("not found");
			return;
		}
		try {
			FXMLLoader.load(fxml);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
