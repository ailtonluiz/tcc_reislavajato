/**
 * 
 */
package br.com.reislavajato.enumeradores;

/**
 * @Criado por: ailtonluiz
 * @Data: 25 de abr de 2018
 */
public enum EnumStatusFinanceiro implements Enumerador {
	ABERTO("1", "Aberto"), 
	BAIXADO("2", "Baixado"); 
	

	private final String abreviado;
	private final String descricao;

	private EnumStatusFinanceiro(String abreviado, String descricao) {
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
