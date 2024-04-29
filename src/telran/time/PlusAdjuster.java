package telran.time;

public class PlusAdjuster implements TimePointAdjuster {
	TimePoint timePoint;
	
	public PlusAdjuster(TimePoint timePoint) {
		this.timePoint = timePoint;
	}

	@Override
	public TimePoint adjust(TimePoint point) {
		TimePoint pointSec = point.convert(TimeUnit.SECOND); // то, что принимает
		TimePoint timePointSec = timePoint.convert(TimeUnit.SECOND); // то, что было сконструировано ????
		int sumSeconds = pointSec.getAmount() + timePointSec.getAmount(); 
		TimePoint resSec = new TimePoint(sumSeconds, TimeUnit.SECOND);
		return resSec.convert(point.getTimeUnit());
	}

}
