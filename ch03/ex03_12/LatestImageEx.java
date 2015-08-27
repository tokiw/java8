package ex03_12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatestImageEx extends LatestImage {
	private List<ColorTransformer> pendingOperations;
	
	private LatestImageEx(Image in) throws NullPointerException {
		super(in);
		pendingOperations = new ArrayList<>();
	}
	
	public static LatestImageEx from(Image in) {
		return new LatestImageEx(in);
	}
	
	@Override
	LatestImageEx transform(UnaryOperator<Color> f) {
		pendingOperations.add(Transformer.colorTransformerBuilder(f));
		return this;
	}
	
	LatestImageEx transform(ColorTransformer f) {
		pendingOperations.add(f);
		return this;
	}
	
	@Override
	public Image toImage() {
		Image in = getImage();
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (ColorTransformer f : pendingOperations) {
					c = f.apply(x, y, c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
}
