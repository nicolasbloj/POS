package com.nab.pos.endpoint.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.core.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

  private Logger logger = Logger.getLogger(ClientController.class);

  @Autowired
  ClientService service;

  @RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<Map<String, Long>> add(@RequestBody(required = true) ClientDTO clientDTO) {
    logger.info("ADD");


    logger.info("DATE");
    logger.info(clientDTO.getConstitutionDate());
    return addOrUpdate(clientDTO);
  }


  @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<Map<String, Long>> update(
      @RequestBody(required = true) ClientDTO clientDTO) {
    return addOrUpdate(clientDTO);
  }

  private ResponseEntity<Map<String, Long>> addOrUpdate(
      @RequestBody(required = true) ClientDTO clientDTO) {


    logger.info("ADD OR UPDATE");

    logger.info(clientDTO.getCellPhone() + " -> CELL");


    ResponseEntity<Map<String, Long>> response = null;

    Map<String, Long> map = new HashMap<String, Long>();

    HttpStatus httpStatus = HttpStatus.OK;

    try {

      Long id = service.addOrUpdate(clientDTO);

      if (id == -1) {
        map.put(new StringBuilder(50).append("No se pudo insertar el cliente")
            .append(clientDTO.getCode()).toString(), new Long(-1));
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

      }

      map.put(new StringBuilder(50).append("El cliente ").append(id)
          .append(" fue correctamente insertado").toString(), id);

      response = new ResponseEntity<>(map, httpStatus);


    } catch (Exception e) {
      logger.error(new StringBuilder(150).append("An error happens while trying to add the client ")
          .append(clientDTO.getCode()).toString());

      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

      map.put(new StringBuilder(50).append("An error happens while trying to add the client ")
          .append(clientDTO.getCode()).toString(), new Long(-2));
    }

    return response;
  }


  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<ClientDTO>> list() {
    List<ClientDTO> clientsDTO = service.list();
    return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
  }



}
