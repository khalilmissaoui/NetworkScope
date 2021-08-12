package tn.esprit.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Entreprise;
import tn.esprit.demo.repository.DepartmentRepository;
import tn.esprit.demo.repository.EntrepriseRepository;
@Service
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
	@Transactional
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Entreprise e = EntRepo.findById(entrepriseId).get() ;
		Departement d = DepRepo.findById(depId).get() ;
		
		d.setEntreprise(e);
		
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise e = EntRepo.findById(entrepriseId).get() ;
		List<String> DepNames = new ArrayList<String>();
		
		for(Departement d : DepRepo.findAll()){
			if(d.getEntreprise().getName()==e.getName())
				DepNames.add(d.getName());
		}
	
		
		return DepNames;
		
	}

}
