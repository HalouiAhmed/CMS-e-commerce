package effyis.partners.socle.content.service;

import effyis.partners.socle.content.dto.MailDTO;

import javax.mail.MessagingException;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface MailService {

	void sendMail(MailDTO mail) throws MessagingException;

}
