package br.com.utfpr.aluminios.model;

public class Alca extends BaseEntity {
	private String descricao;

	public Alca() {
		
	}
	
	public Alca(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Alca [descricao=" + descricao + "]";
	}

}
