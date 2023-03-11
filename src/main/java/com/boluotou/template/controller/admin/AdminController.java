package com.boluotou.template.controller.admin;

import com.boluotou.template.entity.User;
import com.boluotou.template.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/list-user")
  public List<User> listUser() {
    return userRepository.findAll();
  }
}
