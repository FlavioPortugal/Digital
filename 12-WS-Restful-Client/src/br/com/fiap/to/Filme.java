package br.com.fiap.to;

public class Filme {

	private int codigo;
	
	private String nome;
	
	private float duracao;
	
	private boolean cartaz;
	
	public Filme() {
		super();
	}

	public Filme(int codigo, String nome, float duracao, boolean cartaz) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
		this.cartaz = cartaz;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public boolean isCartaz() {
		return cartaz;
	}

	public void setCartaz(boolean cartaz) {
		this.cartaz = cartaz;
	}
	
}