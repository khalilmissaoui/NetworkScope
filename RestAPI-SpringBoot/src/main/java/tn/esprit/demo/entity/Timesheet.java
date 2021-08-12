package tn.esprit.demo.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "timesheet")
public class Timesheet implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	

	public Timesheet() {
	
	}

	public Timesheet(EmbededKey id, Employe employe, Mission mission, Date debutDate, Date finDate, Boolean isValid) {
		super();
		this.id = id;
		this.employe = employe;
		this.mission = mission;
		DebutDate = debutDate;
		FinDate = finDate;
		this.isValid = isValid;
	}

	@EmbeddedId
	private EmbededKey id = new EmbededKey() ;
	
	
	
	@MapsId("EmployeId")
	@ManyToOne
	@JoinColumn(name = "Employe_id")
	private Employe employe ;
	
	@MapsId("MissionId")
	@ManyToOne
	@JoinColumn(name = "Mission_Id")
	private Mission mission;
	
	@Temporal(TemporalType.DATE)
	private Date DebutDate ;
	
	@Temporal(TemporalType.DATE)
	private Date FinDate ;
	
	private Boolean isValid ;




	public EmbededKey getId() {
		return id;
	}

	public void setId(EmbededKey id) {
		this.id = id;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Date getDebutDate() {
		return DebutDate;
	}

	public void setDebutDate(Date debutDate) {
		DebutDate = debutDate;
	}

	public Date getFinDate() {
		return FinDate;
	}

	public void setFinDate(Date finDate) {
		FinDate = finDate;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
