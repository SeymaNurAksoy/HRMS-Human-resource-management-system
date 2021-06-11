package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidates")

public class Candidate extends User {

	@NotBlank(message = "İsim alanı boş bırakılamaz")
	@Column(name = "firstname")
	private String firstName;

	@NotBlank(message = "Soyisim alanı boş bırakılamaz")
	@Column(name = "lastname")
	private String lastName;

	@NotBlank(message = "TC numarası alanı boş bırakılamaz")
	@Size(min = 11, max = 11, message = "TC numarası 11 karakter uzunluğunda olmalıdır.")
	@Column(name = "identity_number")
	private String identificationNumber;

	@NotNull(message = "Doğum yılı alanı boş bırakılamaz")
	@Column(name = "birthdate")
	private int birthDate;

}
