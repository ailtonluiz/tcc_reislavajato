package br.com.reislavajato.enumeradores;

public enum EnumOrgaoRG implements Enumerador {

	PC("PC", "Polícia Cívil"), SSP("SSP", "Secretaria da Segurança Pública"), SPTC("SPTC",
			"Superintendência da Polícia Técnico-Científica"), DGPC("DGPC", "Diretoria Geral da Polícia Civil");

	private final String abreviado;
	private final String descricao;

	private EnumOrgaoRG(String abreviado, String descricao) {
		this.abreviado = abreviado;
		this.descricao = descricao;
		EnumUtilities.setEnumName(this, this.abreviado);
	}

	public String getAbreviado() {
		return abreviado;
	}

	public String getDescricao() {
		return descricao;
	}
}
