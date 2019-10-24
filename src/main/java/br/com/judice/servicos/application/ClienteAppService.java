package br.com.judice.servicos.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.judice.servicos.application.interfaces.IClienteAppService;
import br.com.judice.servicos.domain.entities.Cliente;
import br.com.judice.servicos.domain.interfaces.services.IClienteService;

@Service
public class ClienteAppService extends AppServiceBase<Cliente> implements IClienteAppService {

	private final IClienteService clienteService;

	@Autowired
	public ClienteAppService(@Qualifier("clienteService") IClienteService clienteService) {
		super(clienteService);
		this.clienteService = clienteService;
	}
}