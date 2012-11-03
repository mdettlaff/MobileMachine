package mdettlaff.mobilemachine.controller;

import java.io.IOException;

import mdettlaff.mobilemachine.service.PageSimplifierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private final PageSimplifierService service;

	@Autowired
	public HomeController(PageSimplifierService service) {
		this.service = service;
	}

	@RequestMapping
	public String home() {
		return "index";
	}

	@RequestMapping("/simplified")
	public ModelAndView simplified(@RequestParam String url, @RequestParam int page) throws IOException {
		String html = service.simplify(url, page);
		return new ModelAndView("simplified", "html", html);
	}
}
