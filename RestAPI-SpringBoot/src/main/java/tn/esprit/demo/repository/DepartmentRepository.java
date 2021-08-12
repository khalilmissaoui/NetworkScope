package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entity.Departement;
@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Integer> {

}
