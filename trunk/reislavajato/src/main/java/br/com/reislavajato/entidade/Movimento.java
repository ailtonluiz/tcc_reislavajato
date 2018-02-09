/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.reislavajato.enumeradores.EnumFormaPagamento;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@Entity
public class Movimento extends GenericEntity {
	private static final long serialVersionUID = 9006423828322160519L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private OrdemServico ordemServico = new OrdemServico();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@Enumerated(EnumType.STRING)
	private EnumFormaPagamento formaPagamento = EnumFormaPagamento.DINHEIRO;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_total")
	private BigDecimal valorTotal;

	@Column(precision = 10, scale = 2)
	private BigDecimal descontoServico;

	private String observacao;

	// CheckList
	private Boolean possuiAlarme;

	private Boolean possuiProtecaoVeicular;

	private Boolean deixouChave;

	private Boolean possuiMacaco;

	private Boolean possuiTriangulo;

	private Boolean possuiEstepe;

	private Boolean possuiExtintor;

	private Boolean possuiTapetes;

	// getters and setters

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getDescontoServico() {
		return descontoServico;
	}

	public void setDescontoServico(BigDecimal descontoServico) {
		this.descontoServico = descontoServico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getPossuiAlarme() {
		return possuiAlarme;
	}

	public void setPossuiAlarme(Boolean possuiAlarme) {
		this.possuiAlarme = possuiAlarme;
	}

	public Boolean getPossuiProtecaoVeicular() {
		return possuiProtecaoVeicular;
	}

	public void setPossuiProtecaoVeicular(Boolean possuiProtecaoVeicular) {
		this.possuiProtecaoVeicular = possuiProtecaoVeicular;
	}

	public Boolean getDeixouChave() {
		return deixouChave;
	}

	public void setDeixouChave(Boolean deixouChave) {
		this.deixouChave = deixouChave;
	}

	public Boolean getPossuiMacaco() {
		return possuiMacaco;
	}

	public void setPossuiMacaco(Boolean possuiMacaco) {
		this.possuiMacaco = possuiMacaco;
	}

	public Boolean getPossuiTriangulo() {
		return possuiTriangulo;
	}

	public void setPossuiTriangulo(Boolean possuiTriangulo) {
		this.possuiTriangulo = possuiTriangulo;
	}

	public Boolean getPossuiEstepe() {
		return possuiEstepe;
	}

	public void setPossuiEstepe(Boolean possuiEstepe) {
		this.possuiEstepe = possuiEstepe;
	}

	public Boolean getPossuiExtintor() {
		return possuiExtintor;
	}

	public void setPossuiExtintor(Boolean possuiExtintor) {
		this.possuiExtintor = possuiExtintor;
	}

	public Boolean getPossuiTapetes() {
		return possuiTapetes;
	}

	public void setPossuiTapetes(Boolean possuiTapetes) {
		this.possuiTapetes = possuiTapetes;
	}

}
