package br.com.judice.servicos.presentation.viewModels;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class FormClienteResponseViewModel implements Serializable {

	private static final long	serialVersionUID	= -665385555920697417L;

	private Boolean				success;
	private String				message;
	private Map<String, String>	errorList;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Map<String, String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<FieldError> errorList) {

		this.errorList = new HashMap<>();

		for (FieldError error : errorList)
			this.errorList.put(error.getField(), error.getDefaultMessage());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}