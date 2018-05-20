/**
 * 
 */
package br.com.reislavajato.enumeradores;

/**
 * @Criado por: ailtonluiz
 * @Data: 25 de abr de 2018
 */
public enum EnumTipoFinanceiro implements Enumerador {

	 CR("CR", "Conta a receber");

	private final String abreviado;
	private final String descricao;

	private EnumTipoFinanceiro(String abreviado, String descricao) {
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
