package br.com.reislavajato.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.reislavajato.util.Numero;

@FacesConverter(value = "cpfConverter")
public class CpfConverter implements Converter {
	public Object getAsObject(FacesContext ctx, UIComponent component, String valor) {
		if (valor == null || valor.trim().length() == 0) {
			return 0L;
		} else {
			return Long.parseLong(Numero.removerFormatoCPF(valor.trim()));
		}
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object valor) {
		if (valor == null) {
			return "";
		} else {
			String cpfStr = Numero.removerFormatoCPF(valor.toString().trim());

			if (cpfStr.length() == 0) {
				return "";
			}

			if (Long.parseLong(cpfStr) == 0) {
				return "";
			}

			return Numero.formatarCpf(valor.toString().trim());
		}
	}
}
