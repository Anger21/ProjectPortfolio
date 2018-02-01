package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import custom.JCustomButton;
import settings.Settings;
/**
 * Diese Klasse ist für die Pizzaklassiker zuständig und erstellt entsprechend die GUI-Elemente und
 * nimmt Veränderungen von außen auf. Hier kann man die Art der vorgefertigten Pizza auswählen.
 * 
 *
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JFrame
 * @see JCustomButton
 * @see ButtonGroup
 * @see PizzaAuswahlDrawPanel
 * @see Settings
 * @see GridBagLayout
 * @see GridBagConstraints
 */
public class PizzaKlassikerFrame extends JFrame{
	
	private static final long serialVersionUID = 3L;
	
	private JCustomButton backButton, cartButton;
	private JPanel sizePanel, headerPanel, scrollDownPanel;
	private JScrollPane scrollPane;
	
	private Icon[] pizzaKlassikerIcons;
	private JButton[] pizzaKlassikerButtons;

	ButtonGroup group = new ButtonGroup();
	PizzaAuswahlDrawPanel draw = new PizzaAuswahlDrawPanel();
	Settings settings = new Settings();
	
	/**
	 * Hier wird das Frame für die Pizzaklassiker erstellt.
	 */
	public PizzaKlassikerFrame() {
			super ("Deine Pizzaklassiker");
			
			pizzaKlassikerIcons = new Icon[6];
			pizzaKlassikerButtons = new JButton[pizzaKlassikerIcons.length];
			
			
			//JPanel, die dann oben (headerPanel), genau unter dem headerPanel (sizePanel) 
			//und unten (scrollDownPanel + scrollPane) zu sehen sind
			headerPanel = new JPanel();
			headerPanel.setOpaque(false);

			sizePanel = new JPanel();
			sizePanel.setOpaque(false);
			
			scrollDownPanel = new JPanel();
			scrollDownPanel.setOpaque(false);
			
			scrollPane = new JScrollPane();
			scrollPane.setOpaque(false);
			
			
			//####sizePanel####
			//Schriftart + -farbe wird verändert
			Settings.changeSizeFont(settings.getSMALL_SIZE());
			Settings.changeSizeFont(settings.getMEDIUM_SIZE());
			Settings.changeSizeFont(settings.getLARGE_SIZE());
			Settings.changeSizeFont(settings.getEXTRALARGE_SIZE());
			
			//entsprechende Label werden ins sizePanel eingetragen
			sizePanel.add(settings.getSMALL_SIZE());
			sizePanel.add(settings.getMEDIUM_SIZE());
			sizePanel.add(settings.getLARGE_SIZE());
			sizePanel.add(settings.getEXTRALARGE_SIZE());
		
			// Zurück Button
			backButton = new JCustomButton("Zurück");
			
			// Warenkorb Button
			cartButton = new JCustomButton("Warenkorb");
	
			// Bilder den Buttons hinzufügen
			pizzaKlassikerIcons[0] = new ImageIcon(getClass().getResource("../img/schokolade.png"));
			pizzaKlassikerIcons[1] = new ImageIcon(getClass().getResource("../img/salami.png"));
			pizzaKlassikerIcons[2] = new ImageIcon(getClass().getResource("../img/veggie.png"));
			pizzaKlassikerIcons[3] = new ImageIcon(getClass().getResource("../img/tamate.png"));
			pizzaKlassikerIcons[4] = new ImageIcon(getClass().getResource("../img/sucuk.png"));
			pizzaKlassikerIcons[5] = new ImageIcon(getClass().getResource("../img/bacon.png"));
			
			createPizzaKlassikerButtons();
			
			// Inhalt nicht scrollbar (Header)
		    GridBagConstraints gbc = new GridBagConstraints();
			headerPanel.setLayout(new GridBagLayout());
			
			gbc.gridx = 8;
			gbc.gridy = 0;
			headerPanel.add(backButton, gbc);
			
			
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
			Settings.changeSizeFont(settings.getCartPriceLabel());
			headerPanel.add (settings.getCartPriceLabel(),gbc);
			
			
			// Inhalt scrollbar (Hauptfeld)
			scrollDownPanel.setPreferredSize(new Dimension(414, 1263));
			
			for(int e = 0; e < pizzaKlassikerIcons.length; e++) {
				scrollDownPanel.add(pizzaKlassikerButtons[e]);
			}		
		 
			// ScrollPane hinzufügen
			scrollPane.setPreferredSize(new Dimension(414, 550));
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setBorder(null);
			scrollPane.setViewportView(scrollDownPanel);
			scrollPane.setHorizontalScrollBar(null);
	        
	       
	    	headerPanel.setBorder(new EmptyBorder(5, 180, 32, 0));
	    	sizePanel.setBorder(new EmptyBorder(0,0,8,0));
	    	
	        draw.add(headerPanel);
	        draw.add(sizePanel);
	        draw.add(scrollPane);   
	        add(draw);
			   
			setVisible(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);	
			setSize(Settings.SCREEN_WIDTH,Settings.SCREEN_HEIGTH);
		}
	
	
		/**
		* Getter Methoden zur Übergabe an den Presenter
		* @return backButton, cartButton, pizzaSalamiButton, pizzaBaconButton, pizzaVeggieButton, pizzaSucukButton, pizzaTomatoeButton, pizzaChocolateButton
		*/
		public JCustomButton getBackButton() {
			return backButton;
		}
		
		public JCustomButton getCartButton() {
			return cartButton;
		}
		
		
		public JButton getPizzaChocolateBtn() {
			return pizzaKlassikerButtons[0];
		}

		public JButton getPizzaSalamiBtn() {
			return pizzaKlassikerButtons[1];
		}
		
		public JButton getPizzaVeggieBtn() {
			return pizzaKlassikerButtons[2];
		}
		
		public JButton getPizzaTomatoeBtn() {
			return pizzaKlassikerButtons[3];
		}

		public JButton getPizzaSucukBtn() {
			return pizzaKlassikerButtons[4];
		}
		

		public JButton getPizzaBaconBtn() {
			return pizzaKlassikerButtons[5];
		}
		
		/**
		 * Die ServiceMethode skaliert die Bilder neu und setzt die Bilder in die entsprechenden Buttons.
		 */
		public void createPizzaKlassikerButtons() {
			
			for(int i = 0; i < pizzaKlassikerIcons.length; i++) {
				((ImageIcon) pizzaKlassikerIcons[i]).setImage(((ImageIcon) pizzaKlassikerIcons[i]).getImage().getScaledInstance(414,205,Image.SCALE_DEFAULT));
				pizzaKlassikerButtons[i] = new JButton(pizzaKlassikerIcons[i]);
				pizzaKlassikerButtons[i].setContentAreaFilled(false);
				pizzaKlassikerButtons[i].setBorder(null);
			}
			
		}
		
}