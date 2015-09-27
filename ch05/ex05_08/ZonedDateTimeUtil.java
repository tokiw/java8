package ex05_08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.stream.Collectors;

public class ZonedDateTimeUtil {

	public static void main(String[] args) {
		Map<String, ZoneOffset> offsets = ZonedDateTimeUtil.getTimeZoneOffsets(LocalDateTime.now());
		offsets.forEach((id, offset) -> {
			System.out.println(id + ": " + offset.toString());
		});
	}
	
	public static Map<String, ZoneOffset> getTimeZoneOffsets(LocalDateTime localDateTime) {
		return ZoneId.getAvailableZoneIds().stream().collect(Collectors.toMap(
				id -> id,
				id -> ZonedDateTime.of(localDateTime, ZoneId.of(id)).getOffset()
		));
	}
}
