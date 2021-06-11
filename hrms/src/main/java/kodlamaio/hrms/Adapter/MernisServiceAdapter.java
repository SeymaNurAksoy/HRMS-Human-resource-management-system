package kodlamaio.hrms.Adapter;




import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class MernisServiceAdapter implements CandidateCheckService{


@Override
public Result checkIfRealPerson(Candidate candidate) {
	
	
	return new SuccessResult("Mernis doğrulama hatası");
}

}