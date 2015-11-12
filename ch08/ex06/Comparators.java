package ex06;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Comparators {
	public static void main(String[] args) {
		Point2D point1 = new Point2D(3, 2);
		Point2D point2 = new Point2D(4, 2);
		Point2D point3 = new Point2D(5, 1);
		System.out.println(comparePoint2d().compare(point1, point2));
		System.out.println(comparePoint2d().compare(point2, point3));
	}
	
	public static Comparator<Point2D> comparePoint2d() {
		return Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY);
	}
	
	public static Comparator<Rectangle2D> compareRectangle2D() {
		return Comparator.comparing(Rectangle2D::getMinX).thenComparing(Rectangle2D::getMaxX).thenComparing(Rectangle2D::getMinY).thenComparing(Rectangle2D::getMaxY);
	}
}
