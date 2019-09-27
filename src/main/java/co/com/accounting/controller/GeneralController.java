package co.com.accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
	
	@GetMapping("/")
	public String welcomePublic() {
	    return "Hello World";
	}
	
}
