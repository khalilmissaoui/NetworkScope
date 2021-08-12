package tn.esprit.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbededKey implements Serializable {
	@Column(name = "EmployeId", nullable = false)
	private int EmployeId;
	@Column(name = "MissionId", nullable = false)
	private int MissionId;
	
	
	public EmbededKey() {
			}
	
	public EmbededKey(int employeId, int missionId) {
		super();
		EmployeId = employeId;
		MissionId = missionId;
	}
	public int getEmployeId() {
		return EmployeId;
	}
	public void setEmployeId(int employeId) {
		EmployeId = employeId;
	}
	public int getMissionId() {
		return MissionId;
	}
	public void setMissionId(int missionId) {
		MissionId = missionId;
	}
}
