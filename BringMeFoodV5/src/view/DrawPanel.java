package view;

import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Die Klasse beinhaltet eine paintComponent Methode hier wird der Hintergrund für das LoginFrame und das RegisterFrame gezeichnet.
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JPanel
 */
public class DrawPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private  ImageIcon background = new ImageIcon(getClass().getResource("../img/background.jpg"));
	
	URL url = DrawPanel.class.getResource("../img/logo-gross.gif");
    Icon icon = new ImageIcon(url);
    JLabel label = new JLabel(icon);
	
    /**
     * Hier wird das Icon ins Panel(also, dieser Klasse) eingefügt.
     */
	public DrawPanel () {	
		add(label);
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		arg0.drawImage(background.getImage(), 0,0,null);	
	}
}
