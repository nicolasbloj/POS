package com.nab.pos.core.util.test;

import java.util.ArrayList;
import java.util.List;

import com.nab.pos.business.model.Product;
import com.nab.pos.core.repository.ProductRepository;

public class ProductRepositoryStub implements ProductRepository {

  @Override
  public List<Product> list() {

    List<Product> list = new ArrayList<>();
    list.add(new Product("AA01", "AIRE"));
    list.add(new Product("FF01", "FOCO"));
    // list.add(new Product("FF02", "FOCO2"));

    return list;
  }

  @Override
  public Product getByKey(Integer key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Product saveOrUpdate(Product entity) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }


}
