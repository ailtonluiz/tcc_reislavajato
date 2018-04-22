package br.com.reislavajato.enumeradores;

public enum EnumCor implements Enumerador {

	PRATA("01", "Prata"), PRETO("02", "Preto"), CINZA("03", "Cinza"), BRANCO("04", "Branco"), VERMELHO("05",
			"Vermelho"), AZUL("06", "Azul"), VERDE("07", "Verde"), AMARELO("08", "Amarelo"), OUTROS("09","Outros");

	private final String abreviado;
	private final String descricao;

	private EnumCor(String abreviado, String descricao) {
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