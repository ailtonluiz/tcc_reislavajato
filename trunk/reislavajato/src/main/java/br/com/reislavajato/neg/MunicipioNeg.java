package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.enumeradores.EnumUf;
import br.com.reislavajato.excessao.DadosInvalidosException;

public interface MunicipioNeg extends Negocio<Municipio> {

	List<Municipio> listarPorUf(EnumUf uf) throws DadosInvalidosException;
	
	List<Municipio> listarPorNome(String nome) throws DadosInvalidosException;
	
	List<Municipio> listarPorNomeeUF(String nome, EnumUf uf) throws DadosInvalidosException;

}
