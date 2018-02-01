package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Die Klasse beinhaltet eine paintComponent Methode hier wird der Hintergrund für das DeinePizzaFrame und das PizzaKlassikerFrame gezeichnet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JPanel
 */
public class PizzaAuswahlDrawPanel extends JPanel {
		
			private static final long serialVersionUID = 1L;
			
			private  ImageIcon logo = new ImageIcon(getClass().getResource("../img/logo-klein.png"));
			private  ImageIcon background = new ImageIcon(getClass().getResource("../img/background.jpg"));
			private  ImageIcon border = new ImageIcon(getClass().getResource("../img/border.jpg"));

		
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0,0,null);
				g.drawImage(border.getImage(), 0,95,null);
				
				g.drawImage(border.getImage(), 0,155,null);				
				g.drawImage(logo.getImage(), 10,5,null);

			}
		
}
