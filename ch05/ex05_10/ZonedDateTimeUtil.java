package ex05_10;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeUtil {
	
	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTimeUtil.getArrivalTime(ZonedDateTime.of(2015, 9, 28, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles")), ZoneId.of("CET"), 10, 50);
		System.out.println("到着時刻: " + zonedDateTime.toString());
	}
	
	public static ZonedDateTime getArrivalTime(ZonedDateTime zonedDateTime, ZoneId zoneId, int hour, int minute) {
		return zonedDateTime.plusHours(hour).plusMinutes(minute).withZoneSameInstant(zoneId);
	}
}
