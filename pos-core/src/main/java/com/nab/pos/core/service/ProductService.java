package com.nab.pos.core.service;

import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.core.service.operation.EliminationService;
import com.nab.pos.core.service.operation.PersistenceService;
import com.nab.pos.core.service.operation.SearchService;


public interface ProductService extends SearchService<Integer, ProductDTO>,
    PersistenceService<Integer, ProductDTO>, EliminationService<Integer, ProductDTO> {

}
