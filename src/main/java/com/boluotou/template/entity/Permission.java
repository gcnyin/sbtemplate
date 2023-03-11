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
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String permissionId;
  private String name;
}
