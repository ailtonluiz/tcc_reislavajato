package br.com.reislavajato.excessao;

public class DadosInvalidosException extends Exception {
	private static final long serialVersionUID = -2849527354265573263L;

	public DadosInvalidosException() {
		super("Erro ao alterar o registro");
	}

	public DadosInvalidosException(String mensagem) {
		super(mensagem);
	}

	public DadosInvalidosException(Exception e) {
		super(e.getMessage());
	}

}
