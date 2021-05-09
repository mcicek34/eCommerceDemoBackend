package eCommerceBackend.business.abstracts;

import eCommerceBackend.entities.concretes.User;

public interface UserService {
	
	void register(User user);
    void login(User user);
}
