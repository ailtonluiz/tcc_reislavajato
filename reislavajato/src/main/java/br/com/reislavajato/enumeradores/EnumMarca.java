package br.com.reislavajato.enumeradores;

public enum EnumMarca implements Enumerador {

	CITROEN("", "Citroën"), 
	GM("", "Chevrolet"), 
	FIAT("", "Fiat"), 
	FORD("", "Ford"), 
	HONDA("", "Honda"), 
	MERCEDES_BENZ("", "Mercedes-Benz"),
	NISSAN("", "Nissan"), 
	PEUGEOT("", "Peugeot"), 
	RENAULT("", "Renault"), 
	TOYOTA("", "Toyota"), 
	VOLARE("", "Volare"),
	VOLKSWAGEM("", "VolksWagem");

	private final String abreviado;
	private final String descricao;

	private EnumMarca(String abreviado, String descricao) {
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