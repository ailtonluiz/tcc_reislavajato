package br.com.reislavajato.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.reislavajato.enumeradores.EnumCor;
import br.com.reislavajato.enumeradores.EnumMarca;
import br.com.reislavajato.enumeradores.EnumTipoVeiculo;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@Entity
public class Veiculo extends GenericEntity {
	private static final long serialVersionUID = 4996325251017697447L;

	@Enumerated(EnumType.STRING)
	private EnumTipoVeiculo tipoVeiculo = EnumTipoVeiculo.AUTOMOVEL;

	@Enumerated(EnumType.STRING)
	private EnumMarca marca = EnumMarca.FIAT;

	private String modelo;

	private String placa;

	private Long km;

	@Enumerated(EnumType.STRING)
	private EnumCor cor = EnumCor.VERMELHO;

	// getters and setters

	public EnumTipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(EnumTipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public EnumMarca getMarca() {
		return marca;
	}

	public void setMarca(EnumMarca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
	}

	public EnumCor getCor() {
		return cor;
	}

	public void setCor(EnumCor cor) {
		this.cor = cor;
	}

}
