import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionEtudiant extends JFrame implements ActionListener{

	public GestionEtudiant(){
		this.setTitle("Gestion Etudiant");
		this.setSize(420, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		JLabel indication1 = new JLabel("Cliquez sur Ajouter pour ajouter un Eleve");
		JLabel indication2 = new JLabel("Cliquez sur AfficherEtudiants pour afficher tous les Étudiants");
		JPanel panelIndication = new JPanel();
		GridLayout grid = new GridLayout(2,1);
		grid.setVgap(10);
		panelIndication.setLayout(grid);
		panelIndication.add(indication1);
		panelIndication.add(indication2);
		add(panelIndication, BorderLayout.NORTH);
		JPanel panelGestion = new JPanel();
		panelGestion.setLayout(new FlowLayout());
		JButton ajouter = new JButton("Ajouter"), afficher = new JButton("AfficherEtudiants"), quitter = new JButton("Quitter");
		ajouter.addActionListener(this);
		panelGestion.add(ajouter);
		afficher.addActionListener(this);
		panelGestion.add(afficher);
		quitter.addActionListener(this);
		panelGestion.add(quitter);
		add(panelGestion, BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Ajouter")) {
			AjouterEtudiant ajoutEtudiant = new AjouterEtudiant();
			ajoutEtudiant.setVisible(true);
			dispose();
		}
		else if (e.getActionCommand().equals("AfficherEtudiants")){
			AfficherLesEtudiants afficherEleves = new AfficherLesEtudiants();
			afficherEleves.setVisible(true);
			dispose();
		}
		else {
			System.exit(0);
		}
	}
}