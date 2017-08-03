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
import com.nab.pos.common.util.exception.ConverterException;
import com.nab.pos.core.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  // private Logger logger = Logger.getLogger(ProductService.class);

  @Autowired
  @Qualifier("productRepositoryHbn")
  ProductRepository repository;

  public Integer addOrUpdate(ProductDTO productDTO) {
    try {
      Product productIn = repository.saveOrUpdate(ProductConverter.convertDTO(productDTO));
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

    products.forEach((final Product product) -> {
      try {
        productsDTO.add(ProductConverter.convertToDTO(product));
      } catch (ConverterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

    return productsDTO;
  }

  public ProductDTO getByKey(Integer id) throws ConverterException {
    Product product = repository.getByKey(id);
    try {
      return ProductConverter.convertToDTO(product);
      // Deberiamos tener nuestras propias clases que manejen las exceptions...
    } catch (NullPointerException e) {
      // logging...
      return null;
    }

  }

  @Override
  public Integer delete(ProductDTO productDTO) {
    try {
      Product productDel = repository.delete(ProductConverter.convertDTO(productDTO));
      return productDel.getId();
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }


  }

}
