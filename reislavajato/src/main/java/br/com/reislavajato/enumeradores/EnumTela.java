package br.com.reislavajato.enumeradores;

import br.com.reislavajato.enumeradores.EnumUtilities;
import br.com.reislavajato.enumeradores.Enumerador;

public enum EnumTela implements Enumerador {

	INCLUIR("01", "Incluir"), 
	ALTERAR("02", "Alterar"), 
	CONSULTAR("03", "Consultar"),
	ORDEM_SERVICO("04","Ordem de Servico");

	private final String abreviado;
	private final String descricao;

	private EnumTela(String abreviado, String descricao) {
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