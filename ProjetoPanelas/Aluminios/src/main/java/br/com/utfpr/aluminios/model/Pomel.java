package br.com.utfpr.aluminios.model;

public class Pomel extends BaseEntity {
	private String descricao;
	private String material;

	public Pomel() {
		
	}
	
	public Pomel(String descricao, String material) {
		super();
		this.descricao = descricao;
		this.material = material;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Pomel [descricao=" + descricao + ", material=" + material + "]";
	}

}
