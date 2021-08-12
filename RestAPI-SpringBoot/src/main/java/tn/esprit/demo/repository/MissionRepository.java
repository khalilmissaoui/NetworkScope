package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entity.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer> {

	
}
