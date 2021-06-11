package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private String companyName;
	private String jobPositionName;
	private int openPositionCount;
	private LocalDate creation_date;
	private LocalDate adversimentDeadline;
	
}
