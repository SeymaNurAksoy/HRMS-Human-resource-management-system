package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService JobAdvertisements;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisements) {
		super();
		JobAdvertisements = jobAdvertisements;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement advertisements) {
		return this.JobAdvertisements.add(advertisements);
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {

		return this.JobAdvertisements.getAll();
	}

	@GetMapping("/findByIsActiveTrueOrderByApplicationDeadlineDesc")
	DataResult<List<JobAdvertisementDto>> findByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return this.JobAdvertisements.findByIsActiveTrueOrderByApplicationDeadlineDesc();
	}

	@GetMapping("/findByIsActiveTrueAndEmployerId")
	DataResult<List<JobAdvertisementDto>> findByIsActiveTrueAndEmployerId(int id) {
		return this.JobAdvertisements.findByIsActiveTrueAndEmployerId(id);
	}

	@GetMapping("/closeJobAdvertisement")
	Result closeJobAdvertisement(int id) {
		return this.JobAdvertisements.closeJobAdvertisement(id);
	}

	@GetMapping("/findByIsActiveTrue")
	DataResult<List<JobAdvertisementDto>> findByIsActiveTrue() {
		return this.JobAdvertisements.findByIsActiveTrue();
	}

	@GetMapping("/getById")
	DataResult<JobAdvertisement> getById(int id) {
		return this.JobAdvertisements.getById(id);
	}
}
