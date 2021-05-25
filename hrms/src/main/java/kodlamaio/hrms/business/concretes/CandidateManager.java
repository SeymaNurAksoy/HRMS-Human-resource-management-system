package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateManager implements CandidateService{

	private CandidateDao dao;
	
@Autowired	
	public CandidateManager(CandidateDao dao) {
		super();
		this.dao = dao;
	}
	@Override
	public void add(Candidate candidate) {
		
		this.dao.save(candidate);
		
	}

	

}
