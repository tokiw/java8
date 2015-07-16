package ex01_10;

import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public interface List2<T> extends List<T> {
	
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		final int COPY_THRESHOLD = 10;
		
		int srcSize = src.size();
        if (srcSize > dest.size())
            throw new IndexOutOfBoundsException("Source does not fit in dest");

        if (srcSize < COPY_THRESHOLD ||
            (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            for (int i=0; i<srcSize; i++)
                dest.set(i, src.get(i));
        } else {
            ListIterator<? super T> di=dest.listIterator();
            ListIterator<? extends T> si=src.listIterator();
            for (int i=0; i<srcSize; i++) {
                di.next();
                di.set(si.next());
            }
        }
	}
	
}
