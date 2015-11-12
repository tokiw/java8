package ex10;

import java.util.Objects;

public class LabeledPoint implements Comparable<LabeledPoint> {
	private String label;
	private int x;
	private int y;

	@Override
	public int hashCode() {
		return Objects.hash(label, x, y);
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}
		if (Objects.isNull(otherObject)) {
			return false;
		}
		if (getClass() != otherObject.getClass()) {
			return false;
		}
		LabeledPoint other = (LabeledPoint) otherObject;
		
		return Objects.equals(label, other.label) && Objects.equals(x, other.x) && Objects.equals(y, other.y);
	}
	
	@Override
	public int compareTo(LabeledPoint other) {
		int diff = label.compareTo(other.label);
		if (diff != 0) {
			return diff;
		}
		diff = Integer.compare(x, other.x);
		if (diff != 0) {
			return diff;
		}
		return Integer.compare(y, other.y);
	}
}
