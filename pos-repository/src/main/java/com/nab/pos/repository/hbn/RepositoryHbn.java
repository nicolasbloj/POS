package com.nab.pos.repository.hbn;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import com.nab.pos.core.repository.operation.PersistenceRepository;
import com.nab.pos.core.repository.operation.SearchRepository;



public abstract class RepositoryHbn<PK extends Serializable, E>
    implements SearchRepository<PK, E>, PersistenceRepository<PK, E> {


  private Logger logger = Logger.getLogger(RepositoryHbn.class);


  @Autowired
  private SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }


  private final Class<E> persistentClass;

  @SuppressWarnings("unchecked")
  // Sometimes Java generics just doesn't let you do what you want to,
  // and you need to effectively tell the compiler that what you're doing really
  // will be legal at execution time
  public RepositoryHbn() {
    this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[1];
  }

  public E saveOrUpdate(E entity) {
    getSession().saveOrUpdate(entity);
    getSession().flush();
    return entity;
  }

  public List<E> list() {
    // return (List<E>) getSession().createQuery("from
    // "+persistentClass.getName()).list();
    return findByCriteria();
  }

  public E delete(E entity) {
    logger.info("delete");
    getSession().delete(entity);
    getSession().flush();
    return entity;
  }

  @SuppressWarnings("unchecked")
  protected List<E> findByCriteria(Criterion... criterion) {
    Criteria crit = getSession().createCriteria(persistentClass);
    for (Criterion c : criterion) {
      crit.add(c);
    }

    return crit.list();
  }

  public E getByKey(PK key) {
    return (E) getSession().get(persistentClass, key);
  }

}
