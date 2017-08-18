package com.nab.pos.core.util.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nab.pos.business.model.pers.Client;
import com.nab.pos.core.repository.ClientRepository;

public class ClientRepositoryStub implements ClientRepository {

  public ClientRepositoryStub() {}

  @Override
  public List<Client> list() {

    List<Client> list = new ArrayList<Client>();

    list.add(new Client(new Long(1), "0100000", "Cliente Contado", "Cliente Contado",
        "00-000000000-0", "Actividad P xxxxx", "Actividad S xxxxx", "Producto YYYYY",
        "Industria XYZ", new Date(), "444444444", "381381381381", "clientecontado@gmail.com"));

    list.add(
        new Client(new Long(2), "0100001", "Cliente Contado2", "Cliente Contado2", "00-000000000-2",
            "Actividad P xxxxx 2", "Actividad S xxxxx 2 ", "Producto YYYYY 2 ", "Industria XYZ 2",
            new Date(), "444444444 2", "3813813813812", "clientecontado2@gmail.com"));



    return list;
  }

  @Override
  public Client getByKey(Long key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Client saveOrUpdate(Client entity) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}
