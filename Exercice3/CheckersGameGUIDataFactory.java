package Exercice3;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class CheckersGameGUIDataFactory extends Observable 
{
	// Ctor
	private CheckersGameGUIDataFactory() { }
	
	// -----------------------------------------------------------------------------------------
	// @brief
	//  Initialise la map des données du jeu
	public static Map<Object, Object> createCheckersGameGUIData()
	{
		CheckersGameGUIData map = new CheckersGameGUIData();
		
		map.put("CouleurCaseNoire", PieceSquareColor.NOIR);
		map.put("CouleurCaseBlanche", PieceSquareColor.BLANC);
		map.put("CouleurPionNoire", PieceSquareColor.BLACK_PION);
		map.put("CouleurPionBlanche", PieceSquareColor.WHITE_PION);
		map.put("Taille", 10);
		map.put("Forme", "carre");
		
		return map;
	}
}
