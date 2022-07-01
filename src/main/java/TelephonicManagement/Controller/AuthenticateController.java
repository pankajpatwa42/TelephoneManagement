package TelephonicManagement.Controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TelephonicManagement.Config.JwtUtils;
import TelephonicManagement.Models.JwtRequest;
import TelephonicManagement.Models.JwtResponse;
import TelephonicManagement.Models.User;



@CrossOrigin
@RestController
public class AuthenticateController {
	
	@Autowired
	private JwtUtils jwtutils;
	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	  public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest jwtRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtutils.generateJwtToken(authentication);
	    
	    User userDetails = (User) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt));
	  }

}
