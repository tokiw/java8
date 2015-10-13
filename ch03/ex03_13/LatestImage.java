package ex03_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatestImage {
	private Image in;
	private List<UnaryOperator<Color>> pendingOperations;
	
	protected LatestImage(Image in) throws NullPointerException {
		Objects.requireNonNull(in);
		this.in = in;
		pendingOperations = new ArrayList<>();
	}
	
	public static LatestImage from(Image in) {
		return new LatestImage(in);
	}
	
	LatestImage transform(UnaryOperator<Color> f) {
		pendingOperations.add(f);
		return this;
	}
	
	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (UnaryOperator<Color> f : pendingOperations) {
					c = f.apply(c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
	
	public Image getImage() {
		return in;
	}
}
