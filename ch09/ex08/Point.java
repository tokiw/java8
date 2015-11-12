package ex08;

public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point other) {
		if (x < other.x) {
			return -1;
		} else if (x > other.x) {
			return 1;
		}
		if (y < other.y) {
			return -1;
		} else if (y > other.y) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Point point1 = new Point(1, 1);
		Point point2 = new Point(1, 2);
		System.out.println(point1.compareTo(point2));
		Point point3 = new Point(1, 1);
		System.out.println(point1.compareTo(point3));
		Point point4 = new Point(0, 1);
		System.out.println(point1.compareTo(point4));
	}
}
