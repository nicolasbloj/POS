package com.nab.pos.repository.hbn;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nab.pos.business.model.pers.Client;
import com.nab.pos.core.repository.ClientRepository;

@Repository("clientRepositoryHbn")
@Transactional
public class ClientRepositoryHbn extends RepositoryHbn<Long, Client> implements ClientRepository {

}
