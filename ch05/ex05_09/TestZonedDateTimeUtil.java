package ex05_09;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

import org.junit.Test;

public class TestZonedDateTimeUtil {

	@Test
	public void test_diff_offset_1_hour() {
		Map<String, ZoneOffset> offsets = ZonedDateTimeUtil.getTimeZoneOffsetsAndFilter(LocalDateTime.now(), 1);
		offsets.values().forEach((offset) -> {
			assertEquals(true, Math.abs(offset.getTotalSeconds()) < 60 * 60 * 1);
		});
	}

	@Test
	public void test_diff_offset_2_hour() {
		Map<String, ZoneOffset> offsets = ZonedDateTimeUtil.getTimeZoneOffsetsAndFilter(LocalDateTime.now(), 2);
		offsets.values().forEach((offset) -> {
			assertEquals(true, Math.abs(offset.getTotalSeconds()) < 60 * 60 * 2);
		});
	}
}
