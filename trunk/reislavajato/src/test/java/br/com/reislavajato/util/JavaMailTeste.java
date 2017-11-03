/**
 * 
 */
package br.com.reislavajato.util;

/**
 * @Criado por: Ruben
 * @Data: 5 de set de 2017
 */
import org.junit.Test;

public class JavaMailTeste {

	@Test
	public void testarEmail() {
		JavaMail mail = new JavaMail();

		try {
			mail.javaMail("nathyalmeidagyn@gmail.com", "rubendelmondes@bol.com.br", "Lavajato Reis",
					"Seu carro está pronto!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
