package Exercice3;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class CheckersGameGUI extends JFrame implements Observer
{
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	private JPanel checkersBoard; // le damier
	private JMenuBar menuBar; // la barre de menu
	private Map<Object, Object> dataMap; // données du jeu
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Ctor
	public CheckersGameGUI() {
		super();
		
		setSize(600,600);
		
		this.dataMap = CheckersGameGUIDataFactory.createCheckersGameGUIData();
		
		this.checkersBoard = new CheckersGameGUIBoard(this.dataMap);
		this.setContentPane(checkersBoard);
		
		this.menuBar = new CheckersGameGUIMenu(this.dataMap);
		this.setJMenuBar(menuBar);
	}

	
	// -------------------------------------------------------------------------------------------
	//@brief
	// Fonction appelée lorsqu'un observable génère un évènement : la vue se recharge entièrement
	@Override
	public void update(Observable arg0, Object arg1) {
		this.invalidate();
		this.validate();
		this.repaint();
		
	}
}
