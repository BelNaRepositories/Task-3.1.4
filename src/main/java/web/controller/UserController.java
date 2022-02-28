package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.PaginationService;
import web.service.RoleService;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping
		("/")
public class UserController {
	private final UserService userService;
	private final RoleService roleService;
	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping({"", "login"})
	public String getLoginPage() {
		return "login";
	}

	@GetMapping(value = "/admin")
	public String getUsers(Model model){
		model.addAttribute("user", userService.getAllUsers());
		model.addAttribute("roles", roleService.getAllRoles());
		return "user-list";
	}
	@GetMapping(value = "/user")
	public User getUserPage(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		return user;
	}

}
























