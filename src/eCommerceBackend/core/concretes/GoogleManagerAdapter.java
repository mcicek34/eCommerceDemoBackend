package eCommerceBackend.core.concretes;

import eCommerceBackend.core.abstracts.GoogleService;
import eCommerceBackend.googleLogin.GoogleLoginManager;

public class GoogleManagerAdapter implements GoogleService {

	@Override
	public void registerToGoogle(String message) {
		GoogleLoginManager loginManager = new GoogleLoginManager();
		loginManager.register(message);
	}

}
