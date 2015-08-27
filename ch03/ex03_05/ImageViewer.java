package ex03_05;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		
		return out;
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
        brighterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
        	Image tranformedImage = transform(imageView.getImage(), ( x, y, color ) -> {
        		if (x < 10 || y < 10 || (image.getWidth() - x) < 10 || (image.getHeight() - y) < 10) {
        			return Color.GRAY;
        		}
        		return color;
        	});
        	imageView.setImage(tranformedImage);
        	primaryStage.show();
        });
        BorderPane bp = new BorderPane(brighterButton);
        root.getChildren().add(bp);
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, image.getWidth(), image.getHeight() + 100);
        System.out.println(scene.getHeight());
        System.out.println(image.getHeight());

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
