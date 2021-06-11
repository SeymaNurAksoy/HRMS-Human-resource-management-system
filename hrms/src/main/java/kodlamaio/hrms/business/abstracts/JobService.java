package kodlamaio.hrms.business.abstracts;

import java.util.List;

import javax.validation.Valid;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobService  {
	
	DataResult<List<JobPosition>> getAll();
	Result add( JobPosition jobPosition);

}
