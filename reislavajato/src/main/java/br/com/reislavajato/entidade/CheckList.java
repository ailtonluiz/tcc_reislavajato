/**
 * 
 */
package br.com.reislavajato.entidade;

import javax.persistence.Entity;

import br.com.reislavajato.enumeradores.EnumSimNao;

/**
 * @Criado por: ailtonluiz
 * @Data: 20 de mar de 2018
 */

@SuppressWarnings("serial")
@Entity(name = "check_list")
public class CheckList extends GenericEntity {

	private EnumSimNao estepe = EnumSimNao.SIM;

	private EnumSimNao alarme = EnumSimNao.SIM;

	private EnumSimNao ferramentas = EnumSimNao.SIM;

	private EnumSimNao triangulo = EnumSimNao.SIM;

	private EnumSimNao extintor = EnumSimNao.SIM;

	private EnumSimNao som = EnumSimNao.SIM;

	private EnumSimNao tapetes = EnumSimNao.SIM;

	private EnumSimNao arranhoes = EnumSimNao.SIM;

	private String observacao;

	// getters and setters

	public EnumSimNao getEstepe() {
		return estepe;
	}

	public void setEstepe(EnumSimNao estepe) {
		this.estepe = estepe;
	}

	public EnumSimNao getAlarme() {
		return alarme;
	}

	public void setAlarme(EnumSimNao alarme) {
		this.alarme = alarme;
	}

	public EnumSimNao getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(EnumSimNao ferramentas) {
		this.ferramentas = ferramentas;
	}

	public EnumSimNao getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(EnumSimNao triangulo) {
		this.triangulo = triangulo;
	}

	public EnumSimNao getExtintor() {
		return extintor;
	}

	public void setExtintor(EnumSimNao extintor) {
		this.extintor = extintor;
	}

	public EnumSimNao getSom() {
		return som;
	}

	public void setSom(EnumSimNao som) {
		this.som = som;
	}

	public EnumSimNao getTapetes() {
		return tapetes;
	}

	public void setTapetes(EnumSimNao tapetes) {
		this.tapetes = tapetes;
	}

	public EnumSimNao getArranhoes() {
		return arranhoes;
	}

	public void setArranhoes(EnumSimNao arranhoes) {
		this.arranhoes = arranhoes;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
