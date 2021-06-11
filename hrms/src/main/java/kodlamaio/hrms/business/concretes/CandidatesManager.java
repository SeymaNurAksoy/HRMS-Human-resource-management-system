package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.business.BusinessControls;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidatesManager implements CandidatesService {

	private CandidateDao c_dao;
	private UserService uservice;
	private CandidateCheckService candidateCheck;
	private EmailService emailService;
	int i =1;

	@Autowired
	public CandidatesManager(CandidateDao c_dao, UserService uservice, CandidateCheckService candidateCheck,
			EmailService emailService) {
		super();
		this.c_dao = c_dao;
		this.uservice = uservice;
		this.candidateCheck = candidateCheck;
		this.emailService = emailService;
	}

	@Override
	public Result add(Candidate candidate) {

		var errors = BusinessControls.control(this.emailControl(candidate),
				this.identificationNumberControl(candidate));
		if (errors  instanceof ErrorResult) {
			return errors;
		}

		Result vertification =
				BusinessControls.control(this.emailService.emailVertification(candidate, ""),candidateCheck.checkIfRealPerson(candidate));
		
	
		if (vertification instanceof ErrorResult) {
		
			return vertification;
			
		}
		
			this.uservice.add(candidate);
			this.c_dao.save(candidate);
			vertification = new SuccessResult("Eklendi");
			return vertification;
			
		
		

	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.c_dao.findAll());
	}

	@Override
	public DataResult<Candidate> findByidentificationNumber(String identificationNumber) {
		return new SuccessDataResult<Candidate>(this.c_dao.findByidentificationNumber(identificationNumber),
				"");
	}

	private Result emailControl(Candidate user) {
		var email = this.c_dao.findByEmail(user.getEmail().toString());
		if (email != null) {
			return new ErrorResult("Email bulunmaktadır.");
		}
		return new SuccessResult();

	}

	private Result identificationNumberControl(Candidate user) {
		var identificationNumber = this.c_dao.findByidentificationNumber(user.getIdentificationNumber().toString());
		if (identificationNumber != null) {
			return new ErrorResult("Tc no bulunmaktadır");
		}

		return new SuccessResult();

	}

}
