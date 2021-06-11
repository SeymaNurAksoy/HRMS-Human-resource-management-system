package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(message = "Email alanı boş bırakılamaz")
	@Email(message = "Email formatında olmalıdır.")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Şifre alanı boş bırakılamaz")
	@Column(name = "password")
	private String password;

	@NotBlank(message = "Şifre tekrarı alanı boş bırakılamaz")
	@Column(name = "confirm_password")
	private String passwordAgain;

}
