package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	public boolean checkIfRealPerson(Candidate candidate) ;
}
