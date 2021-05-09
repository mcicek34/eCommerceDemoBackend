package eCommerceBackend;

import eCommerceBackend.business.abstracts.UserService;
import eCommerceBackend.business.concretes.UserManager;
import eCommerceBackend.core.concretes.EmailManager;
import eCommerceBackend.core.concretes.GoogleManagerAdapter;
import eCommerceBackend.dataAccsess.concretes.HibernateUSerDao;
import eCommerceBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Mustafa", "Cicek", "mustafa@cicek.com", "1456987");
		UserService userService = new UserManager(new HibernateUSerDao(), new EmailManager(),
				new GoogleManagerAdapter());

		userService.register(user);
		userService.login(user);

		System.out.println("-------------------------------------------------------");

		//Hatalý Kayýt
		User user2 = new User(2, "De", "y", "deniz@yildirim.com", "78456123");
		UserService userService2 = new UserManager(new HibernateUSerDao(), new EmailManager(),
				new GoogleManagerAdapter());

		userService2.register(user2);
		userService2.login(user2);
	}
}
