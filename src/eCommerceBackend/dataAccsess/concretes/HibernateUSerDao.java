package eCommerceBackend.dataAccsess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceBackend.dataAccsess.abstracts.UserDao;
import eCommerceBackend.entities.concretes.User;

public class HibernateUSerDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {

		System.out.println("Kullan�c� veri taban�na kaydedildi " + user.getFirstName());
	}

	@Override
	public void remove(User user) {
		System.out.println("Kullan�c� veri taban�ndan kald�r�ld� " + user.getLastName());

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
		System.out.println("�r�nler listelendi");
		return null;
	}

}
