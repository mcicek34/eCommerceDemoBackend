package eCommerceBackend.core.concretes;

import eCommerceBackend.core.abstracts.EmailVerification;

public class EmailManager implements EmailVerification{

	@Override
	public void sendMail() {
		System.out.println("Do�ruulama maili hesab�nza g�nderildi ");
	}

}
