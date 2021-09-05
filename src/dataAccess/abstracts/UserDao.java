package dataAccess.abstracts;

import java.util.List;

import entities.concrete.User;

public interface UserDao {
	void register(User entity);
	void update(User entity);
	void delete(User entity);
	List<User>  list();

}
