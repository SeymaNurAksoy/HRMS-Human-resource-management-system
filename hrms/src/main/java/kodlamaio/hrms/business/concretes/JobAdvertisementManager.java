package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao advertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public Result add(JobAdvertisement advertisement) {
		advertisementDao.save(advertisement);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findAll(), "Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveTrueOrderByApplicationDeadlineDesc() {

		
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.advertisementDao.findByIsActiveTrueOrderByApplicationDeadlineDesc(Sort.by("creation_date")), "Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveTrueAndEmployerId(int id) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(this.advertisementDao.findByIsActiveTrueAndEmployerId(id),
				"Listelendi");

	}

	@Override
	public Result closeJobAdvertisement(int id) {

		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı bulunamadı.");
		} else if (!((JobAdvertisement) getById(id).getData()).isActive()) {
			return new ErrorResult("İlan kapalı durumda.");
		}
		JobAdvertisement updateJobAdvertisement = (JobAdvertisement) getById(id).getData();
		updateJobAdvertisement.setActive(false);
		this.advertisementDao.save(updateJobAdvertisement);
		return new SuccessResult("İlan kaldırıldı.");

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisementDto>>(this.advertisementDao.findByIsActiveTrue(),
				"Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {

		return new SuccessDataResult<JobAdvertisement>(this.advertisementDao.getById(id));
	}

}
