package eCommerceBackend.dataAccsess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceBackend.dataAccsess.abstracts.UserDao;
import eCommerceBackend.entities.concretes.User;

public class HibernateUSerDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {

		System.out.println("Kullanýcý veri tabanýna kaydedildi " + user.getFirstName());
	}

	@Override
	public void remove(User user) {
		System.out.println("Kullanýcý veri tabanýndan kaldýrýldý " + user.getLastName());

	}

	@Override
	public User get(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		System.out.println("Ürünler listelendi");
		return null;
	}

}
