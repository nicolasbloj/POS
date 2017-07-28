package com.nab.pos.endpoint.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.common.util.exception.ConverterException;
import com.nab.pos.core.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

  private Logger logger = Logger.getLogger(ProductController.class);

  @Autowired
  // @Qualifier("productServiceImpl")
  ProductService service;

  // En converter dto a product esta la clave.
  // si dto.id > 0 entonces
  // producto será creado con id,codigo y descripcion y luego repository persistirá el mismo.
  @RequestMapping(value = "/addOrUpdate", method = RequestMethod.PUT, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<Map<String, Integer>> add(
      @RequestBody(required = true) ProductDTO productDTO) {

    ResponseEntity<Map<String, Integer>> response = null;

    logger.info("productDTO -id: " + productDTO.getId() + "productDTO -code: "
        + productDTO.getCode() + " -desc: " + productDTO.getDescription());

    if (productDTO.getId() != null) {
      logger.info("productDTO -id: " + productDTO.getId());

    }

    Map<String, Integer> map = new HashMap<String, Integer>();
    HttpStatus httpStatus = HttpStatus.OK;

    try {
      Integer id = service.addOrUpdate(productDTO);
      if (id == -1) {
        map.put(new StringBuilder(50).append("No se pudo insertar el producto ")
            .append(productDTO.getCode()).toString(), -1);
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      }

      map.put(new StringBuilder(50).append("El producto ").append(id)
          .append(" fue correctamente insertado").toString(), id);

      response = new ResponseEntity<>(map, httpStatus);


    } catch (Exception e) {
      logger
          .error(new StringBuilder(150).append("An error happens while trying to add the product ")
              .append(productDTO.getCode()).toString());

      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

      map.put(new StringBuilder(50).append("An error happens while trying to add the product ")
          .append(productDTO.getCode()).toString(), -2);
    }

    return response;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<ProductDTO>> list() {
    List<ProductDTO> productsDTO = service.list();
    return new ResponseEntity<>(productsDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<ProductDTO> getByKey(@PathVariable Integer id) throws ConverterException {

    ProductDTO productDTO = service.getByKey(id);
    HttpStatus httpStatus = HttpStatus.OK;

    if (productDTO == null)
      httpStatus = HttpStatus.NOT_FOUND;

    return new ResponseEntity<>(productDTO, httpStatus);

  }

}
