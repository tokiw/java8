package ex04_08;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFrameContainer extends JFrame {
	
	private List<Component> children = new ArrayList<Component>();
	
	public List<Component> getChildren() {
		return children;
	}
	
	@Override
	public void doLayout() {
        Container container = getContentPane();
        children.forEach(container::add);
        super.doLayout();
	}
}
