package br.com.judice.servicos.domain.interfaces.services;

import java.util.Collection;

public interface IServiceBase<T> {

	void Add(T obj);

	T getById(Long id, Class<T> clazz);

	Collection<T> getAll(Class<T> clazz);

	void update(T obj);

	void remove(T obj);

	void Dispose();
}