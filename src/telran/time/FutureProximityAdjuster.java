package telran.time;

import telran.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster{
	TimePoint[] timePointsSorted;
	public FutureProximityAdjuster(TimePoint[] points) {
		this.timePointsSorted = Arrays.copy(points);
	}
	@Override
	public TimePoint adjust(TimePoint point) {
	    int index = timePointsSorted.length;
	    for (int i = 0; i < timePointsSorted.length; i++) {	
	    	TimePoint current = timePointsSorted[i].convert(point.getTimeUnit());
	        if (current.compareTo(point) < 0) {
	            index = i;
	            break;
	        }
	    }
	    if (index == timePointsSorted.length) {
	        return null;
	    } 
	    return timePointsSorted[index].convert(point.getTimeUnit());
	}   

}
