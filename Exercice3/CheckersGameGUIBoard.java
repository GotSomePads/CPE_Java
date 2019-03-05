package Exercice3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JPanel;


public class CheckersGameGUIBoard extends JPanel 
{
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	private JPanel selectedPieceGUI;
	
	// sizes
	private int windowHeight = 600;
	private int windowWidth = 600;
	private int tailleCase;
	
	private Map<Object, Object> dataMap;
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Ctor
	public CheckersGameGUIBoard(Map<Object, Object> dm) 
	{
		super();
		
		this.dataMap = dm;
		
		// setup du layout
		this.tailleCase = (int) this.dataMap.get("Taille");
		this.setLayout(new GridLayout(tailleCase, tailleCase));
		
		Dimension dim = new Dimension(windowWidth, windowHeight);
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setMinimumSize(dim);
		
		// init GUI
		this.setBackgroundCheckersBoard(tailleCase, tailleCase);
		this.setPiecesCheckerBoard();
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Crée un damier de taille 'h' par 'w' dans le main panel
	private void setBackgroundCheckersBoard(int h, int w)
	{ 
		int panelHeight = windowHeight / h;
		int panelWidth = windowWidth / w;
		
		JPanel panel;
		CaseListener listener = new CaseListener();
		for(int i = 0 ; i < tailleCase ; i++){
			for(int j = 0 ; j < tailleCase ; j++)
			{
				if((j+i) % 2 == 1)
					panel = new SquareGUI("Noire", this.dataMap);
				else
					panel = new SquareGUI("Blanche", this.dataMap);
				
				panel.setSize(panelWidth, panelHeight);
				panel.addMouseListener(listener);
				this.add(panel);
			}
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Ajoute les pièce du jeu de dame dans le main panel
	private void setPiecesCheckerBoard()
	{
		int pionHeight = (int) ((windowHeight / tailleCase) * 0.75);
		int pionWidth = (int) ((windowWidth / tailleCase) * 0.75);
		
		Color couleurCaseNoire = (Color) ((PieceSquareColor) (this.dataMap.get("CouleurCaseNoire"))).getColor();
		
		// useful variables
		PieceListener pl = new PieceListener();
		PieceGUI piece;
		JPanel currentCase;
		
		// fill pion du joueur black
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < tailleCase ; j++)
			{
				currentCase = (JPanel)(this.getComponent(i*10 + j));	
				if(currentCase.getBackground() == couleurCaseNoire){
					piece = new PieceGUI("Noire", this.dataMap);
					piece.setPreferredSize(new Dimension(pionWidth, pionHeight));
					piece.addMouseListener(pl);
					currentCase.add(piece);
				}
			}
		}
		
		// fill pion du joueur blanc
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < tailleCase ; j++)
			{
				currentCase = (JPanel)(this.getComponent((tailleCase-1-i)*10 + j));
				if(currentCase.getBackground() == couleurCaseNoire){
					piece = new PieceGUI("Blanche", this.dataMap);
					piece.setPreferredSize(new Dimension(pionWidth, pionHeight));
					piece.addMouseListener(pl);
					currentCase.add(piece);
				}
			}
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Ajoute la pièce 'pion' sur la case 'destination'
	private void addPieceOnSquare(JPanel pion, JPanel destination) { destination.add(pion); }
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Bouge la pièce 'pion'
	private void movePiece(JPanel pion, JPanel destination)
	{
		// si la destination se trouve en diagonale de la pièce, alors on la bouge
		// ...
		
		JPanel caseDepart = (JPanel) pion.getParent();
		this.addPieceOnSquare(pion, destination);
		// repaint panels
		caseDepart.revalidate();
		caseDepart.repaint();
		destination.repaint();
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Setter de l'attribute 'selectedPieceGUI'
	private void setSelectedPiece(JPanel pieceGUI) { this.selectedPieceGUI = pieceGUI; }
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Getter de l'attribute 'selectedPieceGUI'
	public JPanel getSelectedPiece() { return this.selectedPieceGUI; }
	
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	// @brief
	//  Classe s'occupant de la gestion d'un clic sur une pièce
	class PieceListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent event) { setSelectedPiece((JPanel) event.getSource()); }

		@Override
		public void mouseEntered(MouseEvent arg0) { }

		@Override
		public void mouseExited(MouseEvent arg0) { }

		@Override
		public void mousePressed(MouseEvent arg0) { }

		@Override
		public void mouseReleased(MouseEvent arg0) { }
	}
	
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	// @brief
	//  Classe s'occupant de la gestion d'un clic sur une case
	class CaseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent event) 
		{
			// on ne peut déplacer dans une case que si celle-ci est vide
			JPanel p = (JPanel) event.getSource();
			if(p.getComponentCount() == 0 && getSelectedPiece() != null){
				movePiece(getSelectedPiece(), p);
				setSelectedPiece(null);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) { }

		@Override
		public void mouseExited(MouseEvent arg0) { }

		@Override
		public void mousePressed(MouseEvent arg0) { }

		@Override
		public void mouseReleased(MouseEvent arg0) { }
	}
}

