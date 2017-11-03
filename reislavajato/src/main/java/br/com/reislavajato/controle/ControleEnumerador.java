package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.reislavajato.enumeradores.EnumSexo;
import br.com.reislavajato.enumeradores.EnumSimNao;
import br.com.reislavajato.enumeradores.EnumUf;

@ManagedBean(name = "ControleEnumerador")
@ViewScoped
public class ControleEnumerador implements Serializable {
	private static final long serialVersionUID = 644427377876725108L;

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

	public List<EnumUf> getListaEnumUf() {
		List<EnumUf> retorno = new ArrayList<EnumUf>();
		for (EnumUf enumerador : EnumUf.values()) {
			retorno.add(enumerador);
		}
		return retorno;
	}

}