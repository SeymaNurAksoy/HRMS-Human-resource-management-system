package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface CandidatesService {
	
	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> findByidentificationNumber(String identificationNumber);
	

	}
