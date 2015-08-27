package ex03_06;

import java.io.FileInputStream;
import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageViewer extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@FunctionalInterface
	public interface ColorTransformer {
		public Color apply(int x, int y, Color color);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ImageView imageView = new ImageView();
        Image image = new Image(new FileInputStream("/Users/masafumi/Downloads/sample.jpg"));
        imageView.setImage(image);

        FlowPane root = new FlowPane();
        Button brighterButton = new Button("transform");
        TextField tf = new TextField();
        brighterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
        	double factorValue;
        	if (tf.getText().isEmpty()) {
        		factorValue = 1;
        	} else {
        		factorValue = Double.valueOf(tf.getText());
        	}
        	
        	Image tranformedImage = transform(imageView.getImage(), (c, factor) -> c.deriveColor(0, 1, factor, 1), factorValue);
        	imageView.setImage(tranformedImage);
        	primaryStage.show();
        });
        BorderPane bp = new BorderPane();
        bp.setLeft(tf);
        bp.setRight(brighterButton);
        root.getChildren().add(bp);
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, image.getWidth(), image.getHeight() + 100);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
}
