package business.abstracts;

import entities.concrete.User;

public interface UserService {
	public void register(User user);
	public void update(User user);
	public void delete(User user);
	

}
