package settings;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Diese Klasse beinhaltet globale Variablen und Methoden, die in verschiedenen Stellen der View
 * als auch des Presenters genutzt werden. 
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 *
 */
public class Settings {
	
	
	//Screen Size
	public static int SCREEN_WIDTH = 414;
	public static int SCREEN_HEIGTH = 736;
	
	public JLabel SMALL_SIZE = new JLabel("S 25cm  ");
	public JLabel MEDIUM_SIZE = new JLabel("M 32cm  ");
	public JLabel LARGE_SIZE = new JLabel("L 38cm  ");
	public JLabel EXTRALARGE_SIZE = new JLabel("XL 48cm  ");
	
	
	// Der Warenwert für den Warenkorb
	public static JLabel cartPriceLabel = new JLabel ("0.00");
	
	/**
	 * Wird zum Verändern der Schrift im allgemeinen genutzt.
	 * 
	 * @param sizeLabel, welches verändert werden soll
	 */
	public static void changeSizeFont (JLabel sizeLabel) {
		sizeLabel.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 15));
		sizeLabel.setForeground(Color.WHITE);
	}
	
	//Zutaten umändern
	/**
	 * Wird zum Verändern der Schrift der Zutaten-Labels genutzt.
	 * 
	 * @param sizeLabel, welches verändert werden soll
	 */
	public static void changeSizeFontIngredient (JLabel sizeLabel) {
		sizeLabel.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 11));
		sizeLabel.setForeground(Color.WHITE);
	}
	
	/**
	 * Dies sind die Getter für die entsprechenden Labels.
	 * 
	 * @return SMALL_SIZE, MEDIUM_SIZE, LARGE_SIZE, EXTRALARGE_SIZE, cartPriceLabel
	 */
	public JLabel getSMALL_SIZE() {
		return SMALL_SIZE;
	}
	
	public JLabel getMEDIUM_SIZE() {
		return MEDIUM_SIZE;
	}
	public JLabel getLARGE_SIZE() {
		return LARGE_SIZE;
	}
	
	public JLabel getEXTRALARGE_SIZE() {
		return EXTRALARGE_SIZE;
	}
	
	public JLabel getCartPriceLabel() {
		return cartPriceLabel;
	}
	
	
	
	
	
}
