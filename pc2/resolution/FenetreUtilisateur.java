import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

//Cette fenêtre permettra à l'utilisateur de se connecter avec son nom d'utilisateur et son mot de passe et ou de créer un compte
public class FenetreUtilisateur extends JFrame implements ActionListener{
	private JTextField nomUtilisateur = new JTextField(14); 
	private JPasswordField passwd = new JPasswordField(14);
	//int nbConnexion;
	Connection connect = null;

	public FenetreUtilisateur(Connection conn){
		this.connect = conn;
	}
	public FenetreUtilisateur(){
		this.setTitle("Connexion");
		this.setSize(380, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//Création du panel contenant les champs de saisie du nom d'utilisateur et du mot de passe
		JPanel container = new JPanel();
		JPanel panelNom = new JPanel();
		panelNom.setLayout(new GridLayout(1,2));
		JPanel panelPasswd = new JPanel();
		panelPasswd.setLayout(new GridLayout(1,2));
		nomUtilisateur.setPreferredSize(new Dimension(40,30));
		Font police = new Font("Calibri", Font.BOLD, 12);
		nomUtilisateur.setFont(police);
		nomUtilisateur.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel labelNom = new JLabel("Nom d'utilisateur : ");
		panelNom.add(labelNom);
		panelNom.add(nomUtilisateur);
		passwd.setPreferredSize(new Dimension(40,30));
		JLabel labelPasswd = new JLabel("Mot de passe ");
		panelPasswd.add(labelPasswd);
		panelPasswd.add(passwd);
		passwd.setFont(police);
		passwd.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		//Création des boutons s'inscrire et se connecter 
		JButton inscrire = new JButton("S'inscrire");
		JButton connecter = new JButton("Se connecter");
		inscrire.setPreferredSize(new Dimension(170, 30));
		inscrire.addActionListener(this);
		connecter.setPreferredSize(new Dimension(170, 30));
		connecter.addActionListener(this);
		//Ajout du panel des noms, des password et celui des boutons
		panelButton.add(inscrire);
		panelButton.add(connecter);
		container.add(panelNom);
		container.add(panelPasswd);
		container.add(panelButton);
		this.setContentPane(container);
	}
	
	//Cette fonction permet de vérifier si le mot de passe et le nom d'utlisateur sont correctes
	public ResultSet selectNom_motDePasse(){
		ResultSet resultat = null;
		try {
			resultat = this.connect.createStatement().executeQuery("Select nom, motDePasse from utilisateur");
		}catch (SQLException e) { 
            e.printStackTrace();
        }
		return resultat;
	}

	public boolean verifierSaisie(){
		ResultSet result = (new FenetreUtilisateur(Connexion.getInstance())).selectNom_motDePasse();
		boolean valRetour = false;
		try{
			while(result.next()){
				if(result.getString(1).equals(nomUtilisateur.getText())&& result.getString(2).equals(String.valueOf(passwd.getPassword()))){
					valRetour = true;
				}
			}
		}catch (SQLException e) { 
            e.printStackTrace();
        }
		return valRetour;
	}

	public void actionPerformed(ActionEvent e){
		//int nbTentative = 1;
		if (e.getActionCommand().equals("S'inscrire")){
			Inscription ins = new Inscription();
			ins.setVisible(true);
			dispose();
		}
		else{
			GestionEtudiant gestion = new GestionEtudiant();
			if (verifierSaisie()) {
				gestion.setVisible(true);
				dispose();
			}
			else{
				/*if(nbTentative==3){
					FenetreUtilisateur fut = new FenetreUtilisateur();
					fut.setVisible(false);
				}
				else{*/
					//nbTentative ++;
					dispose();
					JOptionPane erreur = new JOptionPane();
					erreur.showMessageDialog(null, "Nom utilisateur ou mot de passe incorrecte", "Erreur", JOptionPane.ERROR_MESSAGE);
					FenetreUtilisateur fut = new FenetreUtilisateur();
					fut.setVisible(true);
				//}
			}
		}
	}
	public static void main(String[] args) {
		FenetreUtilisateur fe = new FenetreUtilisateur();
		fe.setVisible(true);
	}
}