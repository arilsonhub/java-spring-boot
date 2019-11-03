package br.com.judice.servicos.presentation.controllers;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.judice.servicos.application.interfaces.IClienteAppService;
import br.com.judice.servicos.domain.entities.Cliente;
import br.com.judice.servicos.presentation.viewModels.FormClienteResponseViewModel;
import br.com.judice.servicos.presentation.viewModels.FormClienteViewModel;

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("clienteAppService")
	private IClienteAppService				clienteAppService;

	@Autowired(required = false)
	private FormClienteResponseViewModel	formClienteResponseViewModel;

	@Autowired(required = false)
	private Cliente							cliente;

	@RequestMapping(method = RequestMethod.POST, path = "/cadastrar-escritorio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FormClienteResponseViewModel cadastrar(@Valid @RequestBody FormClienteViewModel formCliente, BindingResult result) {
		return salvarDadosCliente(formCliente, result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/editar-escritorio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FormClienteResponseViewModel editar(@Valid @RequestBody FormClienteViewModel formCliente, BindingResult result) {

		Cliente cliente = clienteAppService.getById(formCliente.getId(), Cliente.class);
		formCliente.setDataCadastro(cliente.getDataCadastro());

		return salvarDadosCliente(formCliente, result);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/listar-escritorio", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Cliente> listar() {

		Collection<Cliente> clienteList = clienteAppService.getAll(Cliente.class);
		return clienteList;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/carregar-escritorio/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Cliente carregarEscritorio(@PathVariable("id") Long id) {

		Cliente cliente = clienteAppService.getById(id, Cliente.class);
		return cliente;
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/remover-escritorio/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String removerEscritorio(@PathVariable("id") Long id) {

		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("{");
		responseBuilder.append("\"message\": \":message\"");
		responseBuilder.append("}");
		String response = responseBuilder.toString();

		try {
			Cliente cliente = clienteAppService.getById(id, Cliente.class);
			clienteAppService.remove(cliente);
			response = response.replace(":message", "Registro removido com sucesso.");
		} catch (Exception e) {
			response = response.replace(":message", "Não foi possível remover o registro.");
		}

		return response;
	}

	private FormClienteResponseViewModel salvarDadosCliente(FormClienteViewModel formCliente, BindingResult result) {
		try {
			if (result.hasFieldErrors())
				throw new ValidationException();

			BeanUtils.copyProperties(formCliente, cliente);
			Boolean idFoiInformado = (cliente.getId() != null);

			if (idFoiInformado)
				clienteAppService.update(cliente);
			else
				clienteAppService.Add(cliente);

			formClienteResponseViewModel.setMessage("Dados salvos com sucesso.");
			formClienteResponseViewModel.setSuccess(Boolean.TRUE);

		} catch (ValidationException cve) {
			formClienteResponseViewModel.setMessage("Existem erros no formulário, favor corrigir e tentar novamente.");
			formClienteResponseViewModel.setSuccess(Boolean.FALSE);
			formClienteResponseViewModel.setErrorList(result.getFieldErrors());
		} catch (Exception e) {
			formClienteResponseViewModel.setSuccess(Boolean.FALSE);
			formClienteResponseViewModel.setMessage("Não foi possível salvar os dados.");
		}

		return formClienteResponseViewModel;
	}
}