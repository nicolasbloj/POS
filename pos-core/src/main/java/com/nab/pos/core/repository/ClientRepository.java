package com.nab.pos.core.repository;

import com.nab.pos.business.model.pers.Client;
import com.nab.pos.core.repository.operation.PersistenceRepository;
import com.nab.pos.core.repository.operation.SearchRepository;

public interface ClientRepository
    extends SearchRepository<Long, Client>, PersistenceRepository<Long, Client> {

}
