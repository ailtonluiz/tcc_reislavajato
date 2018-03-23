package br.com.reislavajato.enumeradores;

public enum EnumUf implements Enumerador {

	AC("AC", "Acre"), AL("AL", "Alagoas"), AP("AP", "Amapá"), AM("AM", "Amazonas"), BA("BA", "Bahia"), CE("CE", "Ceará"), DF("DF", "Distrito Federal"), ES("ES", "Espírito Santo"), GO("GO", "Goiás"), MA("MA", "Maranhão"), MT("MT",
				"Mato Grosso"), MS("MS", "Mato Grosso do Sul"), MG("MG", "Minas Gerais"), PA("PA", "Pará"), PB("PB", "Paraí­ba"), PE("PE", "Pernambuco"), PR("PR", "Paraná"), PI("PI", "Piauí"), RJ("RJ", "Rio De Janeiro"), RN("RN",
							"Rio Grande do Norte"), RS("RS", "Rio Grande do Sul"), RO("RO", "Rondônia"), RR("RR", "Roraima"), SC("SC", "Santa Catarina"), SE("SE", "Sergipe"), SP("SP", "São Paulo"), TO("TO", "Tocantins");

	private String abreviado;
	private String descricao;

	private EnumUf(String abreviado, String descricao) {
		this.abreviado = abreviado;
		this.descricao = descricao;
		EnumUtilities.setEnumName(this, this.descricao);
	}

	public String getAbreviado() {
		return abreviado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setAbreviado(String abreviado) {
		this.abreviado = abreviado;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}