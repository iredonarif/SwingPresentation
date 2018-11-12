import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Devinette extends JFrame implements ActionListener{
	JTextField nombre = new JTextField(15);
	JLabel labelNombre = new JLabel("  Entrez un nombre dans l'intervalle de 10 à 100");
	JOptionPane message = new JOptionPane();
	int nbAleatoire = (int)(10 + (100 - 10) * Math.random());
	int min = 10, max = 100;
	int nbTentative = 1;

	public Devinette(){
		this.setTitle("Jeu Devinette");
		this.setSize(430, 230);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panelLabelNbre = new JPanel();
		JPanel panelNbre = new JPanel();
		GridLayout grid = new GridLayout(2,1);
		grid.setVgap(12);
		panelLabelNbre.setLayout(grid);
		panelLabelNbre.add(labelNombre);
		Font police = new Font("Calibri", Font.BOLD, 12);
		nombre.setFont(police);
		nombre.setPreferredSize(new Dimension(40, 30));
		nombre.setBorder(BorderFactory.createLineBorder(Color.black));
		panelNbre.add(nombre);
		panelNbre.setBackground(Color.gray);
		panelLabelNbre.add(panelNbre);
		panelLabelNbre.setBackground(Color.gray);
		this.add(panelLabelNbre, BorderLayout.CENTER);
		JPanel panelBouton = new JPanel();
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(this);
		panelBouton.add(quitter);
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		panelBouton.add(ok);
		panelBouton.setBackground(Color.blue);
		this.add(panelBouton, BorderLayout.SOUTH);
	}

	public void inf(){
		message.showMessageDialog(null,"La valeur à trouver est inférieure", "Erreur",  JOptionPane.ERROR_MESSAGE);
		nombre.setText("");
	    nbTentative ++ ;
	}
	public void sup(){
		message.showMessageDialog(null, "La valeur à trouver est supérieure", "Erreur",  JOptionPane.ERROR_MESSAGE);
		nombre.setText("");
	    nbTentative ++ ;
	}
	public void egal(){
		nombre.setText("");
		message.showMessageDialog(null, "Gagné ! Vous aviez trouvez le nombre en "+nbTentative+" coups", "Information",  JOptionPane.INFORMATION_MESSAGE);
		nbAleatoire = (int)(10 + (100 - 10) * Math.random());
		nbTentative = 1;
	}

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("OK")){
			int nbre = 0;
			try{
				nbre = Integer.parseInt(nombre.getText());
				System.out.println(nbTentative);
				System.out.println(nombre.getText()+" "+nbAleatoire);
				if(nbre < nbAleatoire)
					sup();
				else if (nbre > nbAleatoire)
					inf();
				else egal();
			} catch(NumberFormatException ex){
				message.showMessageDialog(null, "Vous devez entrer un nombre", "ERREUR",  JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		Devinette dev = new Devinette();
		dev.setVisible(true);
	}
}
