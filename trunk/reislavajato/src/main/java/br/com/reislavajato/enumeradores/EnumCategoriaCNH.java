package br.com.reislavajato.enumeradores;

public enum EnumCategoriaCNH implements Enumerador {

	A("A", "A"),
	B("B", "B"),
	C("C", "C"),
	D("D", "D"),
	E("E", "E");

	private final String abreviado;
	private final String descricao;

	private EnumCategoriaCNH(String abreviado, String descricao) {
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
