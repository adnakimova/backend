package com.jap.initial.springjwt.contoller;
import com.jap.initial.springjwt.entities.Users;
import com.jap.initial.springjwt.payload.ApiResponse;
import com.jap.initial.springjwt.payload.ChangePasswordRequest;
import com.jap.initial.springjwt.payload.JwtAuthResponse;
import com.jap.initial.springjwt.payload.LoginRequest;
import com.jap.initial.springjwt.security.JwtTokenProvider;
import com.jap.initial.springjwt.services.CustomUserDetailsService;
import com.jap.initial.springjwt.services.MapValidationErrorService;
import com.jap.initial.springjwt.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final MapValidationErrorService mapValidationErrorService;
    private final UsersService usersService;
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UsersService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
    		JwtTokenProvider jwtTokenProvider, MapValidationErrorService mapValidationErrorService,
    		UsersService usersService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.mapValidationErrorService = mapValidationErrorService;
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Users user) {
        if (user.getPassword() == null) return mapValidationErrorService.passwordRequired("password");

        Users newUser = usersService.saveUser(user);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.CREATED, newUser), HttpStatus.CREATED);
    }
    

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest passwordRequest) {
        return usersService.changePassword(passwordRequest) ? new ResponseEntity<>(HttpStatus.OK) : 
        	new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/current-user")
    public Users getCurrentUser(ModelMap model) {
    	
    	String email  =  SecurityContextHolder.getContext().getAuthentication().getName();
    	return this.userService.findByEmail(email);
    	
    }   
}
