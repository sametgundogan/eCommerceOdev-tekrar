package business.concrete;

import java.util.regex.Pattern;

import business.abstracts.ControllerService;
import dataAccess.abstracts.UserDao;
import entities.concrete.User;

public class Controller implements ControllerService{

	UserDao userDao;
	public Controller(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean checkName(User user) {
		if(user.getUserName().length() < 3) {
			System.out.println("İsminiz 2 karakterden uzun olmalıdır.");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean checkLastName(User user) {
		if(user.getUserLastName().length() < 3) {
			System.out.println("Soyisminiz 2 karakterden uzun olmalıdır.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkMail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if(checkisUniqueMail(user) && pattern.matcher(user.getUserMail()).find()) {
			return true;
		}
		System.out.println("Mail adresiniz örnekteki gibi olmalıdır: example@example.com ");
		return false;
	}

	@Override
	public boolean checkPassword(User user) {
		if(user.getUserPassword().length() < 6) {
			System.out.println("Şifreniz 6 karakterden az olamaz!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkisValid(User user) {
		if(checkName(user) && checkLastName(user) && checkMail(user) && checkPassword(user) && 
				checkisMailSent(user) && checkisMailVerified(user)) {
			System.out.println("Kullanıcı bilgileri uygun.");
			return true;
		}
			System.out.println("Kayıt oluşturulamadı. Bilgilerinizin koşullara uyduğuna emin olunuz.");
				return false;
	}

	@Override
	public boolean checkisUniqueMail(User user) {
		for(User iteration : userDao.list()) {
			if(iteration.getUserMail() == user.getUserMail()) {
				System.out.println("Bu mail adresi daha önceden alınmış. Lütfen başka bir tane deneyiniz.");
			return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkisMailSent(User user) {
		if(checkName(user) && checkLastName(user) && checkMail(user) && checkPassword(user)) {
			System.out.println("Kayıt Başarılı! Lütfen mail adresinizi kontrol ederek doğrulama işlemini tamamlayınız.");
			return true;
		}
		System.out.println("Doğrulama işlemi başarısız.");
		return false;
	}

	@Override
	public boolean checkisMailVerified(User user) {
		if(checkName(user) && checkLastName(user) && checkMail(user) && checkPassword(user) && checkisMailSent(user)) {
			System.out.println("Mail adresi doğrulandı. Giriş yapabilirsiniz.");
			return true;
	}
		System.out.println("Doğrulanma işlemi tamamlanmadı.");
		return false;
	}

	

}
