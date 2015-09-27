package ex05_11;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeUtil {
	
	public static void main(String[] args) {
		ZonedDateTime from = ZonedDateTime.of(2015, 9, 28, 14, 5, 0, 0, ZoneId.of("CET"));
		ZonedDateTime to = ZonedDateTime.of(2015, 9, 28, 16, 40, 0, 0, ZoneId.of("America/Los_Angeles"));
		Duration duration = ZonedDateTimeUtil.getTravelTime(from, to);
		System.out.println("飛行時間: " + duration.toHours() + "時間" + duration.toMinutes() / 60 + "分");
	}
	
	public static Duration getTravelTime(ZonedDateTime fromZonedDateTime, ZonedDateTime toZonedDateTime) {
		fromZonedDateTime = fromZonedDateTime.withZoneSameInstant(toZonedDateTime.getZone());
		return Duration.between(fromZonedDateTime, toZonedDateTime);
	}
	
	public static ZonedDateTime getArrivalTime(ZonedDateTime zonedDateTime, ZoneId zoneId, int hour, int minute) {
		return zonedDateTime.plusHours(hour).plusMinutes(minute).withZoneSameInstant(zoneId);
	}
}
