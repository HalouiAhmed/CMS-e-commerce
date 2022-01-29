package effyis.partners.socle.content.outils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Outils {

	private final Random random = new SecureRandom();
	private final String alphabet = "123456789ABCDEFJHIGKLMNOPQRSTUVWXYSabcdefjhijklmnopqrstuvwyz";

	public String generateUserId(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			returnValue.append(this.alphabet.charAt(this.random.nextInt(length)));
		}
		return new String(returnValue);
	}

}
