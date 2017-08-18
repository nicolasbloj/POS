package com.nab.pos.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.config.POSConfig;
import com.nab.pos.config.POSHbnConfig;
import com.nab.pos.core.repository.ClientRepository;
import com.nab.pos.core.util.test.ClientRepositoryExpected;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {POSConfig.class, POSHbnConfig.class})
public class ClientServiceIntegrationTest {

  @Autowired
  @Qualifier("clientServiceImpl")
  private ClientService service;

  @Autowired
  @Qualifier("clientRepositoryHbn")
  private ClientRepository repository;

  @Before
  public void setUp() {
    try {

      service.addOrUpdate(new ClientDTO("0100000", "Cliente Contado", "Cliente Contado",
          "00-000000000-0", "Actividad P xxxxx", "Actividad S xxxxx", "Producto YYYYY",
          "Industria XYZ", new Date(), "444444444", "381381381381", "clientecontado@gmail.com"));


      service.addOrUpdate(
          new ClientDTO("0100001", "Cliente Contado2", "Cliente Contado2", "00-000000000-2",
              "Actividad P xxxxx 2", "Actividad S xxxxx 2 ", "Producto YYYYY 2 ", "Industria XYZ 2",
              new Date(), "444444444 2", "3813813813812", "clientecontado2@gmail.com"));


    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testList() {

    List<ClientDTO> expectedClientList = ClientRepositoryExpected.getExpectedClientList();

    List<ClientDTO> actualClientList = service.list();

    assertEquals(expectedClientList.size(), actualClientList.size());

    for (ClientDTO clientDTO : expectedClientList) {
      ClientDTO clientDTO_exp = clientDTO;
      ClientDTO clientDTO_act = actualClientList.get(expectedClientList.indexOf(clientDTO));
      assertNotNull(clientDTO_exp);
      assertNotNull(clientDTO_act);
      assertEquals(clientDTO_exp.getCode(), clientDTO_act.getCode());
      assertEquals(clientDTO_exp.getBusinessName(), clientDTO_act.getBusinessName());
    }

  }



}
