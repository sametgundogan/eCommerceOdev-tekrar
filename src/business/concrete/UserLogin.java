package business.concrete;

import business.abstracts.UserLoginService;
import dataAccess.abstracts.UserDao;
import entities.concrete.User;

public class UserLogin implements UserLoginService{

	UserDao userDao;
	
	public UserLogin(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void login(String mail, String password) {
		for(User user : userDao.list()) {
			if(user.getUserMail() == mail && user.getUserPassword() == password) {
				System.out.println("Sistem girişi başarılı.");
			}else {
				System.out.println("Mail adresi ya da şifre hatalı.");
			}
		}
	}

}
