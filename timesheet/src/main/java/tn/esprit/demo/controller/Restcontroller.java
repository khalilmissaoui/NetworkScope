package tn.esprit.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.Contained;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entity.Contrat;
import tn.esprit.demo.entity.Departement;
import tn.esprit.demo.entity.Employe;
import tn.esprit.demo.repository.DepartmentRepository;
import tn.esprit.demo.repository.EmployeRepository;
import tn.esprit.demo.service.EmployeService;

@RestController
@RequestMapping("/employe")
public class Restcontroller {
	
	@Autowired
	DepartmentRepository DepartmentRepository;
	
	@Autowired
	EmployeRepository EmployeRepository;
	
	@Autowired
	EmployeService employeService; 
	
	@GetMapping
	public String hello(){
		return "hello world";
	}
	
	@PostMapping
	public ResponseEntity<Employe> addemploye(@RequestBody Employe e){
		employeService.ajouterEmploye(e);
		return new ResponseEntity<Employe>(HttpStatus.OK);
	}
	
	@PostMapping("/affecterEmployeADepartement")
	public ResponseEntity<Employe> affecterEmployeADepartement(@RequestParam int empId , 
			@RequestParam int depId){
		System.out.println("*********empID /"+empId+"********** DEPID /"+depId);
		employeService.affecterEmployeADepartement(empId,depId);
		return new ResponseEntity<Employe>(HttpStatus.OK);
	}
	
	
	@PostMapping("/ajouterContrat")
	public ResponseEntity<Contrat> ajouterContrat(@RequestBody Contrat c){
		
		employeService.ajouterContrat(c);
		return new ResponseEntity<Contrat>(HttpStatus.OK);
	}
	
	@PostMapping("/affecterContratAEmploye")
	public ResponseEntity<Contrat> affecterContratAEmploye(@RequestParam int empId , 
			@RequestParam int CId){
		System.out.println("*********"+empId+"**********"+CId);
		employeService.affecterContratAEmploye(empId,CId);
		return new ResponseEntity<Contrat>(HttpStatus.OK);
	}
	
	@GetMapping("/getEmployePrenomById/{id}")
	public  ResponseEntity<String> getEmployePrenomById(@PathVariable("id") int id){
		
		return new ResponseEntity<String>(employeService.getEmployePrenomById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getNombreEmployeJPQL")
	public  ResponseEntity<Long> getNombreEmployeJPQL(){
		
		return new ResponseEntity<Long>(employeService.getNombreEmployeJPQL(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployeNamesJPQL")
	public  ResponseEntity<List<String>> getAllEmployeNamesJPQL(){
		
		return new ResponseEntity<List<String>>
		(employeService.getAllEmployeNamesJPQL(),HttpStatus.OK);
	}
	
	@GetMapping("/getdepartment/{id}")
	public  Employe getdepartment(@PathVariable("id")int id){
		
		return employeService.getdepartment(id);
	}
	
	
	
	
	
}
