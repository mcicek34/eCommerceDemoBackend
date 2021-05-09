package eCommerceBackend.business.concretes;

import eCommerceBackend.business.abstracts.UserService;
import eCommerceBackend.core.abstracts.EmailVerification;
import eCommerceBackend.core.abstracts.GoogleService;
import eCommerceBackend.dataAccsess.abstracts.UserDao;
import eCommerceBackend.entities.concretes.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

	private UserDao userDao;
	private EmailVerification emailVerification;
	private GoogleService googleService;

	public UserManager(UserDao userDao, EmailVerification emailVerification, GoogleService googleService) {
		this.userDao = userDao;
		this.emailVerification = emailVerification;
		this.googleService = googleService;
	}

	@Override
	public void register(User user) {
		if (validator(user)) {
			userDao.add(user);
			emailVerification.sendMail();
			googleService.registerToGoogle("Google ile kayıt olundu " + user.getFirstName());

		} else {
			System.out.println("Kullanıcı kayıt olurken hata oluştu");
		}
	}

	@Override
	public void login(User user) {
		if (validator(user)) {
			System.out.println("Giriş Başarılı");
		}

		else {
			System.out.println("Hata");
		}
	}

	public boolean validator(User user) {
		if (user.getFirstName().length() > 2 && user.getLastName().length() > 2 && (user.getPassword().length() >= 6)
				&& emailControl(user.getEmail())) {
			return true;
		} else
			return false;

	}

	public static boolean emailControl(String email) {

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();

	}

}
