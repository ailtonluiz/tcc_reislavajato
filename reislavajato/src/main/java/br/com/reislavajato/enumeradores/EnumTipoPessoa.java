package br.com.reislavajato.enumeradores;

public enum EnumTipoPessoa implements Enumerador {

	PF("PF", "Pessoa Física"), 
	PJ("PJ", "Pessoa Jurídica");

	private final String abreviado;
	private final String descricao;

	private EnumTipoPessoa(String abreviado, String descricao) {
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