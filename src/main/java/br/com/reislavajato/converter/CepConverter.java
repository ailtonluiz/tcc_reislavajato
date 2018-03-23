package br.com.reislavajato.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.reislavajato.util.Numero;

@FacesConverter(value = "cepConverter")
public class CepConverter implements Converter {
	public Object getAsObject(FacesContext ctx, UIComponent component, String valor) {
		if (valor == null || valor.trim().length() == 0) {
			return 0L;
		} else {
			return Long.parseLong(Numero.removerFormatoCEP(valor.trim()));
		}
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object valor) {
		if (valor == null) {
			return "";
		} else {
			String cepStr = Numero.removerFormatoCEP(valor.toString().trim());

			if (cepStr.length() == 0) {
				return "";
			}

			if (Long.parseLong(cepStr) == 0) {
				return "";
			}

			return Numero.removerFormatoCEP(valor.toString().trim());
		}
	}
}
