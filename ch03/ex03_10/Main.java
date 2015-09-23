package ex03_10;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {
	public static void main(String[] args) {
		Image image = new Image("ch03/ex03_05/sample.jpg");
		UnaryOperator<Color> op = Color::brighter;
		Image finalImage = Main.transform(image, op.compose(Color::grayscale));
	}
	
	public static Image transform(Image in, Function<Color, Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		
		return out;
	}
}
