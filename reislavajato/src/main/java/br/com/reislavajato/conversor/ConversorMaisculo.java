/**
 * 
 */
package br.com.reislavajato.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @Criado por: ailtonluiz
 * @Data: 10 de set de 2017
 */
@FacesConverter("conversorMaisculo")
public class ConversorMaisculo implements Converter {
	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		if (valor == null) {
			return null;
		} else {
			return valor.toUpperCase();
		}
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object valor) {
		if (valor == null) {
			return "";
		} else {
			return valor.toString();
		}
	}

}
