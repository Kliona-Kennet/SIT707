package web.service;

public class MathQuestionService {

	public static Double q1Addition(String number1, String number2) {
		try {
			if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
				return null;
			}
			return Double.valueOf(number1) + Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static Double q2Subtraction(String number1, String number2) {
		try {
			if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
				return null;
			}
			return Double.valueOf(number1) - Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static Double q3Multiplication(String number1, String number2) {
		try {
			if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
				return null;
			}
			return Double.valueOf(number1) * Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}