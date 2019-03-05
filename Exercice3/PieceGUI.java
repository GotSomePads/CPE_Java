package Exercice3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

import Exercice3.CheckersGameGUIBoard.PieceListener;

public class PieceGUI extends JPanel
{
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Attributes...
	private Color color;
	private String forme;
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	
	// Ctor
	public PieceGUI(String couleurPion, Map<Object, Object> dm){
		super();
		
		this.color = (Color) ((PieceSquareColor) (dm.get("CouleurPion" + couleurPion))).getColor();
		this.forme = (String) dm.get("Forme");
		this.setBackground(this.color);
	}
	
	
	// -------------------------------------------------------------------------------------------------
	// @brief
	//  Redéfinition de la méthode de rendu graphique afin de personnaliser le visuel d'un pion
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(this.color);
		
		switch(this.forme){
			case "carre":
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				break;
				
			case "rond":
				g.fillOval(0, 0, this.getWidth(), this.getHeight());
				break;
				
			case "triangle":
				g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
				break;
				
			default:
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				break;
		}
	}
}
