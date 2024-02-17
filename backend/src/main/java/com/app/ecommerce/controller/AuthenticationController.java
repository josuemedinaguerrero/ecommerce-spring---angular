package com.app.ecommerce.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.AuthenticationRequest;
// import com.app.ecommerce.dto.AuthenticationResponse;
import com.app.ecommerce.entities.User;
import com.app.ecommerce.repository.UserRepository;
import com.app.ecommerce.service.jwt.UserDetailsServiceImpl;
// import com.app.ecommerce.service.user.UserService;
import com.app.ecommerce.utils.JwtUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

  // @Autowired
  // private UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JwtUtil jwtUtil;

  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";

  @PostMapping("/authenticate")
  public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
      HttpServletResponse response)
      throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, ServletException {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
          authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException("Incorrect username or password");
    } catch (DisabledException disabledException) {
      response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User is not activated");
      return;
    }

    userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

    User user = userRepository.findFirstByEmail(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(authenticationRequest.getUsername());

    // return new AuthenticationResponse(jwt);

    response.getWriter().write(new JSONObject().put("userId", user.getId()).put("role", user.getUserRole()).toString());

    response.addHeader("Access-Control-Expose-Headers", "Authorization");
    response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);

  }

}
