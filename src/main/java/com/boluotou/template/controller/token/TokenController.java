package com.boluotou.template.controller.token;

import com.boluotou.template.entity.User;
import com.boluotou.template.repo.UserRepository;
import com.boluotou.template.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/token")
public class TokenController {
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private UserRepository userRepository;

  @PostMapping("create-token")
  public CreateTokenResponse createToken(Authentication authentication) {
    User user = userRepository.getUserByUsername(authentication.getName());
    return new CreateTokenResponse(jwtUtil.generateToken(user));
  }
}
