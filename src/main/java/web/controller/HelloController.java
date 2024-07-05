package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private final CarService carService;


	@Autowired
	public HelloController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Congratulations!");
		messages.add("You just launched a Spring MVC application :)");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/cars")
	public String showCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count, Model model) {
		model.addAttribute("cars", carService.getCars(count));
		return "cars";
	}


	
}