package br.com.sistran.aluminios.model;

public class Disco extends BaseEntity {

	private String descricao;
	private double tamanho;
	private double espessura;

	public Disco(String descricao, double tamanho, double espessura) {
		super();
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.espessura = espessura;
	}

	public Disco() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public double getEspessura() {
		return espessura;
	}

	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}

	@Override
	public String toString() {
		return "Disco [descricao=" + descricao + ", tamanho=" + tamanho + ", espessura=" + espessura + "]";
	}

}
