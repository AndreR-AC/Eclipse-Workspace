package snakegame;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Creates a game panel with and sets some settings
	 * @param gamePanel game window
	 */
	public GameFrame(GamePanel gamePanel) {
		
		this.add(gamePanel);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
