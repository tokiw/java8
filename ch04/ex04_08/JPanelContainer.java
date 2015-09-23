package ex04_08;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelContainer extends JPanel {
	
	private List<Component> children = new ArrayList<Component>();
	
	public List<Component> getChildren() {
		return children;
	}
	
	@Override
	public void doLayout() {
		children.forEach(this::add);
		super.doLayout();
	}
}
