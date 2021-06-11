package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.business.BusinessControls;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobManager implements JobService {

	private JobDao dao;

	@Autowired
	public JobManager(JobDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.dao.findAll(), "Listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {

		var errors = BusinessControls.control(this.jobControl(jobPosition));
		if (errors != null) {
			return errors;
		}
		this.dao.save(jobPosition);
		return new SuccessResult("Eklendi");
	}

	private Result jobControl(JobPosition job) {
		var job1 = this.dao.findByPosition(job.getPosition().toString());
		if (job1 != null) {
			return new ErrorResult("Pozisyon bulunmaktadır.");
		}
		return new SuccessResult();

	}

}
