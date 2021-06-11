package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employers")

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "advertisements" })
public class Employe extends User {
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> advertisements;

	@NotBlank(message = "Şirket ismi alanı boş bırakılamaz")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "İnternet adresi alanı boş bırakılamaz")
	@Column(name = "web_adress")
	private String webAdress;

	@NotBlank(message = "Telefon numarası alanı boş bırakılamaz")
	@Column(name = "phone_number")
	private String phoneNumber;

}
