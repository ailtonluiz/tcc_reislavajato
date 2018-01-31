/**
 * 
 */
package br.com.reislavajato.converter;

/**
 * @Criado por: telmo
 * @Data: 31 de jan de 2018
 */
import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Efetua a validação de um valor monetário.
 */
@FacesValidator("MoedaValidator")
public class MoedaValidator implements Validator {
	/**
	 * Método responsável por validar os campos com moeda. Caso ocorra algum erro
	 * lança uma ValidatorException.
	 */
	public void validate(FacesContext ctx, UIComponent comp, Object val) throws ValidatorException {
		try {
			BigDecimal valor = (BigDecimal) val;
			if (val == null)
				return;
			if (valor.intValue() == 0) {
				FacesMessage message = new FacesMessage("Preencha com o valor válido maior que zero");
				throw new ValidatorException(message);
			}
		} catch (ValidatorException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
}