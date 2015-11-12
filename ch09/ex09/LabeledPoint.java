package ex09;

import java.util.Objects;

public class LabeledPoint {
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
}
