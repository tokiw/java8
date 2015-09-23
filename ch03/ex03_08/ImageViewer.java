package ex03_08;

import java.io.FileInputStream;
import java.util.Objects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ImageView imageView = new ImageView();
        Image image = new Image(new FileInputStream("ch03/ex03_05/sample.jpg"));
        imageView.setImage(image);

        VBox root = new VBox();
        
        Label widthLabel = new Label("枠の幅(整数)");
        Label colorLabel = new Label("色");
        TextField widthTf = new TextField();
        TextField colorTf = new TextField();
        Button changeButton = new Button("変更");
        changeButton.setOnAction(event -> {
        	if (widthTf.getText().isEmpty() || colorTf.getText().isEmpty()) {
        		createErrorDialog("枠の幅と色を正しく入力してください。");
        		return;
        	}
        	int width;
        	Color color;
        	try {
	        	width = Integer.valueOf(widthTf.getText());
	        	color = Color.valueOf(colorTf.getText());
        	} catch (NumberFormatException e) {
        		createErrorDialog("枠の幅と色を正しく入力してください。");
        		return;
        	}
        	
        	if (Double.valueOf(width) < 0) {
        		return;
        	}
        	
        	Image tranformedImage = transform(imageView.getImage(), ( x, y, c ) -> {
        		if (x < width || y < width || (image.getWidth() - x) < width || (image.getHeight() - y) < width) {
        			return color;
        		}
        		return c;
        	});
        	imageView.setImage(tranformedImage);
        	primaryStage.show();
        });
        GridPane header = new GridPane();
        header.add(widthLabel, 0, 0);
        header.add(widthTf, 1, 0);
        header.add(colorLabel, 0, 1);
        header.add(colorTf, 1, 1);
        header.add(changeButton, 0, 2, 2, 1);
        changeButton.setMaxWidth(Double.MAX_VALUE);
        header.setHgap(10);
        header.setVgap(2);
        header.setPadding(new Insets(5));
        root.getChildren().addAll(header, imageView);
        Scene scene = new Scene(root, image.getWidth(), image.getHeight() + 100);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	private void createErrorDialog(String message) {
		if (Objects.isNull(message)) {
			return;
		}
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		
		alert.showAndWait();
	}
}
