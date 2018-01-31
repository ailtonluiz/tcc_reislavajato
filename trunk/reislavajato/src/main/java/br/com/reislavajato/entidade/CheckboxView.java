/**
 * 
 */
package br.com.reislavajato.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 * @Criado por: ailto
 * @Data: 14 de jan de 2018
 */
@ManagedBean
public class CheckboxView {

	private String[] selecaoChecklist;
	private List<String> checklist;

	@PostConstruct
	public void init() {
		checklist = new ArrayList<String>();
		checklist.add("Alarme");
		checklist.add("Chave");
		checklist.add("Macaco");
		checklist.add("Triângulo");
		checklist.add("Estepe");
		checklist.add("Extintor");
		checklist.add("Tapetes");

	}

	public String[] getSelecaoChecklist() {
		return selecaoChecklist;
	}

	public void setSelecaoChecklist(String[] selecaoChecklist) {
		this.selecaoChecklist = selecaoChecklist;
	}

	public List<String> getChecklist() {
		return checklist;
	}

	public void setChecklist(List<String> checklist) {
		this.checklist = checklist;
	}

}
