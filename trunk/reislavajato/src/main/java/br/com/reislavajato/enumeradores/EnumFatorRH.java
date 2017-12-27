package br.com.reislavajato.enumeradores;

public enum EnumFatorRH implements Enumerador {

	POSITIVO("+", "Positivo"), 
	NEGATIVO("-", "Negativo");

	private final String abreviado;
	private final String descricao;

	private EnumFatorRH(String abreviado, String descricao) {
		this.abreviado = abreviado;
		this.descricao = descricao;
		EnumUtilities.setEnumName(this, this.descricao);
	}

	public String getAbreviado() {
		return abreviado;
	}

	public String getDescricao() {
		return descricao;
	}

}