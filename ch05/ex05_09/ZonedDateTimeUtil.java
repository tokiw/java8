package ex05_09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ZonedDateTimeUtil {

	public static void main(String[] args) {
		Map<String, ZoneOffset> offsets = ZonedDateTimeUtil.getTimeZoneOffsetsAndFilter(LocalDateTime.now(), 1);
		offsets.forEach((id, offset) -> {
			System.out.println(id + ": " + offset.toString());
		});
	}
	
	/**
	 * 
	 * @param localDateTime
	 * @param diffHour
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Map<String, ZoneOffset> getTimeZoneOffsetsAndFilter(LocalDateTime localDateTime, int diffHour) throws IllegalArgumentException {
		if (diffHour <= 0) {
			throw new IllegalArgumentException();
		}
		Map<String, ZoneOffset> offsets = ZonedDateTimeUtil.getTimeZoneOffsets(localDateTime);
		return offsets.entrySet().stream()
		.filter((entry) -> {
			int offsetSeconds = entry.getValue().getTotalSeconds();
			return Math.abs(offsetSeconds) < 60 * 60 * diffHour;
		})
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}
	
	/**
	 * 
	 * @param localDateTime
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Map<String, ZoneOffset> getTimeZoneOffsets(LocalDateTime localDateTime) throws IllegalArgumentException {
		if (Objects.isNull(localDateTime)) {
			throw new IllegalArgumentException();
		}
		return ZoneId.getAvailableZoneIds().stream().collect(Collectors.toMap(
				id -> id,
				id -> ZonedDateTime.of(localDateTime, ZoneId.of(id)).getOffset()
		));
	}
}
