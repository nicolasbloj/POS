package com.nab.pos.core.util.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nab.pos.common.dto.ClientDTO;

public class ClientRepositoryExpected {


  public static List<ClientDTO> getExpectedClientList() {

    List<ClientDTO> list = new ArrayList<ClientDTO>();

    list.add(new ClientDTO("0100000", "Cliente Contado", "Cliente Contado", "00-000000000-0",
        "Actividad P xxxxx", "Actividad S xxxxx", "Producto YYYYY", "Industria XYZ", new Date(),
        "444444444", "381381381381", "clientecontado@gmail.com"));

    list.add(new ClientDTO("0100001", "Cliente Contado2", "Cliente Contado2", "00-000000000-2",
        "Actividad P xxxxx 2", "Actividad S xxxxx 2 ", "Producto YYYYY 2 ", "Industria XYZ 2",
        new Date(), "444444444 2", "3813813813812", "clientecontado2@gmail.com"));



    return list;
  }
}
