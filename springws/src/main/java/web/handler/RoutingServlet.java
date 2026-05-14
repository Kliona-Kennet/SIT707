package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
public class RoutingServlet {

	@GetMapping("/")
	public RedirectView welcome() {
		System.out.println("Welcome page...");
		return new RedirectView("/login", true);
	}

	@GetMapping("/login")
	public String loginView() {
		System.out.println("Login view...");
		return "view-login";
	}

	@PostMapping("/login")
	public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("Login form submitted...");

		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");

		boolean loginResult = LoginService.login(username, password, dob);

		if (loginResult) {
			return new RedirectView("/q1", true);
		} else {
			redirectAttributes.addFlashAttribute("message", "Incorrect login details. Please try again.");
			return new RedirectView("/login", true);
		}
	}

	@GetMapping("/q1")
	public String q1View() {
		System.out.println("Question 1 view...");
		return "view-q1";
	}

	@PostMapping("/q1")
	public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("Question 1 form submitted...");

		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");

		Double calculatedResult = MathQuestionService.q1Addition(number1, number2);

		if (calculatedResult == null || resultUser == null || resultUser.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please enter valid numbers.");
			return new RedirectView("/q1", true);
		}

		try {
			if (calculatedResult.equals(Double.valueOf(resultUser))) {
				return new RedirectView("/q2", true);
			} else {
				redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
				return new RedirectView("/q1", true);
			}
		} catch (NumberFormatException e) {
			redirectAttributes.addFlashAttribute("message", "Please enter a valid answer.");
			return new RedirectView("/q1", true);
		}
	}

	@GetMapping("/q2")
	public String q2View() {
		System.out.println("Question 2 view...");
		return "view-q2";
	}

	@PostMapping("/q2")
	public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("Question 2 form submitted...");

		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");

		Double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);

		if (calculatedResult == null || resultUser == null || resultUser.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please enter valid numbers.");
			return new RedirectView("/q2", true);
		}

		try {
			if (calculatedResult.equals(Double.valueOf(resultUser))) {
				return new RedirectView("/q3", true);
			} else {
				redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
				return new RedirectView("/q2", true);
			}
		} catch (NumberFormatException e) {
			redirectAttributes.addFlashAttribute("message", "Please enter a valid answer.");
			return new RedirectView("/q2", true);
		}
	}

	@GetMapping("/q3")
	public String q3View() {
		System.out.println("Question 3 view...");
		return "view-q3";
	}

	@PostMapping("/q3")
	public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("Question 3 form submitted...");

		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");

		Double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);

		if (calculatedResult == null || resultUser == null || resultUser.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please enter valid numbers.");
			return new RedirectView("/q3", true);
		}

		try {
			if (calculatedResult.equals(Double.valueOf(resultUser))) {
				redirectAttributes.addFlashAttribute("message", "Congratulations! You completed the STEM game.");
				return new RedirectView("/q3", true);
			} else {
				redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
				return new RedirectView("/q3", true);
			}
		} catch (NumberFormatException e) {
			redirectAttributes.addFlashAttribute("message", "Please enter a valid answer.");
			return new RedirectView("/q3", true);
		}
	}
}