package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import br.com.reislavajato.enumeradores.EnumCategoriaCNH;
import br.com.reislavajato.enumeradores.EnumCor;
import br.com.reislavajato.enumeradores.EnumEscolaridade;
import br.com.reislavajato.enumeradores.EnumEstadoCivil;
import br.com.reislavajato.enumeradores.EnumFatorRH;
import br.com.reislavajato.enumeradores.EnumFormaPagamento;
import br.com.reislavajato.enumeradores.EnumMarca;
import br.com.reislavajato.enumeradores.EnumOrgaoRG;
import br.com.reislavajato.enumeradores.EnumPerfil;
import br.com.reislavajato.enumeradores.EnumSexo;
import br.com.reislavajato.enumeradores.EnumSimNao;
import br.com.reislavajato.enumeradores.EnumStatusFinanceiro;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.enumeradores.EnumTipoFinanceiro;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.enumeradores.EnumTipoSanguineo;
import br.com.reislavajato.enumeradores.EnumTipoVeiculo;
import br.com.reislavajato.enumeradores.EnumUf;

@Controller("ControleEnumerador")
public class ControleEnumerador implements Serializable {
	private static final long serialVersionUID = 644427377876725108L;

	public List<EnumEscolaridade> getListaEnumEscolaridade() {
		List<EnumEscolaridade> retorno = new ArrayList<EnumEscolaridade>();
		for (EnumEscolaridade enumerador : EnumEscolaridade.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumEstadoCivil> getListaEnumEstadoCivil() {
		List<EnumEstadoCivil> retorno = new ArrayList<EnumEstadoCivil>();
		for (EnumEstadoCivil enumerador : EnumEstadoCivil.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumSexo> getListaEnumSexo() {
		List<EnumSexo> retorno = new ArrayList<EnumSexo>();
		for (EnumSexo enumerador : EnumSexo.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumSimNao> getListaEnumSimNao() {
		List<EnumSimNao> retorno = new ArrayList<EnumSimNao>();
		for (EnumSimNao enumerador : EnumSimNao.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumTipoPessoa> getListaEnumTipoPessoa() {
		List<EnumTipoPessoa> retorno = new ArrayList<EnumTipoPessoa>();
		for (EnumTipoPessoa enumerador : EnumTipoPessoa.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumUf> getListaEnumUf() {
		List<EnumUf> retorno = new ArrayList<EnumUf>();
		for (EnumUf enumerador : EnumUf.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumOrgaoRG> getListaEnumOrgaoRG() {
		List<EnumOrgaoRG> retorno = new ArrayList<EnumOrgaoRG>();
		for (EnumOrgaoRG enumerador : EnumOrgaoRG.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumCategoriaCNH> getListaEnumCategoriaCNH() {
		List<EnumCategoriaCNH> retorno = new ArrayList<EnumCategoriaCNH>();
		for (EnumCategoriaCNH enumerador : EnumCategoriaCNH.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumFatorRH> getListaEnumFatorRH() {
		List<EnumFatorRH> retorno = new ArrayList<EnumFatorRH>();
		for (EnumFatorRH enumerador : EnumFatorRH.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumPerfil> getListaEnumPerfil() {
		List<EnumPerfil> retorno = new ArrayList<EnumPerfil>();
		for (EnumPerfil enumerador : EnumPerfil.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumTipoSanguineo> getListaEnumTipoSanguineo() {
		List<EnumTipoSanguineo> retorno = new ArrayList<EnumTipoSanguineo>();
		for (EnumTipoSanguineo enumerador : EnumTipoSanguineo.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumMarca> getListaEnumMarca() {
		List<EnumMarca> retorno = new ArrayList<EnumMarca>();
		for (EnumMarca enumerador : EnumMarca.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumCor> getListaEnumCor() {
		List<EnumCor> retorno = new ArrayList<EnumCor>();
		for (EnumCor enumerador : EnumCor.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumStatusServico> getListaEnumStatusServico() {
		List<EnumStatusServico> retorno = new ArrayList<EnumStatusServico>();
		for (EnumStatusServico enumerador : EnumStatusServico.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumTipoVeiculo> getListaEnumTipoVeiculo() {
		List<EnumTipoVeiculo> retorno = new ArrayList<EnumTipoVeiculo>();
		for (EnumTipoVeiculo enumerador : EnumTipoVeiculo.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumFormaPagamento> getListaEnumFormaPagamento() {
		List<EnumFormaPagamento> retorno = new ArrayList<EnumFormaPagamento>();
		for (EnumFormaPagamento enumerador : EnumFormaPagamento.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumStatusFinanceiro> getListaEnumStatusFinanceiro() {
		List<EnumStatusFinanceiro> retorno = new ArrayList<EnumStatusFinanceiro>();
		for (EnumStatusFinanceiro enumerador : EnumStatusFinanceiro.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

	public List<EnumTipoFinanceiro> getListaEnumTipoFinanceiro() {
		List<EnumTipoFinanceiro> retorno = new ArrayList<EnumTipoFinanceiro>();
		for (EnumTipoFinanceiro enumerador : EnumTipoFinanceiro.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}
}
