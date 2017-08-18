package com.nab.pos.core.service;

import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.core.service.operation.PersistenceService;
import com.nab.pos.core.service.operation.SearchService;

public interface ClientService
    extends SearchService<Long, ClientDTO>, PersistenceService<Long, ClientDTO> {



}
