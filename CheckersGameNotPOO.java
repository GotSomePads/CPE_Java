import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckersGameNotPOO 
{
	private static int nbCaseHeight = 10;
	private static int nbCaseWidth = 10;
	
	public static void main(String[] args)
	{
		// 1) création de la frame dans laquelle le jeu se passera
		JFrame frame = new JFrame();
		frame.setTitle("No POO");
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		// 1.2) affichage de la fenêtre au centre de l'écran
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		// 2) ajout des différents éléments visuels de jeu
		frame.setLayout(new GridLayout(nbCaseHeight, nbCaseWidth));
		setBackgroundCheckersBoard(nbCaseHeight, nbCaseWidth, frame);
		setPiecesCheckerBoard(frame);
	}
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Crée un damier de taille 'h' par 'w' dans la JFrame 'frame'
	private static void setBackgroundCheckersBoard(int h, int w, JFrame frame)
	{ 
		int panelHeight = frame.getHeight() / h;
		int panelWidth = frame.getWidth() / w;
		System.out.println("height : " +panelHeight);
		System.out.println("width: " + panelWidth + "\n");
		int compteur = 0;
		
		for(int i = 0 ; i < h ; i++){
			for(int j = 0 ; j < w ; j++){
				JPanel panel = new JPanel();
				panel.setPreferredSize(new Dimension(panelHeight, panelWidth));
				
				if(compteur++ % 2 == 0)
					panel.setBackground(Color.BLUE);
				
				frame.add(panel);
			}
			compteur++;
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Ajoute les pièce du jeu de dame dans la JFrame 'frame'
	private static void setPiecesCheckerBoard(JFrame frame)
	{
		
	}

}
