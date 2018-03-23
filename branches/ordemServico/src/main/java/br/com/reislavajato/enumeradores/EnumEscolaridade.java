package br.com.reislavajato.enumeradores;

public enum EnumEscolaridade implements Enumerador {

	PRIMEIRO_GRAU("1º", "Primeiro Grau"), SEGUNDO_GRAU("2º", "Segundo Grau"), GRADUACAO("G", "Graduação"), ESPECIALIZACAO("E", "Especialização"), MESTRADO("M", "Mestrado"), DOUTORADO("D", "Doutorado"), POS_DOUTORADO("P", "Pós Doutorado");

	private final String abreviado;
	private final String descricao;

	private EnumEscolaridade(String abreviado, String descricao) {
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
