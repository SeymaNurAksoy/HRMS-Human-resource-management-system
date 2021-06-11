package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisements")

public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobPosition job;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employe employer;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "quota")
	private int quota;

	@Column(name = "creation_date")
	private LocalDate creation_date;

	@Column(name = "advertisement_deadline")
	private LocalDate adversimentDeadline;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "description")
	private String description;

	@Column(name = "min_salary")

	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;
	

	@Column(name = "open_position_count")
	private int openPositionCount;

	@Column(name = "application_date")
	private LocalDate  applicationDate;

}
