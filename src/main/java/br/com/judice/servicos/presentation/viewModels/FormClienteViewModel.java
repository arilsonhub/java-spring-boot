package br.com.judice.servicos.presentation.viewModels;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.judice.servicos.application.Util;
import br.com.judice.servicos.domain.annotations.Cpf;

public class FormClienteViewModel {

	private Long	id;
	@NotBlank(message = "Campo nome é obrigatório.")
	@Size(max = 100, message = "Este campo aceita no máximo 100 caracteres")
	private String	nome;
	@NotBlank(message = "Campo CPF é obrigatório.")
	@Size(max = 11, message = "Este campo deve ter no máximo 11 dígitos")
	@Cpf
	private String	cpf;
	@NotBlank(message = "Campo endereço é obrigatório.")
	@Size(max = 100, message = "Este campo aceita no máximo 100 caracteres")
	private String	endereco;
	@NotBlank(message = "Campo bairro é obrigatório.")
	@Size(max = 100, message = "Este campo aceita no máximo 100 caracteres")
	private String	bairro;
	@NotNull(message = "Informe a data do cadastro")
	private Date	dataCadastro;
	@NotBlank(message = "Campo fone é obrigatório.")
	@Size(max = 15, message = "Este campo aceita no máximo 15 dígitos")
	private String	fone;
	@NotBlank(message = "Campo cidade é obrigatório.")
	@Size(max = 100, message = "Este campo aceita no máximo 100 caracteres")
	private String	cidade;
	@NotBlank(message = "Campo estado é obrigatório.")
	@Size(max = 2, message = "Este campo aceita no máximo 2 caracteres")
	private String	estado;
	@NotNull(message = "Informe o campo ativo")
	private Boolean	ativo;

	public FormClienteViewModel() {
		this.dataCadastro = new Date();
		this.ativo = Boolean.TRUE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = Util.extractDigitsFromString(cpf);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		if (id == null)
			this.dataCadastro = new Date();
		else
			this.dataCadastro = dataCadastro;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		if (id == null)
			this.ativo = Boolean.TRUE;
		else
			this.ativo = ativo;
	}
}
