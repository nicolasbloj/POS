package com.nab.pos.core.repository;

import com.nab.pos.business.model.Product;
import com.nab.pos.core.repository.operation.PersistenceRepository;
import com.nab.pos.core.repository.operation.SearchRepository;


/**
 *
 * @author root
 */
public interface ProductRepository
    extends SearchRepository<Integer, Product>, PersistenceRepository<Integer, Product> {


}
