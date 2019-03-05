package Exercice3;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class CheckersGameGUIMenu extends JMenuBar 
{
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Attributes...
	private Map<Object, Object> dataMap;
	private JMenu parametres;
	private JMenuItem couleurCaseBlanche;
	private JMenuItem couleurCaseNoire;
	private JMenu formePion;
	private JMenuItem forme_carre;
	private JMenuItem forme_rond;
	private JMenuItem forme_triangle;
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Ctor
	public CheckersGameGUIMenu(Map<Object, Object> dm){
		super();
		
		this.dataMap = dm;
		
		this.parametres = new JMenu("Paramètres d'affichage");
		this.formePion = new JMenu("Forme des pions");
		
		// ===========================================================================================
		// ====================================== MENU ACTIONS =======================================
		// couleur des cases du joueur blanc
		this.couleurCaseBlanche = new JMenuItem(new AbstractAction("Couleur cases blanches"){
			public void actionPerformed(ActionEvent e)
			{
				Color couleur = JColorChooser.showDialog(null, "Couleur des cases blanches", Color.WHITE);
				dataMap.put("CouleurCaseBlanche", couleur);
			}
		});
		
		// couleur des cases du joueur noir
		this.couleurCaseNoire = new JMenuItem(new AbstractAction("Couleur cases noires"){
			public void actionPerformed(ActionEvent e)
			{
				Color couleur = JColorChooser.showDialog(null, "Couleur des cases blanches", Color.WHITE);
				dataMap.put("CouleurCaseNoire", couleur);
			}
		});
		
		// forme des pions : carré
		this.forme_carre = new JMenuItem(new AbstractAction("Carré"){
			public void actionPerformed(ActionEvent e)
			{
				dataMap.put("Forme", "carre");
			}
		});
		
		// forme des pions : rond
		this.forme_rond = new JMenuItem(new AbstractAction("Rond"){
			public void actionPerformed(ActionEvent e)
			{
				dataMap.put("Forme", "rond");
			}
		});

		// forme des pions : triangle
		this.forme_triangle = new JMenuItem(new AbstractAction("Triangle"){
			public void actionPerformed(ActionEvent e)
			{
				dataMap.put("Forme", "triangle");
			}
		});
		// ===========================================================================================
		// ===========================================================================================
		
		// add menu items mamene
		this.add(parametres);
		this.parametres.add(couleurCaseBlanche);
		this.parametres.add(couleurCaseNoire);
		this.parametres.add(formePion);
		this.formePion.add(forme_carre);
		this.formePion.add(forme_rond);
		this.formePion.add(forme_triangle);
	}
}
