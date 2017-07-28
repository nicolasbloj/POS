package com.nab.pos.core.service.operation;

import java.io.Serializable;

// interface-segregation principle (ISP)
public interface PersistenceService<PK extends Serializable, E, D> {

  public PK addOrUpdate(D dto) throws Exception;

}
