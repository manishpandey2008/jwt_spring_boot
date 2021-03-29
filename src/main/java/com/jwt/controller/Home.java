package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.helper.JwtUtil;
import com.jwt.model.ResponseMsg;
import com.jwt.model.User;
import com.jwt.repo.UserRepository;
import com.jwt.services.EmployeeService;
import com.jwt.services.UserValidater;

@RestController
@CrossOrigin(origins = "*")
public class Home {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@RequestMapping("/welcome")
    public String welcome() {
        String text = "Welcome ! Welcome to the home";
        return text;
    }


    @RequestMapping("/users")
    public String getUser() {
        return "{\"name\":\"Balmukund Pandey\"}";
    }
    
    @GetMapping("/home")
    public String getHome() {
        return "{\"name\":\"Welcome to the home\"}";
    }
    
    @PostMapping("/emp/new")
    public ResponseEntity<?> addNewEmployee(@RequestBody User user) 
    {	
    	UserValidater userValidater=new UserValidater();
    	if(		userValidater.nameValidation(user.getName()) &&
    			userValidater.emailValidation(user.getEmail()) &&
    			userValidater.phoneValidation(user.getPhone()) &&
    			userValidater.usernameValidation(user.getUsername()) &&
    			userValidater.passwordValidation(user.getPassword()) 
    		) {
    		
		    	try {
		    		employeeService.addNew(user);
		    		return ResponseEntity.ok(new ResponseMsg("Add Successfull","200"));
				}catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.ok(new ResponseMsg("Not Add","500"));
				}
    
    	}else {
    			return ResponseEntity.ok(new ResponseMsg("User Is Not Valid","404"));
    	}
    }
    
    @GetMapping("/adminchecker/{token}")
    public Boolean adminChecker(@PathVariable String token) {
    	String username=jwtUtil.getUsernameFromToken(token);
    	User user=userRepository.findByUsername(username);
    	if(user.getRole().compareTo("Admin")==0) {
    		return true;
    	}
    	return false;
    }
}
