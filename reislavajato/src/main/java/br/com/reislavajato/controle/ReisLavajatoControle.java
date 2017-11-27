package br.com.reislavajato.controle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class ReisLavajatoControle {
	protected final String msgIncluidoSucesso = "Inclusão realizada com Sucesso!";
	protected final String msgAlteradoSucesso = "Alteração realizada com sucesso!";
	protected final String msgExcluidoSucesso = "Exclusão realizada com Sucesso!";
	protected final String msgErro = "Ocorreu um erro";

	protected abstract String novo();

	protected void addMensagemInfo(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
	}

	protected void addMensagemAviso(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, ""));
	}

	protected void addMensagemErro(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
	}

	protected void addMensagemErroFatal(Throwable e) {
		e.printStackTrace();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
				"Erro inesperado no sistema! Contacte o analista.", ""));
	}
}
