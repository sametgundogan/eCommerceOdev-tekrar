import business.abstracts.UserService;
import business.concrete.Controller;
import business.concrete.UserLogin;
import business.concrete.UserManager;
import dataAccess.concrete.HibernateUserDao;
import entities.concrete.User;

public class Main {

	public static void main(String[] args) {
		User kullanici1 = new User();
		kullanici1.setUserId(00001);
		kullanici1.setUserName("Samet");
		kullanici1.setUserLastName("Gündoğan");
		kullanici1.setUserMail("sametgundogan@eclipse.com");
		kullanici1.setUserPassword("023356");
		
		HibernateUserDao hibernateUserDao = new HibernateUserDao();
		UserService uManager = new UserManager(new Controller(hibernateUserDao), hibernateUserDao);
		uManager.register(kullanici1);
		
		System.out.println("-------------------------------");
		UserLogin uGiris = new UserLogin(hibernateUserDao);
		uGiris.login("sametgundogan@eclipse.com","023356");
		uGiris.login("sametgundogan@eclipse.com", "000000");
	}

}
