package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao dao;
	
	@Autowired
	public JobManager(JobDao dao) {
		super();
		this.dao = dao;
	}


	@Override
	public List<Job> getAll() {
		
		return this.dao.findAll();
	}

}
