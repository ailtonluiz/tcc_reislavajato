package br.com.reislavajato.util;

public class Numero {

	private static Numero numero = new Numero();

	public Numero() {
		numero = this;
	}

	public static Numero getInstance() {
		if (numero == null) {
			numero = new Numero();
		}
		return numero;
	}

	/**
	 * Remove a formatação do CNPJ
	 * 
	 * @param cnpj
	 *            CNPJ formatado
	 * @return CNPJ sem formatação
	 */
	public static String removerFormatoCNPJ(String cnpj) {
		return cnpj.trim().replaceAll("(\\.|\\-|/)+", "");
	}

	/**
	 * Remove a formatação do CPF
	 * 
	 * @param cpf
	 *            CPF formatado
	 * @return CPF sem formatação
	 */
	public static String removerFormatoCPF(String cpf) {
		return cpf.trim().replaceAll("(\\.|\\-)+", "");
	}

	/**
	 * Remove a formatação do CEP - Código de Endereçamento Postal
	 * 
	 * @param cep
	 *            CEP formatado
	 * @return CEP sem formatação
	 */
	public static String removerFormatoCEP(String cep) {
		return cep.trim().replaceAll("(\\.|\\-)+", "");
	}

	/**
	 * Remover o formatação do telefone
	 * 
	 * @param fone
	 *            Número do telefone formatado
	 * @return Número telefone sem formatação
	 */
	public static String removerFormatoFone(String fone) {
		return fone.trim().replaceAll("(\\(|\\)|\\-)+", "");
	}

	/**
	 * Formata valores em CNPJ
	 * 
	 * @param Numero
	 *            CNPJ a ser formatado
	 * @return
	 */
	static public String formatarCnpj(String numero) {
		return getInstance().FormatarCNPJ(numero);
	}

	/**
	 * Formata valores em CNPJ
	 * 
	 * @param Numero
	 *            CNPJ a ser formatado
	 * @deprecated utilize formatarCnpj(String numero)
	 */
	public String FormatarCNPJ(String Numero) {
		String AuxCNPJ = Numero.trim();
		while (AuxCNPJ.length() < 14)
			AuxCNPJ = "0" + AuxCNPJ;
		AuxCNPJ = AuxCNPJ.substring(0, 2) + "." + AuxCNPJ.substring(2, 5) + "." + AuxCNPJ.substring(5, 8) + "/"
				+ AuxCNPJ.substring(8, 12) + "-" + AuxCNPJ.substring(12, 14);
		return AuxCNPJ;
	}

	/**
	 * Formata valores de CPF
	 * 
	 * @param Numero
	 *            CPF a ser formatado
	 */
	static public String formatarCpf(String numero) {
		return getInstance().FormatarCPF(numero);
	}

	/**
	 * Formata valores de CPF
	 * 
	 * @param Numero
	 *            CPF a ser formatado
	 * @deprecated utilize o método formatarCpf(String numero)
	 */
	public String FormatarCPF(String Numero) {
		String AuxCPF = Numero.trim();
		while (AuxCPF.length() < 11)
			AuxCPF = "0" + AuxCPF;
		AuxCPF = AuxCPF.substring(0, 3) + "." + AuxCPF.substring(3, 6) + "." + AuxCPF.substring(6, 9) + "-"
				+ AuxCPF.substring(9, 11);
		return AuxCPF;
	}

}