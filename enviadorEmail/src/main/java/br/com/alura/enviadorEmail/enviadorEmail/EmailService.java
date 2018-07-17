package br.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String emailDestinatario) {
		try {
				Email email = new SimpleEmail();
				//Host do email que será enviado
				email.setHostName("smtp.googlemail.com");
				//Porta do serviço de email escolhido
				email.setSmtpPort(465);
				//Credenciais de quem vai enviar o email
				email.setAuthenticator(new DefaultAuthenticator("seuemail@gmail.com", "suasenha"));
				email.setSSLOnConnect(true);
				//Email responsavel por enviar os emails
				email.setFrom("seuemail@gmail.com");
				email.setSubject("Olá! Você foi convidado para a ListaVip");
				email.setMsg("Olá " + nome + ". Você acaba de ser convidado para a <h1>ListaVip!</h1>");
				email.addTo(emailDestinatario);
				email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
