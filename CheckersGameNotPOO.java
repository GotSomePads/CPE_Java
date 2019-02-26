import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckersGameNotPOO 
{
	private static int windowHeight = 600;
	private static int windowWidth = 600;
	private static int nbCaseHeight = 10;
	private static int nbCaseWidth = 10; 
	private static Color blackColour = Color.BLACK;
	private static Color blackPionColour = new Color(104, 109, 224);
	private static Color whiteColour = Color.WHITE;
	private static Color whitePionColour = new Color(236, 240, 241);
	
	public static void main(String[] args)
	{
		// 1) création de la frame dans laquelle le jeu se passera
		JFrame frame = new JFrame();
		frame.setTitle("No POO");
		frame.setPreferredSize(new Dimension(windowWidth, windowHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		
		// 1.2) affichage de la fenêtre au centre de l'écran
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		// 1.3) setup du layout
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(nbCaseHeight, nbCaseWidth));
		mainPanel.setPreferredSize(new Dimension(windowWidth, windowHeight));
		frame.add(mainPanel);
		
		// 2) ajout des différents éléments visuels de jeu
		setBackgroundCheckersBoard(nbCaseHeight, nbCaseWidth, mainPanel);
		setPiecesCheckerBoard(mainPanel);
		
		// finalement, lancer le rendu !
		frame.setVisible(true);
	}
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Crée un damier de taille 'h' par 'w' dans le JPanel 'p'
	private static void setBackgroundCheckersBoard(int h, int w, JPanel p)
	{ 
		int panelHeight = p.getHeight() / h;
		int panelWidth = p.getWidth() / w;
		
		for(int i = 0 ; i < h ; i++){
			for(int j = 0 ; j < w ; j++){
				JPanel panel = new JPanel();
				panel.setPreferredSize(new Dimension(panelHeight, panelWidth));
				
				if((j+i) % 2 == 1)
					panel.setBackground(blackColour);
				else
					panel.setBackground(whiteColour);
				
				p.add(panel);
			}
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Ajoute les pièce du jeu de dame dans le JPanel 'p'
	private static void setPiecesCheckerBoard(JPanel p)
	{
		int pionHeight = (int) ((windowHeight / nbCaseHeight) * 0.75);
		int pionWidth = (int) ((windowWidth / nbCaseWidth) * 0.75);
		System.out.println("pion height : " + pionHeight);
		
		// fill pion du joueur black
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < nbCaseWidth ; j++){
				JPanel currentCase = (JPanel)(p.getComponent(i*10 + j));
				
				if(currentCase.getBackground() == blackColour)
					currentCase.add(createPion(pionWidth, pionHeight, blackPionColour));
			}
		}
		
		// fill pion du joueur bland
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < nbCaseWidth ; j++){
				JPanel currentCase = (JPanel)(p.getComponent((nbCaseHeight-1-i)*10 + j));
				log("adding to "+(int)((nbCaseHeight-1)*10 + j));
				
				if(currentCase.getBackground() == blackColour)
					currentCase.add(createPion(pionWidth, pionHeight, whitePionColour));
			}
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Crée un pion de jeu de dames, de couleur 'colour'
	private static JPanel createPion(int pionWidth, int pionHeight, Color colour)
	{
		JPanel pion = new JPanel();
		pion.setBackground(colour);
		pion.setPreferredSize(new Dimension(pionWidth, pionHeight));
		return pion;
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Easy debug boii
	private static void log(String text) { System.out.println(text); }

}
