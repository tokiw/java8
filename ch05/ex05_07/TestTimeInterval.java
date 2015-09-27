package ex05_07;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class TestTimeInterval {

	@Test
	public void test_overlap_time() {
		LocalDateTime ti1Start = LocalDateTime.of(2015, 9, 28, 9, 30);
		LocalDateTime ti1End = LocalDateTime.of(2015, 9, 28, 17, 30);
		TimeInterval ti1 = new TimeInterval(ti1Start, ti1End);
		
		LocalDateTime ti2Start = LocalDateTime.of(2015, 9, 28, 11, 30);
		LocalDateTime ti2End = LocalDateTime.of(2015, 9, 28, 12, 30);
		TimeInterval ti2 = new TimeInterval(ti2Start, ti2End);
		
		assertEquals(true, ti1.isOverlap(ti2));
	}
	
	@Test
	public void test_same_time_and_same_day() {
		LocalDateTime ti1Start = LocalDateTime.of(2015, 9, 28, 9, 30);
		LocalDateTime ti1End = LocalDateTime.of(2015, 9, 28, 17, 30);
		TimeInterval ti1 = new TimeInterval(ti1Start, ti1End);
		
		LocalDateTime ti2Start = LocalDateTime.of(2015, 9, 28, 9, 30);
		LocalDateTime ti2End = LocalDateTime.of(2015, 9, 28, 17, 30);
		TimeInterval ti2 = new TimeInterval(ti2Start, ti2End);
		
		assertEquals(true, ti1.isOverlap(ti2));
	}
	
	@Test
	public void test_no_overlap_time_different_time() {
		LocalDateTime ti1Start = LocalDateTime.of(2015, 9, 28, 9, 30);
		LocalDateTime ti1End = LocalDateTime.of(2015, 9, 28, 17, 30);
		TimeInterval ti1 = new TimeInterval(ti1Start, ti1End);
		
		LocalDateTime ti2Start = LocalDateTime.of(2015, 9, 28, 8, 30);
		LocalDateTime ti2End = LocalDateTime.of(2015, 9, 28, 9, 29);
		TimeInterval ti2 = new TimeInterval(ti2Start, ti2End);
		assertEquals(false, ti1.isOverlap(ti2));
	}
	
	@Test
	public void test_no_overlap_same_time_and_different_day() {
		LocalDateTime ti1Start = LocalDateTime.of(2015, 9, 28, 9, 30);
		LocalDateTime ti1End = LocalDateTime.of(2015, 9, 28, 17, 30);
		TimeInterval ti1 = new TimeInterval(ti1Start, ti1End);
		
		LocalDateTime ti2Start = LocalDateTime.of(2015, 9, 27, 9, 30);
		LocalDateTime ti2End = LocalDateTime.of(2015, 9, 27, 17, 29);
		TimeInterval ti2 = new TimeInterval(ti2Start, ti2End);
		
		assertEquals(false, ti1.isOverlap(ti2));
	}
}
