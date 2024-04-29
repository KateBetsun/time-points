package telran.time;

public class TimePoint implements Comparable<TimePoint>{
	// кол-во единиц времени
	int amount;
	TimeUnit timeUnit;
	public TimePoint(int amount, TimeUnit timeUnit) {
		super();
		this.amount = amount;
		this.timeUnit = timeUnit;
	}
		public int getAmount() {
		return amount;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public TimePoint convert(TimeUnit second) {
		//returns new TimePoint with a given TimeUnit
		int amountConvert = switch(this.timeUnit) {
		case HOUR -> this.amount * TimeUnit.HOUR.value;
		case MINUTE -> this.amount * TimeUnit.MINUTE.value;
		default -> this.amount;
		};
		return new TimePoint(amountConvert/second.value, second);
	}
	public TimePoint with(TimePointAdjuster adjuster) {
		//return new TimePoint based on any TimePointAdjuster
		return adjuster.adjust(this);
	}
	@Override
	public int compareTo(TimePoint o) {
		return o.amount - this.amount;
	}
	@Override
	// 2 часа = 120 мин
	public boolean equals(Object obj) {
//		if(this == obj) {
//			return true;
//		}
//		if(obj == null || getClass() != obj.getClass()) {
			return false;
//		}
//		TimePoint other = (TimePoint) obj;
//		TimePoint thisInHours = this.convert(TimeUnit.HOUR);
//		TimePoint otherInHours = other.convert(TimeUnit.HOUR);
//		TimePoint thisInMinutes = this.convert(TimeUnit.MINUTE);
//		TimePoint otherInMinutes = other.convert(TimeUnit.MINUTE);
//		TimePoint thisInSeconds = this.convert(TimeUnit.SECOND);
//		TimePoint otherInSeconds = other.convert(TimeUnit.SECOND);
//		return thisInHours.getAmount() == otherInHours.getAmount() &&
//				thisInMinutes.getAmount() == otherInMinutes.getAmount() &&
//				thisInSeconds.getAmount() == otherInSeconds.getAmount();
	}
}
