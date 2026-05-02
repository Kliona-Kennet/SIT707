package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopUtilsTest {

	@Test
	public void testSumNumbersWithLoop() {
		Assert.assertEquals(15, LoopUtils.sumNumbers(5));
	}

	@Test
	public void testSumNumbersNoLoop() {
		Assert.assertEquals(0, LoopUtils.sumNumbers(0));
	}

	@Test
	public void testCountEvenNumbersWithCondition() {
		Assert.assertEquals(3, LoopUtils.countEvenNumbers(6));
	}

	@Test
	public void testCountEvenNumbersNoLoop() {
		Assert.assertEquals(0, LoopUtils.countEvenNumbers(0));
	}
}