package telran.time;

public enum TimeUnit {
HOUR(3600), MINUTE(60), SECOND(1);
	int value;
	private TimeUnit(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public TimePoint between(TimePoint point1, TimePoint point2) {
		//TODO
		int amountBetween = point2.convert(this).amount - point1.convert(this).amount;
		return new TimePoint(amountBetween, this);
	}

}
