package ex06_09;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Matrix matrix = new Matrix(2, 2);
		matrix.setRows(0, 1, 1);
		matrix.setRows(1, 1, 0);
		
		Matrix[] arrayMatrix = new Matrix[10];
		Arrays.parallelSetAll(arrayMatrix, i -> matrix);
		Arrays.parallelPrefix(arrayMatrix, Matrix::multiply);
		Arrays.stream(arrayMatrix).forEach(m -> {
			System.out.println(m.getValue(0, 0));
		});
	}

}
