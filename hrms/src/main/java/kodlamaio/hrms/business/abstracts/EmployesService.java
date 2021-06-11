package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employes;


public interface EmployesService  {

	Result add(Employes employes);
	
	DataResult<List<Employes>> getAll();
}
