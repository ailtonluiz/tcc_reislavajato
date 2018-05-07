package br.com.reislavajato.enumeradores;

public enum EnumStatusServico implements Enumerador {

	PARADO("0%", "Parado"), 
	EXECUCAO("50%", "Em execução"), 
	FINALIZADO("100%", "Finalizado");

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