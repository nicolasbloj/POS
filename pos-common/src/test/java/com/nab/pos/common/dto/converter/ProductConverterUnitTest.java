package com.nab.pos.common.dto.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nab.pos.business.model.Product;
import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.common.util.exception.ConverterException;


public class ProductConverterUnitTest {

  private static final String CODE = "AA01";

  private static final String DESCRIPTION = "AIRE";

  private Product product;

  private ProductDTO productDTO;

  @Before
  public void setUp() {
    product = new Product(CODE, DESCRIPTION);
    productDTO = new ProductDTO(CODE, DESCRIPTION);
  }

  @Test
  public void testConvertToDTO() throws ConverterException {
    ProductDTO aproductDTO = ProductConverter.convertToDTO(product);
    Assert.assertNotNull(aproductDTO);
    Assert.assertEquals(aproductDTO.getCode(), CODE);
    Assert.assertEquals(aproductDTO.getDescription(), DESCRIPTION);
    Assert.assertTrue(aproductDTO.getDescription().equals(DESCRIPTION));
  }

  @Test
  public void testConvertDTO() throws ConverterException {
    Product aproduct = ProductConverter.convertDTO(productDTO);
    Assert.assertNotNull(aproduct);
    Assert.assertEquals(aproduct.getCode(), CODE);
    Assert.assertEquals(aproduct.getDescription(), DESCRIPTION);
    Assert.assertTrue(aproduct.getDescription().equals(DESCRIPTION));
  }

  @Test(expected = ConverterException.class)
  public void testNullPointer() throws ConverterException {
    ProductDTO productDTO = ProductConverter.convertToDTO(null);
    productDTO.getCode().equals(CODE);

  }


}
