package com.nab.pos.business.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "PRODUCTO")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Getter
  private Integer id;
  @Column(name = "codigo")
  @Getter
  private String code;
  @Column(name = "descripcion")
  @Getter
  private String description;

  public Product() {
    super();
  }

  public Product(String code, String description) {
    super();
    this.code = code;
    this.description = description;
  }

  // for put method
  public Product(Integer id, String code, String description) {
    super();
    this.id = id;
    this.code = code;
    this.description = description;
  }

}
