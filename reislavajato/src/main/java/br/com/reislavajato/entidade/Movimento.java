/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import br.com.reislavajato.enumeradores.EnumFormaPagamento;
import br.com.reislavajato.enumeradores.EnumStatusServico;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Movimento extends GenericEntity {

	@OneToOne // carro - servico
	private Cliente cliente = new Cliente();

	@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Funcionario> funcionarios = new HashSet<Funcionario>();

	@Enumerated(EnumType.STRING)
	private EnumFormaPagamento formaPagamento = EnumFormaPagamento.DINHEIRO;

	@Enumerated(EnumType.STRING)
	private EnumStatusServico statusServico = EnumStatusServico.PARADO;

	@Column(nullable = false)
	private Long numeroOrdemServico;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_total")
	private BigDecimal valorTotal;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnumStatusServico getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(EnumStatusServico statusServico) {
		this.statusServico = statusServico;
	}

	public Long getNumeroOrdemServico() {
		return numeroOrdemServico;
	}

	public void setNumeroOrdemServico(Long numeroOrdemServico) {
		this.numeroOrdemServico = numeroOrdemServico;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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
