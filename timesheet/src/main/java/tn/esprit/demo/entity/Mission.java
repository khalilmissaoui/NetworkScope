package tn.esprit.demo.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name ="Mission_TYPE",
		discriminatorType = DiscriminatorType.STRING
		)
public class Mission implements Serializable {


	
	public Mission() {
	}

	
	
	public Mission( String name, String description, Departement departement) {
		super();
		this.name = name;
		this.description = description;
		this.departement = departement;
	}




	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String name ; 
	
	private String description; 
	
	/*@OneToMany(mappedBy = "mission")
	private Set<Timesheet> Timesheets;*/
	
	
	
	@ManyToOne()
	private Departement departement;



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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



/*	public Set<Timesheet> getTimesheets() {
		return Timesheets;
	}

*/
/*
	public void setTimesheets(Set<Timesheet> timesheets) {
		Timesheets = timesheets;
	}
*/


	public Departement getDepartement() {
		return departement;
	}



	public void setDepartement(Departement departement) {
		this.departement = departement;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + ", Timesheets=" 
				+ ", departement=" + departement + "]";
	}
	
	
	
	
	
}