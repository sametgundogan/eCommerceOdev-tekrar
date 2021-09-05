package business.concrete;

import business.abstracts.ControllerService;
import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concrete.User;

public class UserManager implements UserService{

	ControllerService signinCheck;
	UserDao userDao;
	public UserManager(ControllerService signinCheck, UserDao userDao) {
		this.signinCheck = signinCheck;
		this.userDao = userDao;
	}
	
	
	@Override
	public void register(User user) {
		if(signinCheck.checkisValid(user)) {
			userDao.register(user);
			System.out.println("Kullanıcı kaydı tamamlandı: " + user.getUserName() + " " + user.getUserLastName());
		
		}
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("Kullanıcı bilgileri güncellendi.");
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println("Kullanıcı silindi.");
		
		
	}

}
