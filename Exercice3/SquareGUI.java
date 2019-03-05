package Exercice3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

public class SquareGUI extends JPanel
{
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	// Attributes...
	private Color color;
	private static int idGenerator = 0;
	private int Id;
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	
	// Ctor
	public SquareGUI(String couleurCase, Map<Object, Object> dm){
		super();
		
		this.color = (Color) ((PieceSquareColor) (dm.get("CouleurCase" + couleurCase))).getColor();
		this.Id = idGenerator++;
		this.setBackground(this.color);
	}
	
	
	// -------------------------------------------------------------------------------------------------
	// @brief
	//  Redéfinition de la méthode de rendu graphique afin de personnaliser le visuel de ce carré
	@Override
	public void paintComponent(Graphics g)
	{
		// draw 1px green border
		int borderWidth = 10;
		g.setColor(new Color(192, 57, 43));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// draw actual square
		g.setColor(this.color);
		g.fillRect(
				borderWidth, // x pos
				borderWidth, // y pos
				this.getWidth() - borderWidth, // width 
				this.getHeight() - borderWidth // height
			);
	}
	
	
	// -------------------------------------------------------------------------------------------------
	// @brief
	//  Getter de l'Id du square
	public int getId() { return this.Id; }
}
