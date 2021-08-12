package tn.esprit.demo.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrat implements Serializable {


	 
	
	public Contrat() {
	
	}

	
	
	
	public Contrat(int id, String reference, Date dateDebut, String typeContrat, Double salaire, Employe employe) {
		super();
		this.id = id;
		this.reference = reference;
		this.DateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
		this.employe = employe;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String reference ;
	
	@Temporal(TemporalType.DATE)
	private Date DateDebut ;
	
	private String typeContrat ;
	
	private Double salaire ;
	
	@OneToOne
	@JoinColumn(name = "EmpId", referencedColumnName = "id")
	private Employe employe;

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getReference() {
		return reference;
	}




	public void setReference(String reference) {
		this.reference = reference;
	}




	public Date getDateDebut() {
		return DateDebut;
	}




	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}




	public String getTypeContrat() {
		return typeContrat;
	}




	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}




	public Double getSalaire() {
		return salaire;
	}




	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}




	public Employe getEmploye() {
		return employe;
	}




	public void setEmploye(Employe employe) {
		this.employe = employe;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "Contrat [id=" + id + ", reference=" + reference + ", DateDebut=" + DateDebut + ", typeContrat="
				+ typeContrat + ", salaire=" + salaire + ", employe=" + employe + "]";
	}
	
	
	
	
}
