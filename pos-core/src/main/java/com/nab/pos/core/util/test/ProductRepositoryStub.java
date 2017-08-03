package com.nab.pos.core.util.test;

import java.util.ArrayList;
import java.util.List;

import com.nab.pos.business.model.Product;
import com.nab.pos.core.repository.ProductRepository;

public class ProductRepositoryStub implements ProductRepository {
  List<Product> products = new ArrayList<>();

  @Override
  public List<Product> list() {


    products.add(new Product("AA01", "AIRE"));
    products.add(new Product("FF01", "FOCO"));
    // list.add(new Product("FF02", "FOCO2"));

    return products;
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

  @Override
  public Product delete(Product aProduct) throws Exception {
    // products.remove(aProduct);
    return null;
  }


}
