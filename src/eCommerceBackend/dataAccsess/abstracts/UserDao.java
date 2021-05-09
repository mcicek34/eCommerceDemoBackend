package eCommerceBackend.dataAccsess.abstracts;

import java.util.List;

import eCommerceBackend.entities.concretes.User;

public interface UserDao {

	void add(User user);
	void remove(User user);
	User get(int id);
	List<User> getAll();

}
