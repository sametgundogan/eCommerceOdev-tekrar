package core;

import GoogleLogger.LoginManager;
import entities.concrete.User;

public class LoginManagerAdapter implements LoginService{

	LoginManager googleLogin = new LoginManager();
	
	
	@Override
	public void login(User user) {
		googleLogin.login(user.getUserMail(), user.getUserPassword());
	}

	@Override
	public void signup(User user) {
		googleLogin.signup(user.getUserMail(), user.getUserPassword());	
	}

}
