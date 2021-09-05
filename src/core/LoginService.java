package core;

import entities.concrete.User;

public interface LoginService {
	public void login(User user);
	public void signup(User user);

}
