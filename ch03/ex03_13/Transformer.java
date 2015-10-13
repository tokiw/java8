package ex03_13;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

public class Transformer {
	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
		return (x, y, c) -> f1.apply(x, y, f2.apply(x, y, c));
	}
	
	public static ColorTransformer colorTransformerBuilder(UnaryOperator<Color> op) {
		return (x, y, c) -> op.apply(c);
	}
}
