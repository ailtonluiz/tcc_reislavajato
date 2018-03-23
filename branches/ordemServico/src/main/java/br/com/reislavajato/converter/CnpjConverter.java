package br.com.reislavajato.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.reislavajato.util.Numero;

@FacesConverter(value = "cnpjConverter")
public class CnpjConverter implements Converter {
	public Object getAsObject(FacesContext ctx, UIComponent component, String valor) {
		if (valor == null || valor.trim().length() == 0) {
			return 0L;
		} else {
			return Long.parseLong(Numero.removerFormatoCNPJ(valor.trim()));
		}
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object valor) {
		if (valor == null) {
			return "";
		} else {
			String cnpjStr = Numero.removerFormatoCNPJ(valor.toString().trim());

			if (cnpjStr.length() == 0) {
				return "";
			}

			if (Long.parseLong(cnpjStr) == 0) {
				return "";
			}

			return Numero.formatarCnpj(valor.toString().trim());
		}
	}
}
