import java.sql.*;

public class Etudiant {
	String nom, prenom, contact, region, sexe;
	Connection connect = null;

	public Etudiant(String nomEtudiant, String prenomEtudiant, String contact, String regionEtudiant, String sexeEtudiant){
		this.nom = nomEtudiant;
		this.prenom = prenomEtudiant;
		this.contact = contact;
		this.region = regionEtudiant;
		this.sexe = sexeEtudiant;
	}
	public Etudiant(Connection conn){
		this.connect = conn;
	}
	public String getNom(){
		return this.nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
	public String getContact(){
		return this.contact;
	}
	public String getRegion(){
		return this.region;
	}
	public String getSexe(){
		return this.sexe;
	}
	public void enregistrerEtudiant(Etudiant objet){
		try{
			Connexion.getInstance().createStatement().executeUpdate("insert into etudiant(nom, prenom, contact, region, sexe) values("+
			"'"+objet.getNom()+"',"+"'"+objet.getPrenom()+"',"+"'"+objet.getContact()+"',"+"'"+objet.getRegion()+"',"+"'"+objet.getSexe()+"')");
		}
		catch (SQLException e) { 
            e.printStackTrace();
        }
	}

}