package br.com.sistran.aluminios.model;

public class Panela extends BaseEntity{
	private String descricao;
	private Disco disco;
	private Alca alca;
	private Tampa tampa;
	private double preco;
	
	public Panela() {
		
	}
	
	public Panela(String descricao, Disco disco, Alca alca, Tampa tampa, double preco) {
		super();
		this.descricao = descricao;
		this.disco = disco;
		this.alca = alca;
		this.tampa = tampa;
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Disco getDisco() {
		return disco;
	}
	public void setDisco(Disco disco) {
		this.disco = disco;
	}
	public Alca getAlca() {
		return alca;
	}
	public void setAlca(Alca alca) {
		this.alca = alca;
	}
	public Tampa getTampa() {
		return tampa;
	}
	public void setTampa(Tampa tampa) {
		this.tampa = tampa;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Panela [descricao=" + descricao + ", disco=" + disco + ", alca=" + alca + ", tampa=" + tampa
				+ ", preco=" + preco + "]";
	}
	
	
}
