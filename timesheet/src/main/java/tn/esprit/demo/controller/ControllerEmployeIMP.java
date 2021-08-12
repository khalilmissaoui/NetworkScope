package tn.esprit.demo.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.demo.entity.Employe;
import tn.esprit.demo.entity.Role;
import tn.esprit.demo.service.IEmployeService;

@Scope(value = "session")
@Controller(value = "employeController") // Name of the bean in Spring IoC
@ELBeanName(value = "employeController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class ControllerEmployeIMP {

	
	@Autowired
	IEmployeService userService;

	
	private Date date ;
	
	private String email; 
	private String password; 
	private Employe employe;
	private Boolean loggedIn;
	private float salaire;
	
	private Employe authenticatedUser;
	
	private String prenom; private String nom; 
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}

	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	private boolean actif; private Role role;
	
	
	
	
	public Employe getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(Employe authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	public IEmployeService getUserService() {
		return userService;
	}
	public void setUserService(IEmployeService userService) {
		this.userService = userService;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser=userService.authenticate(email, password);
		if (authenticatedUser != null && authenticatedUser.getRole() ==
		Role.ADMINISTRATEUR) {
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}

		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}
		
		
		public String doRedirection(){
			return "/redirection.xhtml?faces-redirect=true";
		}
		
		public Role[] getRoles() { return Role.values(); }
		
		public void addEmploye() {
			userService.addOrUpdateEmploye(new Employe(nom, prenom, email, password, actif, role));
			}
		
		
		private List<Employe> employes;
		
		public List<Employe> getEmployes() {
			employes = userService.getAllEmployes();
			return employes;
			}
		public void setEmployes(List<Employe> employes) {
			this.employes = employes;
		}
		
		public void removeEmploye(int employeId)
		{
		userService.deleteEmployeById(employeId);
		}
		
		
		
		private Integer employeIdToBeUpdated;
		public Integer getEmployeIdToBeUpdated() {
			return employeIdToBeUpdated;
		}
		public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
			this.employeIdToBeUpdated = employeIdToBeUpdated;
		}
		
		
		public void displayEmploye(Employe empl)
		{
		this.setPrenom(empl.getPrenom());
		this.setNom(empl.getNom());
		this.setActif(empl.getActif());
		this.setEmail(empl.getEmail());
		this.setRole(empl.getRole());
		this.setPassword(empl.getPassword());
		this.setEmployeIdToBeUpdated(empl.getId());
		}
		
		
		public void updateEmploye()
		{ userService.addOrUpdateEmploye(new Employe(employeIdToBeUpdated,salaire,date, nom,
		prenom, email, password, actif, role)); }
	
    
}
