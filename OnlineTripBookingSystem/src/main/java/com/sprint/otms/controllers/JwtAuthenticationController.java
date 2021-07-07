package com.sprint.otms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.otms.JwtTokenUtil;
import com.sprint.otms.exceptions.UserNotFoundException;
import com.sprint.otms.models.JwtRequest;
import com.sprint.otms.models.JwtResponse;
import com.sprint.otms.models.User;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IUserRepository;
import com.sprint.otms.services.JwtUserDetailsService;
import com.sprint.otms.services.UserServiceImpl;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
    private PasswordEncoder bcryptEncoder;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

User userDb = userServiceImpl.Login(authenticationRequest.getEmail(), authenticationRequest.getPassword(), authenticationRequest.getUserType());
		
		if(userDb == null)
		{
			throw new UserNotFoundException("Not a Valid User");
		}
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		System.out.println("============================================");
		System.out.println("jwt reuest " + authenticationRequest.getEmail());
		System.out.println("============================================");

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		System.out.println("in controller printing user details" + userDetails);
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("token" + token);

		return ResponseEntity.ok(new JwtResponse(token,userDb.getId()));
	}

//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody com.sprint.otms.models.User user) throws Exception {
//		return ResponseEntity.ok(userDetailsService.save(user));
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userServiceImpl.registerUser(user));
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ResponseEntity<User> loginUser(@RequestParam String emailId, @RequestParam String password, @RequestParam User_Type role) throws Exception {
		return ResponseEntity.ok(userServiceImpl.Login(emailId, password, role));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PATCH)
	public ResponseEntity<User> updatePassword(@RequestParam String newPassword,@RequestBody User user) throws Exception {
		System.out.println(user.getPassword());
		List<User> u = userRepository.findByEmail(user.getEmail());
		System.out.println(user.getPassword());
		if(u.size() > 0)
		{
			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
			System.out.println("old password"+userDetails.getPassword());
			
			if(userDetails.getPassword()==user.getPassword())
			{
				System.out.println(newPassword);
				
				u.get(0).setPassword(bcryptEncoder.encode(newPassword));
				System.out.println(newPassword);
				return ResponseEntity.ok(userRepository.save(u.get(0)));
			}
			else
			{
				throw new Exception("Invalid old password");
			}	
		}
		else
		{
			throw new UserNotFoundException("No user found");
		}
	}
}