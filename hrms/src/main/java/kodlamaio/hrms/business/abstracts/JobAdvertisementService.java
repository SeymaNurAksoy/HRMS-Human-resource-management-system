package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result  add(JobAdvertisement advertisements);
	
	DataResult<List<JobAdvertisement>> getAll();
	
    DataResult<List<JobAdvertisementDto>> findByIsActiveTrueOrderByApplicationDeadlineDesc();
	
	DataResult<List<JobAdvertisementDto>> findByIsActiveTrueAndEmployerId(int id);
	
	Result closeJobAdvertisement(int id);
	
	DataResult<List<JobAdvertisementDto>> findByIsActiveTrue();
	
	DataResult<JobAdvertisement> getById(int id);
}
