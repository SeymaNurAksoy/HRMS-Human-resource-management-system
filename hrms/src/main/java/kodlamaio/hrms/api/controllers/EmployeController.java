package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Employe;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

	private EmployeService employeService;

	@Autowired
	public EmployeController(EmployeService employeService) {
		super();
		this.employeService = employeService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employe employe) {
		return ResponseEntity.ok(this.employeService.add(employe));
	}
	@GetMapping("/getall")
	public DataResult<List<Employe>> getAll(){
		
		return this.employeService.getAll();
		
	}
	
	
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ErrorDataResult<Object>  handelValidationException(MethodArgumentNotValidException exceptions){
			
			Map<String, String> validationErrors = new HashMap<String, String>();
			for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları ; ");
			return errors; 
			
		}
}
