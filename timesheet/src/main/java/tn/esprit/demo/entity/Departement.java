package tn.esprit.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Departement implements Serializable {


	
	private static final long serialVersionUID = 1L;
	
	
	
	
	public Departement() {

	}
	
	
	
	
	public Departement(int id, String name, Set<Mission> missions, Entreprise entreprise, Set<Employe> employes) {
		super();
		this.id = id;
		this.name = name;
		this.missions = missions;
		this.entreprise = entreprise;
		this.employes = employes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String name;
	
	@OneToMany(mappedBy ="departement")
	private Set<Mission> missions;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "EmpId", referencedColumnName = "id")
	private Entreprise entreprise;
	
	@ManyToMany(mappedBy ="departement")
	private Set<Employe> employes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", name=" + name + ", missions=" + missions + ", entreprise=" + entreprise
				+ ", employes=" + employes + "]";
	}
	
	
	
	
}

