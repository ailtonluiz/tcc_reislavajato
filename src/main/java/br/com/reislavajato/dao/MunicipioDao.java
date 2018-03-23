/**
 * 
 */
package br.com.reislavajato.dao;

import java.util.List;

import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.enumeradores.EnumUf;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface MunicipioDao extends Persistencia<Municipio> {

	List<Municipio> listarPorUf(EnumUf uf) throws DadosInvalidosException;

	List<Municipio> listarPorNome(String nome) throws DadosInvalidosException;

	List<Municipio> listarPorNomeeUF(String nome, EnumUf uf) throws DadosInvalidosException;

}
