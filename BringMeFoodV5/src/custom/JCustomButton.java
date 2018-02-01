package custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/**
 * 	Die Klasse stellt einen selbsterstellten Button dar.
 *  Der Button ist abgerundet, hat einen schwarzen Rand, weißen Hintergrund und eine rote Schrift.
 * 	Hier wurde mit dem MouseListener gearbeitet, um seinen Nutzen zu erweitern.
 * 
 * @author Sean , Kevin, Daniyal, Farid, Sven
 * @see JButton
 * @see MouseListener
 */
public class JCustomButton extends JButton implements MouseListener {
	
	private static final long serialVersionUID = 1L;

	Dimension size = new Dimension(140, 33);
	
	boolean hover = false;
	boolean click = false;

	/**
	 * Dieser Konstruktor nimmt einen Parameter entgegen.
	 * Hiermit kann ein JCustomButton erstellt werden.
	 * 
	 * @param text für den Text auf dem Button
	 */
    public JCustomButton (String text){
        super(text);
        setVisible(true);
		setFocusable(true);
		setContentAreaFilled(false);
		setBorderPainted(true);
		setBorder(null);  
    }
    
    /**
     * Diese Methode erzeugt das Aussehen des Buttons.
     * 
     * @param g2 ist das Grafik-Objekt, dass schließlich den Button darstellt und an die Superklasse weitergegeben wird
     */
    public void paintComponent(Graphics g2) {
    	super.paintComponent(g2);
		Graphics2D g3 = (Graphics2D) g2.create();
		g2.setColor(new Color(0, 0, 0));
		g2.fillRoundRect(0,0,getWidth()+0,getHeight()+0,30,30);
		g2.setColor(new Color(255, 255, 255));
		g2.fillRoundRect(3,3,getWidth()-6,getHeight()-6,30,30);
		
		g3.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 18));
		g3.setColor(new Color(253, 45, 45));
		
		FontMetrics metrics = g3.getFontMetrics();
		int width = metrics.stringWidth(getText());
		
		g3.drawString(getText(), 70 - width / 2, 23);
		g3.dispose();
	}
    
    
    /**
     * Gibt die Größen des Buttons zurück
     * @return size
     */
    @Override
	public Dimension getPreferredSize() {
		return size;
	}
	
	@Override
	public Dimension getMaximumSize() {
		return size;
	}
	
	@Override
	public Dimension getMinimumSize() {
		return size;
	}
	
	
	/**
	 * Implementation der MouseListener Methoden
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		hover = true;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		hover = false;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		click = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		click = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

}
