package tn.esprit.demo.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Employe implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Employe() {
		
	}
	

	public Employe(int id, String prenom, String nom,String password , String email, Boolean isActif, Role role, Contrat contrat,
			 Set<Departement> departement) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.password =password;
		this.email = email;
		this.actif = isActif;
		this.role = role;
		
	
		this.departement = departement;
	}

	

	public Employe(String nom2, String prenom2, String email2, String password2, boolean actif2, Role role2) {
		this.nom = nom2;
		this.prenom =prenom2;
		this.email=email2;
		this.password=password2;
		this.actif=actif2;
		this.role=role2;
	}



	public Employe(int id, String prenom, String nom, String email, String
			password, boolean actif, Role role) {
			super();
			this.id = id;
			this.prenom = prenom;
			this.nom = nom;
			this.email = email;
			this.password = password;
			this.actif = actif;
			this.role = role;
			}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private float Salaire;
	
	public Employe(int id, float salaire,Date date, String prenom, String nom, String password, String email, Boolean actif,
			Role role) {
		super();
		this.id = id;
		Salaire = salaire;
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.actif = actif;
		this.role = role;
		this.date=date;
	}
	@Temporal(TemporalType.DATE)
	public Date date ;

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public float getSalaire() {
		return Salaire;
	}


	public void setSalaire(float salaire) {
		Salaire = salaire;
	}



	private String prenom ;
	
	private String nom ; 
	
	private String password ;
	
	private String email ; 
	
	private Boolean actif;
	
	
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	
	
	
/*
	@OneToMany(mappedBy = "employe")
	private Set<Timesheet> Timesheets;
	*/
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




	public Boolean getActif() {
		return actif;
	}


	public void setActif(Boolean actif) {
		this.actif = actif;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}



/*
	public Set<Timesheet> getTimesheets() {
		return Timesheets;
	}


	public void setTimesheets(Set<Timesheet> timesheets) {
		Timesheets = timesheets;
	}
*/

	public Set<Departement> getDepartement() {
		return departement;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setDepartement(Set<Departement> departement) {
		this.departement = departement;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", password=" + password + ", email="
				+ email + ", actif=" + actif + ", role=" + role + ", departement=" + departement + "]";
	}



	
	
    
    
}