package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("/usr/share/dict/words"));
			out = new PrintWriter("/tmp/out.txt");
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} finally {
			if (Objects.nonNull(in)) {
				in.close();
			}
			if (Objects.nonNull(out)) {
				out.close();
			}
		}
	}
}
