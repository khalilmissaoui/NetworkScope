package tn.esprit.demo.entity;

import java.io.Serializable; 

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Employe implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Employe() {
		
	}
	

	public Employe(int id, String prenom, String nom, String email, Boolean isActif, Role role, Contrat contrat,
			Set<Timesheet> timesheets, Set<Departement> departement) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.isActif = isActif;
		this.role = role;
		this.contrat = contrat;
		Timesheets = timesheets;
		this.departement = departement;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	
	private String prenom ;
	
	private String nom ; 
	
	private String email ; 
	
	private Boolean isActif ;
	
	
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	
	@OneToOne
	private Contrat contrat;
	

	@OneToMany(mappedBy = "employe")
	private Set<Timesheet> Timesheets;
	
    @ManyToMany
	private Set<Departement> departement;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Contrat getContrat() {
		return contrat;
	}


	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}


	public Set<Timesheet> getTimesheets() {
		return Timesheets;
	}


	public void setTimesheets(Set<Timesheet> timesheets) {
		Timesheets = timesheets;
	}


	public Set<Departement> getDepartement() {
		return departement;
	}


	public void setDepartement(Set<Departement> departement) {
		this.departement = departement;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", isActif=" + isActif
				+ ", role=" + role + ", contrat=" + contrat + ", Timesheets=" + Timesheets + ", departement="
				+ departement + "]";
	}
	
	
    
    
}