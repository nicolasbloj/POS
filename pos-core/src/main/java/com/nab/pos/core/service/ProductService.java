package com.nab.pos.core.service;

import com.nab.pos.business.model.Product;
import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.core.service.operation.PersistenceService;
import com.nab.pos.core.service.operation.SearchService;


public interface ProductService extends SearchService<Integer, Product, ProductDTO>,
    PersistenceService<Integer, Product, ProductDTO> {

}
