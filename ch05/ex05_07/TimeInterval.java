package ex05_07;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeInterval {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @throws IllegalArgumentException
	 */
	public TimeInterval(LocalDateTime startTime, LocalDateTime endTime) throws IllegalArgumentException {
		if (Objects.isNull(startTime) || Objects.isNull(endTime)) {
			throw new IllegalArgumentException();
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * 
	 * @return startTime
	 */
	public LocalDateTime getStart() {
		return startTime;
	}
	
	/**
	 * 
	 * @return endTime
	 */
	public LocalDateTime getEnd() {
		return endTime;
	}
	
	/**
	 * 
	 * @param startTime
	 * @throws IllegalArgumentException
	 */
	public void setStart(LocalDateTime startTime) throws IllegalArgumentException {
		if (Objects.isNull(startTime)) {
			throw new IllegalArgumentException();
		}
		this.startTime = startTime;
	}
	
	/**
	 * 
	 * @param endTime
	 * @throws IllegalArgumentException
	 */
	public void setEnd(LocalDateTime endTime) throws IllegalArgumentException {
		if (Objects.isNull(endTime)) {
			throw new IllegalArgumentException();
		}
		this.endTime = endTime;
	}
	
	public boolean isOverlap(TimeInterval timeInterval) {
		return this.startTime.isBefore(timeInterval.getEnd()) && this.endTime.isAfter(timeInterval.getStart());
	}
}
