package ex03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class MultiException {
	private int val = 1;
	public static void main(String[] args) {
		try {
			new MultiException().process();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void process() throws FileNotFoundException, UnknownHostException {
		try {
			if (val == 0) {
				throw new FileNotFoundException();
			} else {
				throw new UnknownHostException();
			}
		} catch (FileNotFoundException | UnknownHostException ex) {
			throw ex;
		}
	}
}
