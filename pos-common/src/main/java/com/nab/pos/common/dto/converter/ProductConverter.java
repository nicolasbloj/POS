package com.nab.pos.common.dto.converter;

import com.nab.pos.business.model.Product;
import com.nab.pos.common.dto.ProductDTO;

public class ProductConverter {

  public static ProductDTO convertToDTO(Product product) {
    return new ProductDTO(product.getCode(), product.getDescription());
  }

  public static Product convertDTO(ProductDTO productDTO) {
    return new Product(productDTO.getCode(), productDTO.getDescription());
  }

}
