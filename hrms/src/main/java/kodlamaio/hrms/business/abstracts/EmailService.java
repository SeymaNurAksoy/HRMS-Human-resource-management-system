package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface EmailService {

	Result emailVertification(User user,String vertificationId);

}
