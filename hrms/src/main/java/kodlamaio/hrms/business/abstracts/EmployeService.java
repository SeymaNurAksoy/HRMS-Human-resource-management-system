package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employe;


public interface EmployeService {

	Result add(Employe employe);
	
	DataResult<List<Employe>> getAll();
	
}
