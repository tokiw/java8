package ex05_10;

import static org.junit.Assert.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class TestZonedDateTime {

	@Test
	public void test() {
		ZonedDateTime zonedDateTime = ZonedDateTimeUtil.getArrivalTime(ZonedDateTime.of(2015, 9, 28, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles")), ZoneId.of("CET"), 10, 50);
		int diffSeconds = ZonedDateTime.now(ZoneId.of("CET")).getOffset().getTotalSeconds() - ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).getOffset().getTotalSeconds();
		assertEquals(true, zonedDateTime.isEqual(ZonedDateTime.of(2015, 9, 28, 3+diffSeconds/3600, 5, 0, 0, ZoneId.of("CET")).plusHours(10).plusMinutes(50)));
	}

}
