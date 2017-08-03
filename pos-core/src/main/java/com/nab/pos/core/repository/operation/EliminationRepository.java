package com.nab.pos.core.repository.operation;

import java.io.Serializable;

public interface EliminationRepository<PK extends Serializable, E> {

  public E delete(E entity) throws Exception;

}
