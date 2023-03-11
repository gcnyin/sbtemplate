package com.boluotou.template.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String roleId;
  private String name;

//  @ManyToMany(fetch = FetchType.EAGER)
//  @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
//  private Set<Permission> permissions = new HashSet<>();
}
