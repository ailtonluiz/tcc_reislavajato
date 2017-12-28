package br.com.reislavajato.enumeradores;

public enum EnumMarca implements Enumerador {

	 CITROEN("1","Citroën"),
	 GM("2","Chevrolet"),
	 FIAT("3","Fiat"),
	 FORD("4","Ford"),
	 HONDA("5","Honda"),
	 NISSAN("6","Nissan"),
	 PEUGEOT("7","Peugeot"),
	 RENAULT("8","Renault"),
	 TOYOTA("9","Toyota"),
	 VOLKSWAGEM("10","VolksWagem");

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