package com.dnynn.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dnynn.users.User;
import com.dnynn.users.UserService;

@RestController
public class Controller {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("initUser")
	public ModelAndView initialUserAdmin(){
		User user=new User();
		user.setFirstName("Sarindy");
		user.setLastName("Ouk");
		user.setActive(1);
		user.setPassword("123456");
		userService.saveUser(user, "ADMIN");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/loginPage");
		return modelAndView;
	}

}
