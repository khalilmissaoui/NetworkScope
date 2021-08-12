/*package tn.esprit.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Employe;
import tn.esprit.demo.entity.Mission;
import tn.esprit.demo.entity.Timesheet;
import tn.esprit.demo.repository.DepartmentRepository;
import tn.esprit.demo.repository.EmployeRepository;
import tn.esprit.demo.repository.MissionRepository;
import tn.esprit.demo.repository.TimesheetRepository;
@Service
public class TimesheetService implements ITimesheetService {

	@Autowired
	TimesheetRepository timesheetRepository;
	
	@Autowired
	MissionRepository misRep ;
	
	@Autowired
	DepartmentRepository DepRep ;
	
	@Autowired
	EmployeRepository EmpRep ;

	@Override
	public int ajouterMission(Mission mission) {
		if(misRep.save(mission) != null)
		{return 1;}
	else
		return 0;
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission m = misRep.findById(missionId).get();
		Departement d = DepRep.findById(depId).get();
		
		d.getMissions().add(m);
		
		
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		Timesheet timesheet = new Timesheet();
		Mission m = misRep.findById(missionId).get();
		Employe e = EmpRep.findById(employeId).get();
		
		timesheet.setEmploye(e);
		timesheet.setMission(m);
		timesheet.setDebutDate(dateDebut);
		timesheet.setFinDate(dateFin);
		timesheet.setIsValid(false);
		
		timesheetRepository.save(timesheet);
		
		
	}
	
	
	
}
*/