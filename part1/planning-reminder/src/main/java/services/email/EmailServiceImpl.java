package services.email;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailServiceImpl implements EmailService {

	public EmailServiceImpl() {
		super();
	}

	public boolean send(EmailDTO emailDTO) {
		try {
			HtmlEmail email = new HtmlEmail();
			Configurations configs = new Configurations();
			Configuration config = configs.properties(new File("application.properties"));

			email.setDebug(Boolean.TRUE);

			email.setHostName(config.getString("mail.host"));

			email.setSmtpPort(config.getInt("mail.port"));

			email.setSubject(emailDTO.getSubject());

			email.setFrom(emailDTO.getFromAddress(), emailDTO.getFromName());

			email.addTo(emailDTO.getToAddress());

			email.setHtmlMsg(emailDTO.getMessage());

			email.send();

			return true;
		} catch (EmailException e) {
			System.err.println(e);
			return false;
		} catch (ConfigurationException e) {
			System.err.println(e);
			return false;
		}
	}

}
