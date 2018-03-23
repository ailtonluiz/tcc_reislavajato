package br.com.reislavajato.enumeradores;

public enum EnumSexo implements Enumerador {

	MASCULINO("M", "Masculino"), FEMININO("F", "Feminino");

	private final String abreviado;
	private final String descricao;

	private EnumSexo(String abreviado, String descricao) {
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
