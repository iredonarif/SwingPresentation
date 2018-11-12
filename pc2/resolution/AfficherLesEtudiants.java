import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class AfficherLesEtudiants extends JFrame implements ActionListener{

	public AfficherLesEtudiants(){
		setTitle("Informations des Étudiants");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//getContentPane().setBackground(Color.yellow);
		//setLayout(new BorderLayout());
		//this.setResizable(false);
		Object[][] lesDonnees = null;
		ArrayList<String[]> donnees = new ArrayList<String[]>();
		String titre[] = {"NomEtudiant", "Prénom", "Contacte", "Région", "Sexe"};
		try{
			ResultSet result = Connexion.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("Select * from etudiant ");
			while(result.next()){
				String[] eleve = {String.valueOf(result.getString(1)), result.getString(2), result.getString(3), result.getString(4),result.getString(5)}; 
				donnees.add(eleve);
			}
		}
		catch (SQLException e) { 
	            e.printStackTrace();
	    }
	    lesDonnees = new String[donnees.size()][];
	    donnees.toArray(lesDonnees);
	    JTable tableau = new JTable(lesDonnees, titre);
	    JPanel panelTableau = new JPanel();
	    panelTableau.setLayout(new BorderLayout());
	    panelTableau.add(new JScrollPane(tableau), BorderLayout.CENTER);
	    //add(panelTableau, BorderLayout.NORTH);
	    //add(panelTableau, BorderLayout.CENTER);
	    //this.getContentPane().add(new JScrollPane(tableau));
	    JButton retour = new JButton("Retour");
	    retour.addActionListener(this);
	    retour.setPreferredSize(new Dimension(170, 30));
	    panelTableau.add(retour, BorderLayout.SOUTH);
	    add(panelTableau);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Retour")) {
			GestionEtudiant gestion = new GestionEtudiant();
			gestion.setVisible(true);
			dispose();
		}
	}

}