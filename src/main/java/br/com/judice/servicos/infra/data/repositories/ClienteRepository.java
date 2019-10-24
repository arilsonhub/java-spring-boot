package br.com.judice.servicos.infra.data.repositories;

import org.springframework.stereotype.Component;

import br.com.judice.servicos.domain.entities.Cliente;
import br.com.judice.servicos.domain.interfaces.repositories.IClienteRepository;

@Component
public class ClienteRepository extends RepositoryBase<Cliente> implements IClienteRepository {

}