import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class AjouterEtudiant extends JFrame implements ActionListener{
	JTextField nom = new JTextField(15), prenom = new JTextField(15), contact = new JTextField(15);
	JComboBox lesRegions;
	String sexe = "Masculin";
	private JOptionPane inf = new JOptionPane();

	public AjouterEtudiant(){
		this.setTitle("Ajouter Étudiant");
		this.setSize(420, 310);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		JPanel panelNom = new JPanel(), panelPrenom = new JPanel(), panelContact = new JPanel(), panelRegion = new JPanel();
		panelNom.setLayout(new GridLayout(1,2));
		panelPrenom.setLayout(new GridLayout(1,2));
		panelContact.setLayout(new GridLayout(1,2));
		panelRegion.setLayout(new GridLayout(1, 2));

		JLabel labelNom = new JLabel("Nom Étudiant"), labelPrenom = new JLabel("Prénom Étudiant"), 
		labelContact = new JLabel("Contact"), labelSexe = new JLabel("Sexe Étudiant    "), labelRegion = new JLabel("Région de Provenance   ");
		
		nom.setPreferredSize(new Dimension(40,30));
		panelNom.add(labelNom);
		panelNom.add(nom);

		prenom.setPreferredSize(new Dimension(40,30));
		panelPrenom.add(labelPrenom);
		panelPrenom.add(prenom);

		contact.setPreferredSize(new Dimension(40,30));
		panelContact.add(labelContact);
		panelContact.add(contact);

		ButtonGroup group = new ButtonGroup();
		JPanel panelSexe = new JPanel();
		panelSexe.setLayout(new GridLayout( 1,3));
		JRadioButton sexe1 = new JRadioButton("Masculin", true), sexe2 = new JRadioButton("Féminin");
		sexe1.addActionListener(this);
		sexe2.addActionListener(this);
		group.add(sexe1);
		//panelRadio.add(sexe1);
		group.add(sexe2);
		//panelRadio.add(sexe2);
		panelSexe.add(labelSexe);
		panelSexe.add(sexe1);
		panelSexe.add(sexe2);
		//panelSexe.add(group);

		String[] regions = {"Savane", "Kara", "Centrale", "Plateaux", "Maritime"};
		lesRegions = new JComboBox(regions);
		lesRegions.addActionListener(this);
		panelRegion.add(labelRegion);
		panelRegion.add(lesRegions);

		JPanel contenu = new JPanel();
		//GridLayout grid = new GridLayout(5,1);
		//grid.setVgap(20);
		contenu.setLayout(new GridLayout(5,1));
		Border bordure = BorderFactory.createTitledBorder("Informations Étudiant");
		contenu.setBorder(bordure);
		//contenu.setBackground(Color.yellow);
		contenu.add(panelNom);
		contenu.add(panelPrenom);
		contenu.add(panelContact);
		contenu.add(panelRegion);
		contenu.add(panelSexe);

		JPanel panelBouton = new JPanel();
		//panelBouton.setBackground(Color.yellow);
		JButton retour = new JButton("Retour");
		panelBouton.add(retour);
		retour.addActionListener(this);
		JButton effacer = new JButton("Effacer");
		panelBouton.add(effacer);
		effacer.addActionListener(this);
		JButton valider = new JButton("Valider");
		panelBouton.add(valider);
		valider.addActionListener(this);
		this.add(contenu, BorderLayout.NORTH);
		this.add(panelBouton, BorderLayout.SOUTH);
	}
	/*public void creerEtudiant(){
				Etudiant unEtudiant = new Etudiant(nom.getText(), prenom.getText(), contact.getText(), lesRegions.getSelectedItem(), sexe);
				Etudiant etudiant = new Etudiant(Connexion.getInstance());
				etudiant.enregistrerEtudiant(unEtudiant);
	}*/
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Féminin")) {
			sexe = "Féminin";
		}
		if(e.getActionCommand().equals("Valider")){
			if (nom.getText().equals("")||prenom.getText().equals("")||contact.getText().equals("")) {
				inf.showMessageDialog(null, "Vous devez renseigner tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else {
				//String region = String.valueOf(lesRegions.getSelectedItem());
				//System.out.println(lesRegions.getSelectedItem());
				Etudiant unEtudiant = new Etudiant(nom.getText(), prenom.getText(), contact.getText(), String.valueOf(lesRegions.getSelectedItem()), sexe);
				Etudiant etudiant = new Etudiant(Connexion.getInstance());
				etudiant.enregistrerEtudiant(unEtudiant);
				//creerEtudiant();
				dispose();
				inf.showMessageDialog(null, "Étudiant enregitré avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
				AjouterEtudiant ae = new AjouterEtudiant();
				ae.setVisible(true);
			}
		}
		else if (e.getActionCommand().equals("Effacer")){
			nom.setText("");
			prenom.setText("");
			contact.setText("");
		}
		else if(e.getActionCommand().equals("Retour")){
			GestionEtudiant gestion = new GestionEtudiant();
			gestion.setVisible(true);
			dispose();
		}
	}

	public static void main(String[] args) {
		AjouterEtudiant ajouter = new AjouterEtudiant();
		ajouter.setVisible(true);
	}
}