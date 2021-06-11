package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	 Result checkIfRealPerson(Candidate candidate);
}
