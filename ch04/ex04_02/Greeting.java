package ex04_02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
	private String text = "";
	private StringProperty textProperty = null;

	public final synchronized StringProperty textProperty() {
		if (textProperty != null) {
			return textProperty;			
		} else {
			return new SimpleStringProperty(text);
		}
	}
	
	public final synchronized void setText(String newText) {
		if (textProperty != null) {
			this.textProperty.set(newText);
		} else {
			this.text = newText;			
		}
	}
	
	public final String getText() {
		return this.textProperty != null ? textProperty.get() : text ;
	}
}