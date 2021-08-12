package tn.esprit.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Entreprise;
import tn.esprit.demo.repository.DepartmentRepository;
import tn.esprit.demo.repository.EntrepriseRepository;

public class EntrepriseService implements  IEntrepriseService{

	@Autowired
	EntrepriseRepository EntRepo ;
	
	@Autowired
	DepartmentRepository DepRepo ;
	
	
	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		if(EntRepo.save(entreprise) != null){
			return 1;
		}else
			return -1;
		
		 
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		if(DepRepo.save(dep) != null){
			return 1;
		}else
			return -1;
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Entreprise e = EntRepo.findById(entrepriseId).get() ;
		Departement d = DepRepo.findById(depId).get() ;
		
		if(e.getDepartements()==null){
			Set<Departement> departements = new HashSet<Departement>();
			departements.add(d);
			e.setDepartements(departements);
		}		
		e.getDepartements().add(d);
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise e = EntRepo.findById(entrepriseId).get() ;
		List<String> DepNames = new ArrayList<String>();
		
		for(Departement d : e.getDepartements()){
			DepNames.add(d.getName());
		}
		
		return DepNames;
		
	}

}
