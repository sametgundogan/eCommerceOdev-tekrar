package dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concrete.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println("Kullanıcı kaydedildi.");
		users.add(user);
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanıcı bilgileri güncellendi.");		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanıcı silindi.");		
		users.remove(user);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return users;
	}

}
