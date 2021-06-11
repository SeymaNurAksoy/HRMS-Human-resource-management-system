package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	JobAdvertisement getById(int id);

	// aktif olanları getiir
	// @Query("From JobAdvertisement where isActive=true")
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id, e.companyName, p.position, j.openPositionCount, j.creation_date, j.adversimentDeadline)"
			+ "From JobAdvertisement j Inner Join  j.employer e Inner Join j.job p Where j.isActive=true")
	List<JobAdvertisementDto> findByIsActiveTrue();

	// aktif iş ilamlarını desc olarak sırala
	// @Query("From JobAdvertisement where isActive=true ORDER BY
	// adversimentDeadline desc")
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id, e.companyName, p.position, j.openPositionCount, j.creation_date, j.adversimentDeadline)"
			+ "From JobAdvertisement j Inner Join  j.employer e Inner Join j.job p Where j.isActive=true")
	List<JobAdvertisementDto> findByIsActiveTrueOrderByApplicationDeadlineDesc(Sort sort);

	// @Query("From JobAdvertisement where isActive=true and employer_id=:id")
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id, e.companyName, p.position, j.openPositionCount, j.creation_date, j.adversimentDeadline)"
			+ "From JobAdvertisement j Inner Join  j.employer e Inner Join j.job p Where j.isActive=true and e.id=:id")
	List<JobAdvertisementDto> findByIsActiveTrueAndEmployerId(int id);

}
