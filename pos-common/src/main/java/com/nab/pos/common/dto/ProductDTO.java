package com.nab.pos.common.dto;

import lombok.Getter;

public class ProductDTO {

  @Getter
  private Integer id;
  @Getter
  private String code;
  @Getter
  private String description;

  public ProductDTO() {}

  // to add
  public ProductDTO(String code, String description) {
    this.code = code;
    this.description = description;
  }

  // from get a product
  public ProductDTO(Integer id, String code, String description) {
    this.id = id;
    this.code = code;
    this.description = description;
  }

}
