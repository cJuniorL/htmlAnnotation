package vo;

import annotations.Html;

@Html
public class ClienteVO extends PessoaVO{
	
	private String cpf;
	
	private String email;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
