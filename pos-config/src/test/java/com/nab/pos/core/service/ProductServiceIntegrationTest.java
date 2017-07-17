package com.nab.pos.core.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.config.POSConfig;
import com.nab.pos.config.POSHbnConfig;
import com.nab.pos.core.repository.ProductRepository;
import com.nab.pos.core.util.test.ProductRepositoryExpected;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {POSConfig.class, POSHbnConfig.class})
public class ProductServiceIntegrationTest {
  // No usamos mock ni stub

  // Class
  @Autowired
  @Qualifier("productServiceImpl")
  private ProductService service;

  // interface
  @Autowired
  @Qualifier("productRepositoryHbn")
  private ProductRepository repository;

  @Before
  public void setUp() {
    // CARGAMOS ANTES DOS PRODUCTOS PARA PROBAR !

    try {

      service.add(new ProductDTO("AA01", "AIRE"));
      service.add(new ProductDTO("FF01", "FOCO"));


    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  @Test
  public void list() {

    List<ProductDTO> expectedProductList = ProductRepositoryExpected.getExpectedProductList();

    List<ProductDTO> actualProductList = service.list();

    assertEquals(expectedProductList.size(), actualProductList.size());

    // Controlar tambien los datos internos a cada array.
  }

}
