package com.clubsportif.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private char civilite;
	private String nom;
	private String prenom;
	private String email; 
	private int anneeNaissance; 
	private String adresse; 
	private String codePostal;
	private String ville;
	private String pays;
	private String motDePasse;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(char civilite, String nom, String prenom, String email, int anneeNaissance, String adresse,
			String codePostal, String ville, String pays, String motDePasse) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.anneeNaissance = anneeNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.motDePasse = motDePasse;
	}



	public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



	public char getCivilite() {
		return civilite;
	}



	public void setCivilite(char civilite) {
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public String getMotDePasse() {
		return motDePasse;
	}



	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}



	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", anneeNaissance=" + anneeNaissance + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + ", motDePasse=" + motDePasse + "]";
	} 
	
	
	

	

	
	
	
	

	
}
