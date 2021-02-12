package com.jrp.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/greeting")
public class HelloController {

	
	@RequestMapping(value = "/basic")
	public String sayHello() {
		
		return "<h1>hello</h1>";

	}
	
	@RequestMapping(value = "/proper")
	public String sayProperHello() {
		
		return "<h1>Hello there, how are you?</h1>";

	}
	
	@RequestMapping(value = "/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"GET\">\n"
		+ "  <label for=\"fname\">First name:</label><br>\n"
		+ "  <input type=\"text\" id=\"fname\" name=\"firstname\" ><br>\n"
		+ "  <label for=\"lname\">Last name:</label><br>\n"
		+ "  <input type=\"text\" id=\"lname\" name=\"lastname\" ><br><br>\n"
		+ "  <input type=\"submit\" value=\"Submit\">\n"
		+ "</form> ";
	}
	
	@RequestMapping(value = "/user_greeting", method = RequestMethod.GET)
	public String printUserGreeting(@RequestParam String firstname ,@RequestParam String lastname) {
		return "Hello there, " + firstname + " " + lastname;
	}
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order ID:" + id;
	}
	
	
}
