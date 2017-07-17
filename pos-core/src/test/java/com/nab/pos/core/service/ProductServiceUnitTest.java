package com.nab.pos.core.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.nab.pos.common.dto.ProductDTO;
import com.nab.pos.core.repository.ProductRepository;
import com.nab.pos.core.repository.ProductRepositoryStub;
import com.nab.pos.core.repository.ProductRepositoryUtil;

public class ProductServiceUnitTest {


  // Class
  private ProductService service;

  // interface
  // private ProductRepository repository;

  // interface
  private ProductRepository repositoryMock;// !MOCK

  // stub - un trozo de código usado como sustituto de alguna otra funcionalidad.
  private ProductRepositoryStub repositoryStub;


  @Before
  public void setUp() {
    repositoryStub = new ProductRepositoryStub();

    service = new ProductServiceImpl();

    // impl HBN
    // repository = new ProductRepositoryHbn();

    repositoryMock = org.mockito.Mockito.mock(ProductRepository.class); // !MOCK

    ReflectionTestUtils.setField(service, "repository", repositoryMock);// !MOCK
  }

  @Test
  public void list() {
    List<ProductDTO> expectedProductList = ProductRepositoryUtil.getExpectedProductList_list();


    // stubing mock
    org.mockito.Mockito.when(repositoryMock.list()).thenReturn(repositoryStub.list());// !MOCK

    // Definimos el comportamiento del metodo list para repositoryMock usando un comportamiento
    // simulado en repositoryStub ya que no tenemos todavia la implementacion de
    // ProductRepository


    List<ProductDTO> actualiProductList = service.list();


    assertEquals(expectedProductList.size(), actualiProductList.size());


  }



}
