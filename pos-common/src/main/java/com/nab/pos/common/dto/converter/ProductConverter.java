package com.nab.pos.common.dto.converter;

import com.nab.pos.business.model.Product;
import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.common.util.exception.ConverterException;

// Conviene que a esta clase la maneje spring?
public class ProductConverter {

  public static ProductDTO convertToDTO(Product product) throws ConverterException {
    if (product == null) {
      throw new ConverterException(
          "product no puede ser converido a productDTO ya que product es nulo");
    }
    return new ProductDTO(product.getId(), product.getCode(), product.getDescription());
  }

  // fromDTOToEntity
  public static Product convertDTO(ProductDTO productDTO) throws ConverterException {
    if (productDTO == null) {
      throw new ConverterException(
          "productDTO no puede ser converido a product ya que productDTO es nulo");
    }

    if (productDTO.getId() != null && productDTO.getId() > 0) { // put method
      return new Product(productDTO.getId(), productDTO.getCode(), productDTO.getDescription());
    } else {
      return new Product(productDTO.getCode(), productDTO.getDescription());
    }
  }

}
