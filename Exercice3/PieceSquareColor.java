package Exercice3;

import java.awt.Color;

public enum PieceSquareColor {
	
	// -----------------------------------------------------------------------------
	
	BLANC(Color.WHITE),
	NOIR(Color.BLACK),
	TEST(Color.GREEN),
	BLACK_PION(new Color(104, 109, 224)),
	WHITE_PION(new Color(236, 240, 241));
	
	// -----------------------------------------------------------------------------
	
	private Color color;
	
	// Ctors
	private PieceSquareColor(Color c) { this.color = c; }
	private PieceSquareColor(int r, int g, int b) { this.color = new Color(r, g, b); }
	
	// getter
	public Color getColor() { return this.color; }
	
}
