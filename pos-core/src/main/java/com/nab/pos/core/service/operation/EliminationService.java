package com.nab.pos.core.service.operation;

import java.io.Serializable;

public interface EliminationService<PK extends Serializable, D> {

  public PK delete(D dto);
}
