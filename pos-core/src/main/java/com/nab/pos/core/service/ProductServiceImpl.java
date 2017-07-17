package com.nab.pos.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nab.pos.business.model.Product;
import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.common.dto.converter.ProductConverter;
import com.nab.pos.core.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  @Autowired
  @Qualifier("productRepositoryHbn")
  ProductRepository repository;

  public Integer add(ProductDTO productDTO) {
    try {
      Product productIn = repository.persist(ProductConverter.convertDTO(productDTO));
      return productIn.getId();
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  // Esto estaría repetitivo en varios servicios. Ver una manera de generalizar
  public List<ProductDTO> list() {
    List<Product> products = repository.list();
    List<ProductDTO> productsDTO = new ArrayList<>();

    products.forEach(
        (final Product product) -> productsDTO.add(ProductConverter.convertToDTO(product)));

    return productsDTO;
  }

  public ProductDTO getByKey(Integer id) {
    Product product = repository.getByKey(id);
    try {
      return ProductConverter.convertToDTO(product);
      // Deberiamos tener nuestras propias clases que manejen las exceptions...
    } catch (NullPointerException e) {
      // logging...
      return null;
    }

  }

}
