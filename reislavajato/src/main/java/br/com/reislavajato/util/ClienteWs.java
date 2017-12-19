package br.com.reislavajato.util;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.reislavajato.entidade.Endereco;
import br.com.reislavajato.enumeradores.EnumUf;

/**
 * Classe para recuperar informações do WS do viacep.com.br
 */
public class ClienteWs {
	private static Endereco endereco = null;

	/**
	 * Recupera objeto Endereco pelo CEP
	 * 
	 * @param cep
	 *            String no formato 00000000
	 * @return instancia de br.com.viacep.Endereco
	 */
	public static Endereco getEnderecoPorCep(String cep) {

		JsonObject jsonObject = getCepResponse(cep);

		JsonValue erro = jsonObject.get("erro");

		if (erro == null) {
			endereco = new Endereco();
			endereco.setCep(jsonObject.getString("cep"));
			endereco.setLogradouro(jsonObject.getString("logradouro"));
			endereco.setComplemento(jsonObject.getString("complemento"));
			endereco.setBairro(jsonObject.getString("bairro"));
			endereco.setNumero(jsonObject.getString("unidade"));

			endereco.getMunicipio().setNome(jsonObject.getString("localidade"));
			endereco.getMunicipio().setCodigo(Long.parseLong(jsonObject.getString("ibge")));
			setarUF(jsonObject);
		}
		return endereco;

	}

	private static JsonObject getCepResponse(String cep) {

		JsonObject responseJO = null;

		try {
			if (!ReisLavajatoUtil.validaCep(cep)) {
				throw new RuntimeException("Formato de CEP inválido");
			}

			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/" + cep + "/json");
			HttpResponse response = httpclient.execute(httpGet);

			HttpEntity entity = response.getEntity();

			responseJO = Json.createReader(entity.getContent()).readObject();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return responseJO;
	}

	private static void setarUF(JsonObject jsonObject) {
		switch (jsonObject.getString("uf")) {
		case "AC":
			endereco.getMunicipio().setUf(EnumUf.AC);
			break;
		case "AL":
			endereco.getMunicipio().setUf(EnumUf.AL);
			break;
		case "AM":
			endereco.getMunicipio().setUf(EnumUf.AM);
			break;
		case "AP":
			endereco.getMunicipio().setUf(EnumUf.AP);
			break;
		case "BA":
			endereco.getMunicipio().setUf(EnumUf.BA);
			break;
		case "CE":
			endereco.getMunicipio().setUf(EnumUf.CE);
			break;
		case "DF":
			endereco.getMunicipio().setUf(EnumUf.DF);
			break;
		case "ES":
			endereco.getMunicipio().setUf(EnumUf.ES);
			break;
		case "GO":
			endereco.getMunicipio().setUf(EnumUf.GO);
			break;
		case "MA":
			endereco.getMunicipio().setUf(EnumUf.MA);
			break;
		case "MG":
			endereco.getMunicipio().setUf(EnumUf.MG);
			break;
		case "MS":
			endereco.getMunicipio().setUf(EnumUf.MS);
			break;
		case "MT":
			endereco.getMunicipio().setUf(EnumUf.MT);
			break;
		case "PA":
			endereco.getMunicipio().setUf(EnumUf.PA);
			break;
		case "PB":
			endereco.getMunicipio().setUf(EnumUf.PB);
			break;
		case "PE":
			endereco.getMunicipio().setUf(EnumUf.PE);
			break;
		case "PI":
			endereco.getMunicipio().setUf(EnumUf.PI);
			break;
		case "PR":
			endereco.getMunicipio().setUf(EnumUf.PR);
			break;
		case "RJ":
			endereco.getMunicipio().setUf(EnumUf.RJ);
			break;
		case "RN":
			endereco.getMunicipio().setUf(EnumUf.RN);
			break;
		case "RO":
			endereco.getMunicipio().setUf(EnumUf.RO);
			break;
		case "RR":
			endereco.getMunicipio().setUf(EnumUf.RR);
			break;
		case "RS":
			endereco.getMunicipio().setUf(EnumUf.RS);
			break;
		case "SC":
			endereco.getMunicipio().setUf(EnumUf.SC);
			break;
		case "SP":
			endereco.getMunicipio().setUf(EnumUf.SP);
			break;
		case "TO":
			endereco.getMunicipio().setUf(EnumUf.TO);
			break;
		}
	}
}