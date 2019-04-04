package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	
	private String nome;
	private String senha;
	private String mensagem;
	
	public void validarLogin() {
		if(nome.equals("FIAP") && senha.equals("FIAP2019")) {
			System.out.println("Logado");
			mensagem = "Logado com sucesso!";
		}
		else {
			System.out.println("Login ou senha inválidos!");
			mensagem= "Usuário e/ou senha inválidos";
		}
	}
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
