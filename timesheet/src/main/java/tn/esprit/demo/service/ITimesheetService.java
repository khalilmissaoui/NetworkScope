package tn.esprit.demo.service;

import java.util.Date;

import tn.esprit.demo.entity.Mission;

public interface ITimesheetService {

	public int ajouterMission(Mission mission);
	 public void affecterMissionADepartement(int missionId, int depId);
	 public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
}
