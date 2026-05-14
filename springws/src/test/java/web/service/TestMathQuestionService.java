package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testQ1AdditionCorrect() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
	}

	@Test
	public void testQ1AdditionEmptyValue() {
		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
	}

	@Test
	public void testQ1AdditionInvalidValue() {
		Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
	}

	@Test
	public void testQ2SubtractionCorrect() {
		Assert.assertEquals(5.0, MathQuestionService.q2Subtraction("10", "5"), 0);
	}

	@Test
	public void testQ2SubtractionEmptyValue() {
		Assert.assertNull(MathQuestionService.q2Subtraction("", "5"));
	}

	@Test
	public void testQ2SubtractionInvalidValue() {
		Assert.assertNull(MathQuestionService.q2Subtraction("ten", "5"));
	}

	@Test
	public void testQ3MultiplicationCorrect() {
		Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0);
	}

	@Test
	public void testQ3MultiplicationEmptyValue() {
		Assert.assertNull(MathQuestionService.q3Multiplication("", "4"));
	}

	@Test
	public void testQ3MultiplicationInvalidValue() {
		Assert.assertNull(MathQuestionService.q3Multiplication("abc", "4"));
	}
}