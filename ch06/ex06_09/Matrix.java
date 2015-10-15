package ex06_09;

public class Matrix {
	Integer[][] data;
	
	public Matrix( int row, int column ) {
		data = new Integer[row][column];
	}
	
	public void setRows( int row, Integer... values ) {
		for ( int i = 0; i < values.length; i++) {
			data[row][i] = values[i];
		}
	}
	
	public void setValue(int row, int column, Integer value) {
		data[row][column] = value;
	}
	
	public Integer getValue(int row, int column) {
		return data[row][column];
	}
	
	public Matrix multiply(Matrix other) {
		int rowSize = data.length;
		int columnSize = data[0].length;
		Matrix result = new Matrix(rowSize, columnSize);
		for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                result.data[row][column] = 0;
                for (int i = 0; i < rowSize; i++) {
                    result.data[row][column] += data[row][i] * other.data[i][column];
                }
            }
        }
        return result;
	}
}
