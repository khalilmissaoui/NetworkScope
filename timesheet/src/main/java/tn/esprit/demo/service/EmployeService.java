package tn.esprit.demo.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import tn.esprit.demo.entity.Contrat;
import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Employe;
import tn.esprit.demo.entity.Entreprise;
import tn.esprit.demo.repository.ContratRepo;
import tn.esprit.demo.repository.DepartmentRepository;
import tn.esprit.demo.repository.EmployeRepository;
@Service
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
	@Transactional
	public void affecterEmployeADepartement(int employeId, int depId) {
		System.out.println("****************debut de fonction****************");
		
		Employe e = empRep.findById(employeId).get() ;
		Departement d = DepRepo.findById(depId).get() ;
		
		System.out.println("employee e :****************==="+e);
		System.out.println("department d:***************==="+d);
		
		if(d.getEmployes() == null){
			Set<Employe> employees = new HashSet<Employe>();
		
			employees.add(e);
			d.setEmployes(employees);
		}else {
			d.getEmployes().add(e);
		}
		System.out.println("*****************done with those *********");
		for (Employe e1 : d.getEmployes()){
			System.out.println(e1);
		}
		
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
	@Transactional
	public void affecterContratAEmploye(int contratId, int employeId) {
		Employe e = empRep.findById(employeId).get() ;
		Contrat c = ContRep.findById(contratId).get() ;
		
		c.setEmploye(e);
		
		
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
	
		public  Employe getdepartment(@PathVariable("id")int id){
		
		return   empRep.findById(id).get();
	}

		@Override
		public Employe authenticate(String login, String password) {
			// TODO Auto-generated method stub
			return empRep.getEmployeByEmailAndPassword(login, password);
		}

		@Override
		@Transactional
		public int addOrUpdateEmploye(Employe employe) {
			empRep.save(employe);
			return employe.getId();
			
		}

		@Override
		public List<Employe> getAllEmployes() {
			// TODO Auto-generated method stub
			return empRep.findAll();
		}

		@Override
		@Transactional
		public void deleteEmployeById(int employeId) {
			empRep.deleteById(employeId);
			
		}
		
		

}
