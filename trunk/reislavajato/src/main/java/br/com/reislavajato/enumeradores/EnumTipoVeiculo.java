package br.com.reislavajato.enumeradores;

public enum EnumTipoVeiculo implements Enumerador {

	MOTOCICLETA("01", "Motocicleta"), 
	AUTOMOVEL("02", "Automóvel"), 
	MICROONIBUS("03", "Microônibus"), 
	ONIBUS("04", "Ônibus");

	private final String abreviado;
	private final String descricao;

	private EnumTipoVeiculo(String abreviado, String descricao) {
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
