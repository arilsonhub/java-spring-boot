package br.com.judice.servicos.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.judice.servicos.domain.entities.Cliente;
import br.com.judice.servicos.domain.interfaces.repositories.IClienteRepository;
import br.com.judice.servicos.domain.interfaces.services.IClienteService;

@Service
public class ClienteService extends ServiceBase<Cliente> implements IClienteService {

	private final IClienteRepository clienteRepository;

	@Autowired
	public ClienteService(@Qualifier("clienteRepository") IClienteRepository clienteRepository) {
		super(clienteRepository);
		this.clienteRepository = clienteRepository;
	}
}