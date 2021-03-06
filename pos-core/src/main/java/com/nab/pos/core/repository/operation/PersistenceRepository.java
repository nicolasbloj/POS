package com.nab.pos.core.repository.operation;

import java.io.Serializable;

// interface-segregation principle (ISP)
public interface PersistenceRepository<PK extends Serializable, E> {

  public E saveOrUpdate(E entity) throws Exception;

}
