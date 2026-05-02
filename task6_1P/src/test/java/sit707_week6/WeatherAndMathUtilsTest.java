package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s224954623";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Kliona Kennet";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testEvenNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}
	
	@Test
	public void testOddNumberIsNotEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}
	
	@Test
	public void testCancelWeatherAdviceByWindSpeed() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}
	
	@Test
	public void testCancelWeatherAdviceByRainfall() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
	}
	
	@Test
	public void testCancelWeatherAdviceByBothConcernConditions() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
	}
	
	@Test
	public void testWarnWeatherAdviceByWindSpeed() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 0.0));
	}
	
	@Test
	public void testWarnWeatherAdviceByRainfall() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 4.1));
	}
	
	@Test
	public void testAllClearWeatherAdvice() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
	}

	@Test
	public void testAllClearBoundary() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeWindSpeed() {
		WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeRainfall() {
		WeatherAndMathUtils.weatherAdvice(2.0, -1.0);
	}
	
	@Test
	public void testPrimeForOne() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
	}
	
	@Test
	public void testPrimeForTwo() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
	}

	@Test
	public void testPrimeForOddNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}
	
	@Test
	public void testPrimeForEvenNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
	}
}