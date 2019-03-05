package Exercice3;
import javax.swing.JFrame;

public class CheckersGamePOOLauncher 
{
	public CheckersGamePOOLauncher(){
		JFrame frame = new CheckersGameGUI();
		
		frame.setTitle("Ceci est la fenêtre de mon jeu de dames - Version POO");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
