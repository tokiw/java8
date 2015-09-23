package ex04_08;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class DimensionContainer extends Dimension {
	public void setWidth(double width) { 
		this.setSize(width, this.getHeight());
	}
	public void setHeight(double height) {
		this.setSize(getWidth(), height);
	}
}
