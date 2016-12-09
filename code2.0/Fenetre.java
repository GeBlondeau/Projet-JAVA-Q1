/**
 * 
 */
package interfacegraphique;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.BorderLayout;
import javax.swing.JButton;
/**
 * @author Gérault
 *
 */
public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JPanel pan = new JPanel();

	
	public Fenetre(){
		this.setTitle("Ephecopoly");
		this.setSize(600, 200);
		this.setLocation(500, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(new JButton("Etudier le cours"), BorderLayout.EAST);
		this.getContentPane().add(new JButton("Rien faire"), BorderLayout.WEST);
		this.getContentPane().add(new JButton("Lancer les Dés"), BorderLayout.SOUTH);
		
		this.setVisible(true);
	
	}
	public void paintComponent(Graphics g){
		 g.drawString("Bonne partie! Amusez vous bien. Noé et Gérault", 150, 20);
	}
	public static void main(String[] args){
		new Fenetre();
	}
}
