package ex02;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	private static Throwable exception = null;
	
	public static void main(String[] args) {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("/usr/share/dict/words/aaaaa"));
			out = new PrintWriter("/tmp/out.txt");
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (IOException ex) {
			exception = ex;
		} finally {
			fileClose(in);
			fileClose(out);
		}
	}
	
	public static void fileClose(Closeable file) {
		try {
			if (Objects.nonNull(file)) {
				file.close();
			}
			throw new Exception();
		} catch (Throwable ex) {
			if (Objects.nonNull(exception)) {
				exception.addSuppressed(ex);
			}
		}
	}
}
