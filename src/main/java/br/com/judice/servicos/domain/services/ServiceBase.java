package br.com.judice.servicos.domain.services;

import java.util.Collection;

import br.com.judice.servicos.domain.interfaces.repositories.IRepositoryBase;
import br.com.judice.servicos.domain.interfaces.services.IServiceBase;

public class ServiceBase<T> implements IServiceBase<T> {

	private final IRepositoryBase<T> repository;

	public ServiceBase(IRepositoryBase<T> repository) {
		this.repository = repository;
	}

	@Override
	public void Add(T obj) {
		this.repository.Add(obj);
	}

	@Override
	public T getById(Long id, Class<T> clazz) {
		return repository.getById(id, clazz);
	}

	@Override
	public Collection<T> getAll(Class<T> clazz) {
		return repository.getAll(clazz);
	}

	@Override
	public void update(T obj) {
		repository.update(obj);
	}

	@Override
	public void remove(T obj) {
		repository.remove(obj);
	}

	@Override
	public void Dispose() {
		repository.Dispose();
	}
}