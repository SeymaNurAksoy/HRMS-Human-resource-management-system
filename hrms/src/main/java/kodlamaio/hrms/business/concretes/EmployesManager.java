package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployesService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployesDao;
import kodlamaio.hrms.entities.concretes.Employes;

@Service
public class EmployesManager implements EmployesService {

	private EmployesDao employesDao;

	@Autowired
	public EmployesManager(EmployesDao employesDao) {
		super();
		this.employesDao = employesDao;
	}

	@Override
	public Result add(Employes employes) {
		this.employesDao.save(employes);
		return new SuccessResult("Eklendi.");
	}

	@Override
	public DataResult<List<Employes>> getAll() {
		return new SuccessDataResult<List<Employes>>(this.employesDao.findAll(), "Listelendi.");
	}

}
