package tn.esprit.demo.entity;
 

import java.io.Serializable; 

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Externe")
public class MissionExterne extends Mission  {




	private String emailFacturation;
	
	private String tauxJournalierMoyen;

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	public String getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}

	public void setTauxJournalierMoyen(String tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	@Override
	public String toString() {
		return "MissionExterne [emailFacturation=" + emailFacturation + ", tauxJournalierMoyen=" + tauxJournalierMoyen
				+ "]";
	}

	
	
}

