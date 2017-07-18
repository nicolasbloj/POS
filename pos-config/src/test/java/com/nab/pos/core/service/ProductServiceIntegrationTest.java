package com.nab.pos.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

  /*
   * Es importante que el nombre de los tests comience o acabe por la palabra Test, ya que algunas
   * herramientas que lanzan tests de forma automatizada, como Sonar, utilizan esta marca para
   * detectar qué clases ejecutar.
   */
  @Test
  public void testList() {

    List<ProductDTO> expectedProductList = ProductRepositoryExpected.getExpectedProductList();

    List<ProductDTO> actualProductList = service.list();

    assertEquals(expectedProductList.size(), actualProductList.size());

    // Controlar tambien los datos internos a cada array.

    for (ProductDTO productDTO : expectedProductList) {
      ProductDTO productDTO_exp = productDTO;
      ProductDTO productDTO_act =
          actualProductList.get(expectedProductList.indexOf(productDTO_exp));
      assertNotNull(productDTO_exp);
      assertNotNull(productDTO_act);
      assertEquals(productDTO_exp.getCode(), productDTO_act.getCode());
      assertEquals(productDTO_exp.getDescription(), productDTO_act.getDescription());
    }

  }

}
