package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name ="candidates")
public class Candidate extends User{


	public Candidate(int id, String email, String password, String confirmPassword, int id2, String firstName,
			String lastName, int dateOfBirth, long nationalityId) {
		super(id, email, password, confirmPassword);
		id = id2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
	}

	@Id
	@GeneratedValue
	@Column(name="id" )
	private int id;
	
	@Column(name="firstname" )
	private String firstName;
	
	@Column(name="lastname" )
	private String lastName;
	
	@Column(name="birthdate" )
	private int dateOfBirth;
	
	@Column(name="identity_number" )
	private long nationalityId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		this.nationalityId = nationalityId;
	}
	
	
	
	
}
