package com.nab.pos.common.dto.converter;

import com.nab.pos.business.model.pers.Client;
import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.common.util.exception.ConverterException;

public class ClientConverter {

  public static ClientDTO convertToDTO(Client client) throws ConverterException {

    if (client == null) {
      throw new ConverterException(
          "client no puede ser converido a clientDTO ya que client es nulo");
    }

    return new ClientDTO(client.getId(), client.getCode(), client.getBusinessName(),
        client.getTradeName(), client.getTaxId(), client.getPrincipalActivity(),
        client.getSecundaryActivity(), client.getPrincipalProductService(), client.getIndustry(),
        client.getConstitutionDate(), client.getPhone(), client.getCellPhone(), client.getEmail());
  }

  public static Client convertDTO(ClientDTO clientDTO) throws ConverterException {

    if (clientDTO == null) {
      throw new ConverterException(
          "clientDTO no puede ser converido a client ya que clientDTO es nulo");
    }

    if (clientDTO.getId() != null && clientDTO.getId() > 0) { // put method
      return new Client(clientDTO.getId(), clientDTO.getCode(), clientDTO.getBusinessName(),
          clientDTO.getTradeName(), clientDTO.getTaxId(), clientDTO.getPrincipalActivity(),
          clientDTO.getSecundaryActivity(), clientDTO.getPrincipalProductService(),
          clientDTO.getIndustry(), clientDTO.getConstitutionDate(), clientDTO.getPhone(),
          clientDTO.getCellPhone(), clientDTO.getEmail());
    } else {
      return new Client(clientDTO.getCode(), clientDTO.getBusinessName(), clientDTO.getTradeName(),
          clientDTO.getTaxId(), clientDTO.getPrincipalActivity(), clientDTO.getSecundaryActivity(),
          clientDTO.getPrincipalProductService(), clientDTO.getIndustry(),
          clientDTO.getConstitutionDate(), clientDTO.getPhone(), clientDTO.getCellPhone(),
          clientDTO.getEmail());

    }
  }

}
