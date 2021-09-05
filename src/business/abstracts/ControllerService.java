package business.abstracts;

import entities.concrete.User;

public interface ControllerService {
	boolean checkName(User user);
	boolean checkLastName(User user);
	boolean checkMail(User user);
	boolean checkPassword(User user);
	boolean checkisValid(User user);
	boolean checkisUniqueMail(User user);
	boolean checkisMailSent(User user);
	boolean checkisMailVerified(User user);

}
