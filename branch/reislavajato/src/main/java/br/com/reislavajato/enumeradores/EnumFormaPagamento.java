package br.com.reislavajato.enumeradores;

public enum EnumFormaPagamento implements Enumerador {

	DINHEIRO("01", "Dinheiro"), 
	CARTAO_DEBITO("02", "Cartão de Débito"), 
	CARTAO_CREDITO("03", "Cartão de Crédito"),
	PIC_PAY("04", "Pic Pay"),
	DUPLICATA("05","Duplicata Mercantil");

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
