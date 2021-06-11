package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployesService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employes;

@RestController
@RequestMapping("/api/employes")
public class EmployesController {

	private EmployesService employesService;

	@Autowired
	public EmployesController(EmployesService employesService) {
		super();
		this.employesService = employesService;
	}

	@PostMapping("/add")
	Result add(@RequestBody Employes employes) {
		return this.employesService.add(employes);
	}

	@GetMapping("/getall")
	DataResult<List<Employes>> getAll(){
		return this.employesService.getAll();
	}

}
