package tn.esprit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entity.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	
	@Query("SELECT count(e) FROM Employe e ")
	Long getNombreEmployeJPQL();
	
	
	@Query("SELECT e.nom FROM Employe e ")
	List<String> getAllEmployeNamesJPQL();
	
	
	public Employe getEmployeByEmailAndPassword(String login, String password);
	
	


}
