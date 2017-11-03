package br.com.reislavajato.entidade;

import javax.persistence.Entity;

@Entity
public class Telefone extends GenericEntity {
	private static final long serialVersionUID = 1L;
	
	private String celular;
	private String fixo;
	private String comercial;

	private String contato;

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
