package ex03;

public class Gcd {
	
	private static int rem(int a, int b) {
		return Integer.remainderUnsigned(a, b);
	}
	
	public static int gcdRem(int a, int b) {
		int valA = Math.abs(a);
		int valB = Math.abs(b);
		
		if (valA < valB) {
			valA = Math.abs(b);
			valB = Math.abs(a);
		}
		if (valB == 0) {
			return a;
		}
		int newA = rem(valA, valB);
		
		return gcdRem(valB, newA);
	}

	public static int gcdFloorMod(int a, int b) {
		int valA = Math.abs(a);
		int valB = Math.abs(b);
		
		if (valA < valB) {
			valA = Math.abs(b);
			valB = Math.abs(a);
		}
		if (valB == 0) {
			return a;
		}
		int newA = Math.floorMod(valA, valB);
		
		return gcdFloorMod(valB, newA);
	}
	
	public static int gcdPercent(int a, int b) {
		int valA = Math.abs(a);
		int valB = Math.abs(b);
		
		if (valA < valB) {
			valA = Math.abs(b);
			valB = Math.abs(a);
		}
		if (valB == 0) {
			return a;
		}
		int newA = valA % valB;
		
		return gcdPercent(valB, newA);
	}
	
	public static void main(String[] args) {
		System.out.println(gcdRem(28, 8));
		System.out.println(gcdPercent(28, 8));
		System.out.println(gcdFloorMod(28, 8));
	}
}
