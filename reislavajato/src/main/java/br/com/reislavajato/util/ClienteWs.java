package br.com.reislavajato.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.reislavajato.entidade.Endereco;

/**
 * Classe para recuperar informações do WS do viacep.com.br
 */
public class ClienteWs {

	private static final Set<String> CAMPOS = new HashSet<String>(Arrays.asList("cep", "logradouro", "complemento", "bairro", "unidade"));

	/**
	 * Recupera objeto Endereco pelo CEP
	 * 
	 * @param cep
	 *            String no formato 00000000
	 * @return instancia de br.com.viacep.Endereco
	 */
	public static Endereco getEnderecoPorCep(String cep) {

		JsonObject jsonObject = getCepResponse(cep);
		Endereco endereco = null;

		JsonValue erro = jsonObject.get("erro");

		if (erro == null) {
			endereco = new Endereco();
			endereco.setCep(jsonObject.getString("cep"));
			endereco.setLogradouro(jsonObject.getString("logradouro"));
			endereco.setComplemento(jsonObject.getString("complemento"));
			endereco.setBairro(jsonObject.getString("bairro"));
			endereco.setNumero(jsonObject.getString("unidade"));
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
}