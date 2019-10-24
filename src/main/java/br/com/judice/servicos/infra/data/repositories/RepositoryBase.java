package br.com.judice.servicos.infra.data.repositories;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.judice.servicos.domain.interfaces.repositories.IRepositoryBase;

public class RepositoryBase<T> implements IRepositoryBase<T> {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void Add(T obj) {
		entityManager.persist(obj);
	}

	@Override
	public T getById(Long id, Class<T> clazz) {
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> getAll(Class<T> clazz) {
		List<T> resultList = entityManager.createQuery("from ".concat(clazz.getName())).getResultList();
		return resultList;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void update(T obj) {
		entityManager.merge(obj);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void remove(T obj) {
		entityManager.remove(obj);
	}

	@Override
	public void Dispose() {
		entityManager.clear();
		entityManager.close();
	}
}