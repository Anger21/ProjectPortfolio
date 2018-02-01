
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custom.JCustomButton;
import settings.Settings;
/**
 * Diese Klasse dient als Schnittstelle zwischen Login-, DeinePizza-, PizzaKlassiker- und dem CartFrame, 
 * erstellt entsprechend die GUI-Elemente und nimmt Veränderungen von außen auf. 
 * 
 * 
 * @author Sean , Kevin, Daniyal, Farid, Sven
 * @see JFrame
 * @see JCustomButton
 * @see MainDrawPanel
 * @see Settings
 * @see GridBagLayout
 * @see GridBagConstraints
 * 
 */
public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 3L;
	
	private JButton klassikerButton,deinePizzaButton;
	private JCustomButton logoutButton,cartButton;
	private JPanel buttonPanel, headerPanel;
	
	// Einfügen des DrawPanels (Hintergrund wird gezeichnet)
	MainDrawPanel draw = new MainDrawPanel();
	Settings settings = new Settings();
	
	
	/**
	 * Hier wird das Frame für das/den "Home" erstellt.
	 */
	public MainFrame() {
			super ("Hauptseite");
			// Hintergrund Panel wird hinzugefügt
			add(draw);
			
			// Panel für die Buttons anlegen
			buttonPanel = new JPanel();
			buttonPanel.setOpaque(false);
			
			// Panel für den Headerbereich anlegen
			headerPanel = new JPanel();
			headerPanel.setOpaque(false);
			
			//GridbagLayout anlegen
			GridBagConstraints gbc = new GridBagConstraints();
			headerPanel.setLayout(new GridBagLayout());
			
			// Logout Button im Headerbereich hinzufügen
			logoutButton = new JCustomButton("Logout");
			gbc.gridx = 8;
			gbc.gridy = 0;
			headerPanel.add (logoutButton,gbc);
			
			// Warenkorb Button im Headerbereich hinzufügen
			cartButton = new JCustomButton("Warenkorb");
			gbc.insets = new Insets(5,0,0,0);
			gbc.gridy = 1;
			headerPanel.add (cartButton,gbc);
			
			// Label für den Warenkorb Preis im Headerbereich hinzufügen
			settings.getCartPriceLabel();
			gbc.ipadx = 10;
			gbc.gridx = 5;
			gbc.gridy = 1;
			settings.getCartPriceLabel().setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 15));
			settings.getCartPriceLabel().setForeground(Color.WHITE);
			headerPanel.add (settings.getCartPriceLabel(),gbc);
			
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			buttonPanel.setLayout(new GridBagLayout());
			// Button dem Bild hinzugefügt "klassiker.jpg" 
			Icon y= new ImageIcon(getClass().getResource("../img/klassiker.png"));
			((ImageIcon) y).setImage(((ImageIcon) y).getImage().getScaledInstance(414,304,Image.SCALE_DEFAULT));
			
			klassikerButton = new JButton("bild", y);
			klassikerButton.setContentAreaFilled(false);
			klassikerButton.setBorder(null);
			gbc2.gridx = 4;
			gbc2.gridy = 0;
			buttonPanel.add (klassikerButton,gbc2);
			
			// // Button dem Bild hinzugefügt "deinepizza.jpg"
			Icon x= new ImageIcon(getClass().getResource("../img/deinepizza.png"));
			((ImageIcon) x).setImage(((ImageIcon) x).getImage().getScaledInstance(414,307,Image.SCALE_DEFAULT));
			
			deinePizzaButton = new JButton("bild", x);
			deinePizzaButton.setContentAreaFilled(false);
			deinePizzaButton.setBorder(null);
			gbc2.insets = new Insets(5,0,0,0);
			gbc2.gridy=1;
			buttonPanel.add (deinePizzaButton,gbc2);

			// Anordnung der Panels im Frame 
			buttonPanel.setBorder(new EmptyBorder(5, 130, 0, 104));
			headerPanel.setBorder(new EmptyBorder(5, 180, 0, 2));
			draw.add(headerPanel);
			draw.add(buttonPanel);
			
			setVisible(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
			setSize(Settings.SCREEN_WIDTH,Settings.SCREEN_HEIGTH);
		}
	
	/**
	 * Getter Methoden zur Übergabe an den Presenter
	 * @return cartButton, logoutButton, klassikerButton, deinePizzaButton
	 */
	public  JCustomButton getCartPlainJButton() {
		return cartButton;	
	}
	
	public  JCustomButton getLogoutPlainJButton() {	
		return logoutButton;	
	}
	
	public JButton getKlassikerButton() {
		return klassikerButton;	
	}

	public JButton getDeinePizzaButton() {
		return deinePizzaButton;
	}
	
		
		/**
		 * Die Klasse zeichnet den Hintergrund für das MainFrame, dazu wird die PainComponent Methode überschrieben.
		 * 
		 * @author Sean, Kevin, Daniyal, Farid, Sven
		 * @see JPanel
		 */
		 class MainDrawPanel extends JPanel{
			 
			private static final long serialVersionUID = 1L;
			
			private  ImageIcon logo = new ImageIcon(getClass().getResource("../img/logo-klein.png"));
			private  ImageIcon background = new ImageIcon(getClass().getResource("../img/background.jpg"));
			private  ImageIcon border = new ImageIcon(getClass().getResource("../img/border.jpg"));

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0,0,null);
				g.drawImage(border.getImage(), 0,86,null);
				
				g.drawImage(border.getImage(), 0,395,null);
				g.drawImage(logo.getImage(), 10,5,null);
			}
		}		
}
