package ex01;

/**
 * divideUnsigned: unsignedとsignedの除算では通常の算術型変換によってsignedはunsignedに変換され期待した値にならない。商をsignedを渡して期待した結果を取得するため
 * remainderUnsigned: divideUnsignedと同様
 */
public class UnsignedInt {
	private int value;
	
	public UnsignedInt(int val) {
		this.value = val;
	}
	
	public long add(int val) {
		return Integer.toUnsignedLong(this.value) + Integer.toUnsignedLong(val);
	}
	
	public long subtract(int val) {
		return Integer.toUnsignedLong(this.value) - Integer.toUnsignedLong(val);
	}
	
	public int divide(int val) {
		return Integer.divideUnsigned(this.value, val);
	}
	
	public int compareTo(int val) {
		return Long.compare(Integer.toUnsignedLong(this.value), val);
	}
	
	public long getUnsignedValue() {
		return Integer.toUnsignedLong(this.value);
	}
	
	public static void main(String[] args) {
		UnsignedInt val = new UnsignedInt(100);
		System.out.println(val.getUnsignedValue());
		System.out.println(val.divide(10));
	}
}
