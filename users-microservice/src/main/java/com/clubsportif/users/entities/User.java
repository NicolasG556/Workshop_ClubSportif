package com.clubsportif.users.entities;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class User {	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long user_id;
	private byte civilite;
	private String nom;
	private String prenom;
	private int anneeNaissance; 
	private String adresse; 
	private String codePostal;
	private String ville;
	private String pays;

 @Column(unique=true)
	private String username;
	private String password;
	private Boolean enabled;
	
    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
			   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Role> roles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(Long user_id, byte civilite, String nom, String prenom, int anneeNaissance, String adresse,
			String codePostal, String ville, String pays, String username, String password, Boolean enabled,
			List<Role> roles) {
		super();
		this.user_id = user_id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.anneeNaissance = anneeNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	



	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

	public byte getCivilite() {
		return civilite;
	}



	public void setCivilite(byte civilite) {
		this.civilite = civilite;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getAnneeNaissance() {
		return anneeNaissance;
	}



	public void setAnneeNaissance(int anneeNaissance) {
		this.anneeNaissance = anneeNaissance;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}




	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", anneeNaissance=" + anneeNaissance + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", roles=" + roles + "]";
	}



	
    
    
}



