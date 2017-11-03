package br.com.reislavajato.enumeradores;

public enum EnumEstadoCivil implements Enumerador {

	CASADO("C", "Casado(a)"), 
	SOLTEIRO("S", "Solteiro(a)"), 
	VIUVO("V", "Viúvo(a)"), 
	DIVORCIADO("D", "Divorciado(a)");

	private final String abreviado;
	private final String descricao;

	private EnumEstadoCivil(String abreviado, String descricao) {
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
