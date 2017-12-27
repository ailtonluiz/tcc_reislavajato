package br.com.reislavajato.enumeradores;

public enum EnumTipoSanguineo implements Enumerador {

	A("A", "A"), 
	B("B", "B"), 
	AB("AB", "AB"), 
	O("O", "O");

	private final String abreviado;
	private final String descricao;

	private EnumTipoSanguineo(String abreviado, String descricao) {
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
