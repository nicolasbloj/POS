package com.nab.pos.core.repository;

import java.util.ArrayList;
import java.util.List;

import com.nab.pos.common.dto.ProductDTO;

public class ProductRepositoryUtil {

  public static List<ProductDTO> getExpectedProductList_list() {

    List<ProductDTO> list = new ArrayList<>();
    list.add(new ProductDTO("AA01", "AIRE"));
    list.add(new ProductDTO("FF01", "FOCO"));

    return list;

  }
}
