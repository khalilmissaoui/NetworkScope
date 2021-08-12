package tn.esprit.demo.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;



import tn.esprit.demo.entity.Contrat;
import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Employe;

import tn.esprit.demo.repository.ContratRepo;
import tn.esprit.demo.repository.DepartmentRepository;
import tn.esprit.demo.repository.EmployeRepository;

public class EmployeService implements IEmployeService {

	@Autowired
	EmployeRepository empRep; 
	
	@Autowired
	ContratRepo ContRep;
	
	@Autowired
	DepartmentRepository DepRepo ;
	
	
	@Override
	public int ajouterEmploye(Employe employe) {
		if(empRep.save(employe) != null)
			{return 1;}
		else
			return 0;
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Employe e = empRep.findById(employeId).get() ;
		Departement d = DepRepo.findById(depId).get() ;
		
		
		e.getDepartement().add(d);
		
		
		
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		if(ContRep.save(contrat) != null)
		{
			return 1;
		}
		else
			return 0;
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Employe e = empRep.findById(employeId).get() ;
		Contrat c = ContRep.findById(contratId).get() ;
		
		e.setContrat(c);
		
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		Employe e = empRep.findById(employeId).get() ;
		return e.getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		// TODO Auto-generated method stub
		return empRep.getNombreEmployeJPQL();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		// TODO Auto-generated method stub
		return  empRep.getAllEmployeNamesJPQL();
	}

}
