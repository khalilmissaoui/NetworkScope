package tn.esprit.demo.service;

import java.util.List;

import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Entreprise;

public interface IEntrepriseService {

	 public int ajouterEntreprise(Entreprise entreprise);
	 public int ajouterDepartement(Departement dep);
	 void affecterDepartementAEntreprise(int depId, int entrepriseId);
	 List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
}
