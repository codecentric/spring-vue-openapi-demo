package de.codecentric.vue.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	
	@GetMapping("/hello/")
	public String helloController() {
		return "Hello world!";
	}
}
