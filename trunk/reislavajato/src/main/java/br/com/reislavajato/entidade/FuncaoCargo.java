package br.com.reislavajato.entidade;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class FuncaoCargo extends GenericEntity {

	private String funcao;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
