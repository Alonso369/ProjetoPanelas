package br.com.sistran.aluminios.model;

public class Tampa extends BaseEntity {
	private String descricao;
	private Pomel pomel;
	private Disco disco;

	public Tampa() {
		
	}
	
	public Tampa(String descricao, Pomel pomel, Disco disco) {
		super();
		this.descricao = descricao;
		this.pomel = pomel;
		this.disco = disco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pomel getPomel() {
		return pomel;
	}

	public void setPomel(Pomel pomel) {
		this.pomel = pomel;
	}

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	@Override
	public String toString() {
		return "Tampa [descricao=" + descricao + ", pomel=" + pomel + ", disco=" + disco + "]";
	}

}
