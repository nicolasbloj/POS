package com.nab.pos.endpoint.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.jsonpath.JsonPath;
import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.config.POSConfig;
import com.nab.pos.config.POSHbnConfig;
import com.nab.pos.core.service.ClientService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {POSConfig.class, POSHbnConfig.class})
public class ClientControllerHttpTest {

  private Logger logger = Logger.getLogger(ClientControllerHttpTest.class);

  @Autowired
  private WebApplicationContext wac;

  @Autowired
  private ClientService clientService;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    System.out.println("BEFORE TEST sout");
    logger.info("BEFORE TEST");

    // The first option is to point to Spring MVC configuration through the TestContext framework
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    // The second option is to simply register a controller instance without loading any Spring
    // configuration:
    // this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController()).build();

    ClientDTO clientDTO = new ClientDTO("0100000", "Cliente Contado", "Cliente Contado",
        "00-000000000-0", "Actividad P xxxxx", "Actividad S xxxxx", "Producto YYYYY",
        "Industria XYZ", new Date(), "444444444", "381381381381", "clientecontado@gmail.com");

    try {

      clientService.addOrUpdate(clientDTO);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testListClients() throws Exception {
    logger.info("*TEST");

    MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    List<ClientDTO> listClient = clientService.list();

    logger.info("SIZE " + listClient.size());

    logger.info("Client[0] ID : " + listClient.get(0).getId());

    // You can call andReturn() and use the returned MvcResult object to get the content as a String
    MvcResult mvcResult = this.mockMvc
        .perform(
            get("/client/list").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JSON_UTF8))
        .andReturn();

    String content;

    try {

      content = mvcResult.getResponse().getContentAsString();

      logger.info(".content -> " + content);


      // TypeRef<Integer> typeRef = new TypeRef<Integer>() {};

      // JsonPath.parse(content).read("$[0].id", typeRef);

      Assert.assertEquals(new Integer(1), (Integer) JsonPath.parse(content).read("$[0].id"));


    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // org.mockito.Mockito.verify(clientService, times(1)).list();

  }


  @Test
  public void testAddClients() throws Exception {}
  // AFTER, CONTROLAR LO GUARDADO


  @Test
  public void testUpdateClients() throws Exception {}



}
