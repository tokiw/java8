package ex04_09;

import java.io.FileInputStream;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Planet extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		final double radiusX = 350;
		final double radiusY = 250;
		final double margin = 50;
		Sphere earth = new Sphere(40);
		Sphere sun = new Sphere(70);
		PhongMaterial materialEarth = new PhongMaterial();
		PhongMaterial materialSun = new PhongMaterial();
		Image image = new Image(new FileInputStream("ch04/ex04_09/earth.jpg"));
		materialEarth.setDiffuseMap(image);
		earth.setMaterial(materialEarth);
		materialSun.setDiffuseColor(Color.ORANGERED);
		sun.setMaterial(materialSun);
		Ellipse orbit = new Ellipse(radiusX, radiusY);
		orbit.setStroke(Color.LIGHTGRAY);
		orbit.setFill(null);
		orbit.setCenterX(radiusX+margin);
		orbit.setCenterY(radiusY+margin);
		sun.setLayoutX(radiusX+margin);
		sun.setLayoutY(radiusY+margin);
		Group group = new Group(orbit, earth, sun);
		Scene scene = new Scene(group, 2*(radiusX+margin), 2*(radiusY+margin));
		
		PathTransition pt = new PathTransition(Duration.seconds(10), orbit, earth);
		RotateTransition rt = new RotateTransition(Duration.seconds(10), earth);
		rt.setAxis(Rotate.Y_AXIS);
		rt.setByAngle(360);
		stage.setScene(scene);
		stage.show();
		pt.setCycleCount(Timeline.INDEFINITE);
		rt.setCycleCount(Timeline.INDEFINITE);
		pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.setDelay(Duration.ZERO);
		pt.play();
		rt.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
