package br.com.reislavajato.enumeradores;

public enum EnumTipoVeiculo implements Enumerador {

	MOTOCICLETA("01", "Motocicleta"), 
	AUTOMOVEL("02", "Automóvel"), 
	MICROONIBUS("03", "Microônibus"), 
	ONIBUS("04", "Ônibus"),
	CAMINHAO("05","Caminhão"),
	AMBULANCIA("06","Ambulância"),
	Bicicleta("07","Bicicleta");
	

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
