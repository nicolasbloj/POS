package com.nab.pos.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nab.pos.business.model.pers.Client;
import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.common.dto.converter.ClientConverter;
import com.nab.pos.common.util.exception.ConverterException;
import com.nab.pos.core.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

  @Autowired
  @Qualifier("clientRepositoryHbn")
  private ClientRepository repository;

  @Override
  public Long addOrUpdate(ClientDTO clientDTO) throws Exception {
    try {
      Client clientIn = repository.saveOrUpdate(ClientConverter.convertDTO(clientDTO));
      return clientIn.getId();
    } catch (Exception e) {
      e.printStackTrace();
      return new Long(-1);
    }
  }


  @Override
  public List<ClientDTO> list() {

    List<Client> clients = repository.list();
    List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();


    clients.forEach((final Client client) -> {
      try {
        clientsDTO.add(ClientConverter.convertToDTO(client));
      } catch (ConverterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

    return clientsDTO;
  }

  @Override
  public ClientDTO getByKey(Long key) throws ConverterException {
    // TODO Auto-generated method stub
    return null;
  }


}
