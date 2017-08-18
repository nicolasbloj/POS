package com.nab.pos.common.dto.converter;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nab.pos.business.model.pers.Client;
import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.common.util.exception.ConverterException;

public class ClientConverterUnitTest {

  private static final Long ID = new Long(1);

  private static final String CODE = "01123";

  private static final String NAME = "NICOB";

  private Client client;

  private ClientDTO clientDTO;

  @Before
  public void setUp() {
    client = new Client(ID, CODE, NAME, "Implementador com", "23-35521651-9", "comercio electr",
        "Comercio elect", "productos deportivos", "Sport", new Date(), "412312312", "141233423",
        "email@@");
    clientDTO = new ClientDTO(ID, CODE, NAME, "comercio electr", "23-35521651-9", "comercio electr",
        "Comercio elect", "productos deportivos", "Sport", new Date(), "412312312", "141233423",
        "email@@");
  }

  @Test
  public void testConvertToDTO() throws ConverterException {
    ClientDTO aclientDTO = ClientConverter.convertToDTO(client);

    Assert.assertNotNull(aclientDTO);

    Assert.assertEquals(aclientDTO.getId(), ID);
    Assert.assertEquals(aclientDTO.getCode(), CODE);
    Assert.assertEquals(aclientDTO.getBusinessName(), NAME);
    Assert.assertTrue(aclientDTO.getBusinessName().equals(NAME));

  }

  @Test
  public void testConvertDTO() throws ConverterException {
    Client aclient = ClientConverter.convertDTO(clientDTO);
    Assert.assertNotNull(aclient);
    Assert.assertEquals(aclient.getCode(), CODE);
    Assert.assertEquals(aclient.getBusinessName(), NAME);
    Assert.assertTrue(aclient.getBusinessName().equals(NAME));
  }

  @Test(expected = ConverterException.class)
  public void testNullPointer() throws ConverterException {
    ClientDTO clientDTO = ClientConverter.convertToDTO(null);
    clientDTO.getCode().equals(CODE);

  }

}
