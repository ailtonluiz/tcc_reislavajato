package br.com.reislavajato.enumeradores;

public enum EnumStatusServico implements Enumerador {

	PARADO("01", "Parado"), EXECUCAO("02", "Em execução"), FINALIZADO("05", "Finalizado");

	private final String abreviado;
	private final String descricao;

	private EnumStatusServico(String abreviado, String descricao) {
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