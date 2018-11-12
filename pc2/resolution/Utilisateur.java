import java.util.*;
import java.sql.*;

public class Utilisateur {

	String nom, prenom, motDePasse;
	Connection connect = null;

	public Utilisateur(String nomUtilisateur, String prenom, String motDePasse){
		this.nom = nomUtilisateur;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	public Utilisateur(Connection conn){
		this.connect = conn;
	}
	public Utilisateur(){

	}
	public void setNom(String nomUtilisateur){
		this.nom = nomUtilisateur;
	}
	public void setPrenom(String prenomEtudiant){
		this.prenom = prenomEtudiant;
	}
	public void setMotDePasse(String motDePasse){
		this.motDePasse = motDePasse;
	}

	public String getMotDePasse(){
		return this.motDePasse;
	}
	public String getNom(){
		return this.nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
	public void enregistrerUtilisateur(Utilisateur objet){
		try {
            this.connect.createStatement().executeUpdate("insert into utilisateur(nom, prenom, motdepasse) values("+
            "'"+objet.getNom()+"',"+"'"+objet.getPrenom()+"',"+"'"+objet.getMotDePasse()+"')");
        } catch (SQLException e) { 
            e.printStackTrace();
        }

	}
}