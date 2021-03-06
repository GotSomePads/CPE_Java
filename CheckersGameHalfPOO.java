import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckersGameHalfPOO 
{		
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	private JFrame frame;
	private JPanel checkersBoard;
	private JPanel selectedPieceGUI;
	
	// sizes
	private static int windowHeight = 600;
	private static int windowWidth = 600;
	private static int nbCaseHeight = 10;
	private static int nbCaseWidth = 10;
	
	// colours
	private static Color blackColour = Color.BLACK;
	private static Color blackPionColour = new Color(104, 109, 224);
	private static Color whiteColour = Color.WHITE;
	private static Color whitePionColour = new Color(236, 240, 241);
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Ctor
	public CheckersGameHalfPOO(){
		this.selectedPieceGUI = null;
		
		// construction et paramétrage de la fenêtre
		this.initFrame();
		
		// construction et remplissage du damier
		initBoard();
		
		// finalement, lancement du rendu !
		frame.setVisible(true);
	}
	
	// ---------------------------------------------------------------------------------------------------------
	// @brief
	//  Initialise la frame 'frame' en créant une fenêtre située au centre de l'écran
	private void initFrame()
	{
		// 1) création de la frame dans laquelle le jeu se passera
		frame = new JFrame();
		frame.setTitle("No POO");
		frame.setPreferredSize(new Dimension(windowWidth, windowHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		
		// 1.2) affichage de la fenêtre au centre de l'écran
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
	
	
	// ---------------------------------------------------------------------------------------------------------
	// @brief
	//  Initialise le plateau de jeu en 1) créant le damier et 2) plaçant les pièce en jeu !
	private void initBoard()
	{
		// setup du layout
		checkersBoard = new JPanel();
		checkersBoard.setLayout(new GridLayout(nbCaseHeight, nbCaseWidth));
		checkersBoard.setPreferredSize(new Dimension(windowWidth, windowHeight));
		frame.add(checkersBoard);
		
		// ajout des différents éléments visuels de jeu
		setBackgroundCheckersBoard(nbCaseHeight, nbCaseWidth);
		setPiecesCheckerBoard();
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Crée un damier de taille 'h' par 'w' dans le main panel
	private void setBackgroundCheckersBoard(int h, int w)
	{ 
		int panelHeight = checkersBoard.getHeight() / h;
		int panelWidth = checkersBoard.getWidth() / w;
		
		JPanel panel;
		CaseListener listener = new CaseListener();
		for(int i = 0 ; i < h ; i++){
			for(int j = 0 ; j < w ; j++){
				panel = new JPanel();
				panel.setPreferredSize(new Dimension(panelHeight, panelWidth));
				panel.addMouseListener(listener);
				
				if((j+i) % 2 == 1)
					panel.setBackground(blackColour);
				else
					panel.setBackground(whiteColour);
				
				checkersBoard.add(panel);
			}
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Ajoute les pièce du jeu de dame dans le main panel
	private void setPiecesCheckerBoard()
	{
		int pionHeight = (int) ((windowHeight / nbCaseHeight) * 0.75);
		int pionWidth = (int) ((windowWidth / nbCaseWidth) * 0.75);
		
		// fill pion du joueur black
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < nbCaseWidth ; j++){
				JPanel currentCase = (JPanel)(checkersBoard.getComponent(i*10 + j));
				
				if(currentCase.getBackground() == blackColour)
					currentCase.add(createPion(pionWidth, pionHeight, blackPionColour));
			}
		}
		
		// fill pion du joueur blanc
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < nbCaseWidth ; j++){
				JPanel currentCase = (JPanel)(checkersBoard.getComponent((nbCaseHeight-1-i)*10 + j));
				
				if(currentCase.getBackground() == blackColour)
					currentCase.add(createPion(pionWidth, pionHeight, whitePionColour));
			}
		}
	}
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Crée un pion de jeu de dames, de couleur 'colour'
	private JPanel createPion(int pw, int ph, Color colour)
	{
		JPanel pion = new JPanel();
		pion.setBackground(colour);
		pion.setPreferredSize(new Dimension(pw, ph));
		pion.addMouseListener(new PieceListener());
		return pion;
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
	
	
	// ----------------------------------------------------------------------------------
	// @brief
	//  Easy debug boii
	private void log(String text) { System.out.println(text); }
	
	
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