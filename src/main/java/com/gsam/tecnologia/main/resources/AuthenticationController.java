package com.gsam.tecnologia.main.resources;

import com.gsam.tecnologia.main.security.TokenService;
import com.gsam.tecnologia.main.dto.AuthenticationDTO;
import com.gsam.tecnologia.main.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@Valid @RequestBody AuthenticationDTO dto){
    var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(),dto.password());
    var auth = this.authenticationManager.authenticate(usernamePassword);
    var token = tokenService.generateToken((User) auth.getPrincipal());
    return ResponseEntity.ok(Collections.singletonMap("token",token));
  }
}
