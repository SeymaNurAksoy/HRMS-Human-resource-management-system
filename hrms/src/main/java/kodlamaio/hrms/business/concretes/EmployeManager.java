package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeService;
import kodlamaio.hrms.core.business.BusinessControls;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeDao;
import kodlamaio.hrms.entities.concretes.Employe;

@Service
public class EmployeManager implements EmployeService {

	private EmployeDao edao;
	@Autowired
	public EmployeManager(EmployeDao edao) {
		super();
		this.edao = edao;
	}

	@Override
	public Result add(Employe employe) {
		var error = BusinessControls.control(this.emailControl(employe.getEmail().toString()),this.companyControl(employe.getCompanyName().toString()));
		if(error != null) {
			return error;
		}
		this.edao.save(employe);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<Employe>> getAll() {
		return new SuccessDataResult<List<Employe>>(this.edao.findAll(),"Listelendi.");
	}

	private Result emailControl(String email) {
		var email1 = this.edao.findByEmail(email);
		if(email1 != null) {
			return new  ErrorResult("Email bulunmaktadır.");
		}
		return new SuccessResult();
	}
	private Result companyControl(String companyName) {
		var companyName1 = this.edao.findByCompanyName(companyName);
		if(companyName1 != null) {
			return new  ErrorResult("Şirket ismi bulunmaktadır.");
		}
		return new SuccessResult();
	}
	
}
