package com.nab.pos.core.service.operation;

import java.io.Serializable;
import java.util.List;

// interface-segregation principle (ISP)
public interface SearchService<PK extends Serializable, E, D> {

  public List<D> list();

  public D getByKey(PK key);

}
