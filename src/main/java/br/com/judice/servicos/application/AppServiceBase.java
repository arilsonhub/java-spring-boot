package br.com.judice.servicos.application;

import java.util.Collection;

import br.com.judice.servicos.application.interfaces.IAppServiceBase;
import br.com.judice.servicos.domain.interfaces.services.IServiceBase;

public class AppServiceBase<T> implements IAppServiceBase<T> {

	private final IServiceBase<T> serviceBase;

	public AppServiceBase(IServiceBase<T> serviceBase) {
		this.serviceBase = serviceBase;
	}

	@Override
	public void Add(T obj) {
		serviceBase.Add(obj);
	}

	@Override
	public T getById(Long id, Class<T> clazz) {
		return serviceBase.getById(id, clazz);
	}

	@Override
	public Collection<T> getAll(Class<T> clazz) {
		return serviceBase.getAll(clazz);
	}

	@Override
	public void update(T obj) {
		serviceBase.update(obj);
	}

	@Override
	public void remove(T obj) {
		serviceBase.remove(obj);
	}

	@Override
	public void Dispose() {
		serviceBase.Dispose();
	}
}