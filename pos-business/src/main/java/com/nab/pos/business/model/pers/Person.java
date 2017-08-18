package com.nab.pos.business.model.pers;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@MappedSuperclass
@ToString(exclude = "id")
@EqualsAndHashCode
public class Person implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Getter
  Long id;

  @Column(name = "telefono", nullable = false, unique = false)
  @Getter
  private String phone;

  @Column(name = "celular", nullable = false, unique = false)
  @Getter
  private String cellPhone;

  @Column(name = "email", nullable = false, unique = false) /////
  @Getter
  private String email;

  public Person() {}

  public Person(String phone, String cellPhone, String email) {
    this.phone = phone;
    this.cellPhone = cellPhone;
    this.email = email;
    // this.address = address;
    // this.up = up;
  }

  public Person(long id, String phone, String cellPhone, String email) {
    this.id = id;
    this.phone = phone;
    this.cellPhone = cellPhone;
    this.email = email;
    // this.address = address;
    // this.up = up;
  }

}

