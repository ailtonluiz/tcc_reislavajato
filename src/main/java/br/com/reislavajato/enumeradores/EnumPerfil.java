package br.com.reislavajato.enumeradores;

public enum EnumPerfil implements Enumerador {

	ADMINISTRADOR("0", "Administrador"), CAIXA("1", "Caixa"), LAVADOR("2", "Lavador"), CLIENTE("3", "Cliente");

	private final String abreviado;
	private final String descricao;

	private EnumPerfil(String abreviado, String descricao) {
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