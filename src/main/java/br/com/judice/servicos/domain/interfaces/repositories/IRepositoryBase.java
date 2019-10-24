package br.com.judice.servicos.domain.interfaces.repositories;

import java.util.Collection;

public interface IRepositoryBase<T> {

	void Add(T obj);

	T getById(Long id, Class<T> clazz);

	Collection<T> getAll(Class<T> clazz);

	void update(T obj);

	void remove(T obj);

	void Dispose();
}