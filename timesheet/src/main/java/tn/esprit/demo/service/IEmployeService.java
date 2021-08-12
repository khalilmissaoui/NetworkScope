package tn.esprit.demo.service;

import java.util.List;

import tn.esprit.demo.entity.Contrat;
import tn.esprit.demo.entity.Employe;

public interface IEmployeService {


	public int ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public int ajouterContrat(Contrat contrat);
	 public void affecterContratAEmploye(int contratId, int employeId);
	 public String getEmployePrenomById(int employeId);
	 public long getNombreEmployeJPQL();
	 public List<String> getAllEmployeNamesJPQL();
	 
	 public Employe authenticate(String login, String password) ;
	public int addOrUpdateEmploye(Employe employe);
	public List<Employe> getAllEmployes();
	public void deleteEmployeById(int employeId);
	
}
