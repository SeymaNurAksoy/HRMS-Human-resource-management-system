package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employes;

public interface EmployesDao extends JpaRepository<Employes, Integer> {

}
