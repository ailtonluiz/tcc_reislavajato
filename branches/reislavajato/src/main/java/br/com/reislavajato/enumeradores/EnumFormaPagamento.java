package br.com.reislavajato.enumeradores;

public enum EnumFormaPagamento implements Enumerador {

	DINHEIRO("01", "Dinheiro"), CARTAO_DEBITO("02", "Cartão de Débito"), CARTAO_CREITO("03", "Cartão de Crédito");

	private final String abreviado;
	private final String descricao;

	private EnumFormaPagamento(String abreviado, String descricao) {
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
