package com.dnynn.users;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepo;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginPage");
		return modelAndView;

	}

	@RequestMapping(value = "/user/userHome", method = RequestMethod.GET)
	public ModelAndView userHome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName() + "***********" + auth.getAuthorities().toString());
		User user = userService.findUserByEmail(auth.getName());

		modelAndView.addObject("userName",
				"Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with User Role");
		modelAndView.setViewName("/user/userHomePage");
		return modelAndView;

	}

	@RequestMapping(value = "/admin/adminHome", method = RequestMethod.GET)
	public ModelAndView adminHome(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName() + "***********" + auth.getAuthorities().toString());
		if (request.isUserInRole("USER")) {
			System.out.println("YEAH");
		} else {
			System.out.println("FUCK");
		}
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("/admin/adminHomePage");
		return modelAndView;

	}

	@RequestMapping(value = "/admin/UserRegistration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		List<Role> roles = new ArrayList<>();
		roleRepo.findAll().forEach(roles::add);

		modelAndView.addObject("user", user);
		modelAndView.addObject("roleList", roles);
		modelAndView.setViewName("/admin/UserRegistrationPage");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/UserRegistration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult,
			@RequestParam(value = "role") String role) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		System.out.println(role);
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/admin/UserRegistrationPage");
		} else {

			userService.saveUser(user, role);
			List<Role> roles = new ArrayList<>();
			roleRepo.findAll().forEach(roles::add);
			modelAndView.addObject("successMessage", "User has been registered successfully");

			modelAndView.addObject("roleList", roles);
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("/admin/UserRegistrationPage");

		}
		return modelAndView;
	}

	@RequestMapping("/initAdmin")
	public ModelAndView InitialAdmin() {
		Role role = new Role();
		role.setRole("ADMIN");
		roleRepo.save(role);
		User user = new User("Sarindy", "Ouk", "sarindy@dnynn.com", "123456", 1);
		userService.saveUser(user, "ADMIN");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}

}
