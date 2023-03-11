package com.boluotou.template.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String userId;
  private String username;
  private String displayName;
  private String password;
  private boolean isEnabled;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @Override
  public String toString() {
    return "User{" +
      "userId='" + userId + '\'' +
      ", username='" + username + '\'' +
      ", displayName='" + displayName + '\'' +
      ", password='" + password + '\'' +
      ", isEnabled=" + isEnabled +
      '}';
  }
}
