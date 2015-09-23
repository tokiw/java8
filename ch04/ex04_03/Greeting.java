package ex04_03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
	private String defaultText = "Hello";
	private StringProperty textProperty = null;

	public Greeting(String defaultText) {
		this.defaultText = defaultText;
	}
	
	public final synchronized StringProperty textProperty() {
		if (textProperty != null) {
			return textProperty;			
		} else {
			return new SimpleStringProperty(defaultText);
		}
	}
	
	public final synchronized void setText(String newText) {
		if (textProperty != null) {
			this.textProperty.set(newText);
		} else if (defaultText != newText) {
			this.textProperty = new SimpleStringProperty(newText);
		}
	}
	
	public final String getText() {
		return this.textProperty != null ? textProperty.get() : defaultText;
	}
}