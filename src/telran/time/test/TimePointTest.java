package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.time.*;

class TimePointTest {

	@Test
	void testBetween() {
		TimePoint point1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point2 = new TimePoint(3600*20, TimeUnit.SECOND);
		TimePoint point3 = TimeUnit.MINUTE.between(point1, point2);
		assertEquals(600, point3.getAmount());
		TimePoint point4 = TimeUnit.SECOND.between(point1, point2);
		assertEquals(600*60, point4.getAmount());
		TimePoint point5 = TimeUnit.HOUR.between(point1, point2);
		assertEquals(10, point5.getAmount());
	}
	@Test
	void convertTest() {
		TimePoint timePoint = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point1Actual = timePoint.convert(TimeUnit.SECOND);
		assertEquals(36000, point1Actual.getAmount());
		TimePoint point1Actual2 = timePoint.convert(TimeUnit.MINUTE);
		assertEquals(600, point1Actual2.getAmount());
	}
	@Test
	void plusAdjusterTest() {
		TimePoint timePoint1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint actual = timePoint2.with(new PlusAdjuster(timePoint1)); // в ед.времени по timePoint2
		assertEquals(11*60, actual.getAmount());
		assertEquals(TimeUnit.MINUTE, actual.getTimeUnit());
	}
	@Test
	void timePointEqualsTest() {
//		TimePoint timePoint1 = new TimePoint(1, TimeUnit.HOUR);
//	    TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
//	    TimePoint timePoint3 = new TimePoint(2, TimeUnit.MINUTE);
//	    TimePoint timePoint4 = new TimePoint(2*60, TimeUnit.SECOND);
//		assertTrue(timePoint1.equals(timePoint2));
//		assertTrue(timePoint3.equals(timePoint4));
//		assertFalse(timePoint1.equals(timePoint4));
	}
	@Test
	void timePointCompareToTest() {
		TimePoint timePoint1 = new TimePoint(60, TimeUnit.MINUTE);
	    TimePoint timePoint2 = new TimePoint(90, TimeUnit.MINUTE);
	    assertEquals(30, timePoint1.compareTo(timePoint2));
	}
	@Test
	void futureProximityAdjustTest() {		
		TimePoint tp1 = new TimePoint(60, TimeUnit.MINUTE);
        TimePoint tp2=  new TimePoint(90, TimeUnit.MINUTE);
        TimePoint tp3 = new TimePoint(2, TimeUnit.HOUR);
        TimePoint tp4 = new TimePoint(4, TimeUnit.HOUR);
        
        TimePoint[] timePoints = {tp1, tp2, tp3, tp4};
        TimePoint timePointNew2=  new TimePoint(90, TimeUnit.MINUTE);
        TimePointAdjuster adjuster2 = new FutureProximityAdjuster(timePoints);
        TimePoint actual = timePointNew2.with(adjuster2);
        
        assertEquals(120, actual.getAmount());
        assertEquals(TimeUnit.MINUTE, actual.getTimeUnit());
	}
}
