package com.nab.pos.repository.hbn;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nab.pos.business.model.Product;
import com.nab.pos.core.repository.ProductRepository;

/**
 *
 * @author root
 */
@Repository("productRepositoryHbn")
@Transactional
public class ProductRepositoryHbn extends RepositoryHbn<Integer, Product>
    implements ProductRepository {



}
