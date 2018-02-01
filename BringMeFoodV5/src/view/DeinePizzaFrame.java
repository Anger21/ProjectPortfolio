package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import settings.Settings;
import view.CartFrame.CartDrawPanel;
import custom.CustomTextField;
import custom.JCustomButton;

/**
 * Diese Klasse ist für die selbsterstellte Pizza zuständig und erstellt entsprechend die GUI-Elemente und
 * nimmt Veränderungen von außen auf. Hier kann man die Komposition zwischen Größe und Zutaten frei gestalten.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JFrame
 * @see JCustomButton
 * @see GridBagLayout
 * @see GridBagConstraints
 * @see Settings
 * @see PizzaAuswahlDrawPanel
 * @see SpinnerNumberModel
 * @see JSpinner
 * @see ButtonGroup
 */
public class DeinePizzaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PizzaAuswahlDrawPanel draw = new PizzaAuswahlDrawPanel();
	
	private JCustomButton backButton, cartButton, addButton;
	private JLabel bottomValueLabel, priceLabel;
	private JLabel paprikaName, cornName, salamiName, hamName, baconName, onionName, broccoliName, sucukName;
	private JPanel headerPanel, sizePanel, sizeRadioPanel, ingredientPanel, bottomPanel;
	
	private SpinnerNumberModel[] ingredientsModels;
	private JSpinner[] ingredientsSpinners;
	private JRadioButton[] sizeRadioButtons;
	
	private Icon[] ingredientsPictures;
	private JLabel[] ingredientsLabels;
	
	Settings settings = new Settings();
	
	/**
	 * Hier wird das Frame für den "Deine Pizza" erstellt.
	 */
	public DeinePizzaFrame() {
		super ("Deine Pizza");
		
		// Arrays erstellen für die Zutaten (Label und Bildern)
		ingredientsPictures = new Icon[8];
		ingredientsLabels = new JLabel[ingredientsPictures.length];
		
		
		//dieses Panel zeichnet den Hintergrund
		add(draw);
		
		//JPanel, die dann oben (headerPanel), genau unter dem headerPanel (sizePanel) und unten (ingredientPanel) zu sehen sind
		headerPanel = new JPanel();
		headerPanel.setOpaque(false);
		
		sizePanel = new JPanel();
		sizePanel.setOpaque(false);
		
		sizeRadioPanel = new JPanel();
		sizeRadioPanel.setOpaque(false);
		
		ingredientPanel = new JPanel();
		ingredientPanel.setOpaque(false);
		
		bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		
		//JCustomButton, die für "Zurück","Warenkorb" und "Besttelen" stehen
		backButton = new JCustomButton("Zurück");
		cartButton = new JCustomButton("Warenkorb");
		
		addButton = new JCustomButton("Bestellen");
		
		//JLabel für die insgesamte Preisanzeige ganz unten auf der Seite (bottomPanel)
		priceLabel = new JLabel("Preis:");
		bottomValueLabel = new JLabel("0.00");
		
		
		//JSpinner, für die entsprechenden Zutaten + das dazugehörige Modell
		ingredientsModels = new SpinnerNumberModel[ingredientsPictures.length];
		ingredientsSpinners = new JSpinner[ingredientsModels.length];	
		createModelForJSpinner();
		
		
		//JLabel, die im ingredientPanel genutzt werden + JLabel für die Namen der einzelnen Icons(Zutaten)
		ingredientsPictures[0] = new ImageIcon(getClass().getResource("../img/pap.png"));
		ingredientsPictures[1] = new ImageIcon(getClass().getResource("../img/mai.png"));
		ingredientsPictures[2] = new ImageIcon(getClass().getResource("../img/sal.png"));
		ingredientsPictures[3] = new ImageIcon(getClass().getResource("../img/schinken.png"));
		ingredientsPictures[4] = new ImageIcon(getClass().getResource("../img/bac.png"));
		ingredientsPictures[5] = new ImageIcon(getClass().getResource("../img/zwi.png"));
		ingredientsPictures[6] = new ImageIcon(getClass().getResource("../img/bro.png"));
		ingredientsPictures[7] = new ImageIcon(getClass().getResource("../img/suc.png"));
		
		createDeinePizzaIngredientPictures();
		
		
		// Die Font der Label geändert 
		paprikaName = new JLabel("Paprika 0,20€");
		Settings.changeSizeFontIngredient(paprikaName);
		cornName = new JLabel("Mais 0,15€");
		Settings.changeSizeFontIngredient(cornName);
		salamiName = new JLabel("Salami 0,70€");
		Settings.changeSizeFontIngredient(salamiName);
		hamName = new JLabel("Schinken 0,80€");
		Settings.changeSizeFontIngredient(hamName);
		baconName = new JLabel("Bacon 0,60€");
		Settings.changeSizeFontIngredient(baconName);
		onionName = new JLabel("Zwiebel 0,20€");
		Settings.changeSizeFontIngredient(onionName);
		broccoliName = new JLabel("Brokkoli 0,40€");
		Settings.changeSizeFontIngredient(broccoliName);
		sucukName = new JLabel("Sucuk" + 1.00 + "€");
		Settings.changeSizeFontIngredient(sucukName);
		
		
		//####headerPanel####
		//GridbagLayout im headerPanel anlegen
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
		settings.getCartPriceLabel().setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 15));
		settings.getCartPriceLabel().setForeground(Color.WHITE);
		headerPanel.add (settings.getCartPriceLabel(),gbc);
		
		
		//####sizeRadioPanel####
		ButtonGroup group = new ButtonGroup();
		
		sizeRadioButtons = new JRadioButton[4];
		sizeRadioButtons[0] = new JRadioButton("S - 4,50");
		sizeRadioButtons[1] = new JRadioButton("M - 5,70");
		sizeRadioButtons[2] = new JRadioButton("L - 6,90");
		sizeRadioButtons[3] = new JRadioButton("XL - 8,10");
		
		
		for(int i = 0; i < sizeRadioButtons.length; i++) {
			group.add(sizeRadioButtons[i]);
			sizeRadioButtons[i].setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 15));
			sizeRadioButtons[i].setForeground(Color.WHITE);				
			sizeRadioButtons[i].setOpaque(false);
			
			sizeRadioPanel.add(sizeRadioButtons[i]);
		}
		
		
		
		//####sizePanel####
		Settings.changeSizeFont(settings.getSMALL_SIZE());
		sizePanel.add(settings.getSMALL_SIZE());
		
		Settings.changeSizeFont(settings.getMEDIUM_SIZE());
		sizePanel.add(settings.getMEDIUM_SIZE());
		
		Settings.changeSizeFont(settings.getLARGE_SIZE());
		sizePanel.add(settings.getLARGE_SIZE());
		
		Settings.changeSizeFont(settings.getEXTRALARGE_SIZE());
		sizePanel.add(settings.getEXTRALARGE_SIZE());
		
		
		//####IngredientPanel####
		//GridbagLayout im IngredientPanel anlegen
		GridBagConstraints gbc3 = new GridBagConstraints();
		ingredientPanel.setLayout(new GridBagLayout());
		
		
		//Paprika
		gbc3.insets= new Insets(0,20,0,0);
		gbc3.gridx = 0;
		gbc3.gridy = 0;
		ingredientPanel.add (ingredientsLabels[0], gbc3);
		
		gbc3.insets= new Insets(0,0,0,0);
		gbc3.gridx = 1;
		ingredientPanel.add(ingredientsSpinners[0], gbc3);
		
		gbc3.insets= new Insets(0,0,50,0);
		ingredientPanel.add(paprikaName, gbc3);
		
		
		//Corn
		gbc3.insets= new Insets(0,80,0,-30);
		gbc3.gridx = 2;
		ingredientPanel.add (ingredientsLabels[1],gbc3);
		
		gbc3.insets= new Insets(0,0,0,30);
		gbc3.gridx = 3;
		ingredientPanel.add(ingredientsSpinners[1], gbc3);
		
		gbc3.insets= new Insets(0,0,50,30);
		ingredientPanel.add(cornName, gbc3);
		
		
		//Salami
		gbc3.insets= new Insets(40,30,0,0);
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		ingredientPanel.add (ingredientsLabels[2],gbc3);
		
		gbc3.insets= new Insets(40,0,0,0);
		gbc3.gridx = 1;
		ingredientPanel.add(ingredientsSpinners[2], gbc3);
		
		gbc3.insets= new Insets(40,0,50,0);
		ingredientPanel.add(salamiName, gbc3);
		
		
		//Ham
		gbc3.insets= new Insets(40,125, 0,0);
		gbc3.gridx = 2;
		gbc3.gridy = 2;
		ingredientPanel.add (ingredientsLabels[3],gbc3);
		
		gbc3.insets= new Insets(40,0,0,20);
		gbc3.gridx = 3;
		ingredientPanel.add(ingredientsSpinners[3], gbc3);
		
		gbc3.insets= new Insets(40,0,50,30);
		ingredientPanel.add(hamName, gbc3);
		
		
		//Bacon
		gbc3.insets= new Insets(40,30,0,0);
		gbc3.gridx = 0;
		gbc3.gridy = 3;
		ingredientPanel.add (ingredientsLabels[4],gbc3);
		
		gbc3.insets= new Insets(40,0,0,0);
		gbc3.gridx = 1;
		ingredientPanel.add(ingredientsSpinners[4], gbc3);
		
		gbc3.insets= new Insets(40,0,50,0);
		ingredientPanel.add(baconName, gbc3);
		
		
		//Onion
		gbc3.insets= new Insets(40,115,0,0);
		gbc3.gridx = 2;
		gbc3.gridy = 3;
		ingredientPanel.add (ingredientsLabels[5],gbc3);
		
		gbc3.insets= new Insets(40,0,0,20);
		gbc3.gridx = 3;
		ingredientPanel.add(ingredientsSpinners[5], gbc3);
		
		gbc3.insets= new Insets(40,0,50,30);
		ingredientPanel.add(onionName, gbc3);
		
		
		//Broccoli
		gbc3.insets= new Insets(40,30,0,0);
		gbc3.gridx = 0;
		gbc3.gridy = 4;
		ingredientPanel.add (ingredientsLabels[6],gbc3);
		
		gbc3.insets= new Insets(40,0,0,0);
		gbc3.gridx = 1;
		ingredientPanel.add(ingredientsSpinners[6], gbc3);
		
		gbc3.insets= new Insets(40,0,50,0);
		ingredientPanel.add(broccoliName, gbc3);
		
		
		//Sucuk
		gbc3.insets= new Insets(40,115,0,0);
		gbc3.gridx = 2;
		gbc3.gridy = 4;
		ingredientPanel.add (ingredientsLabels[7],gbc3);
		
		gbc3.insets= new Insets(40,0,0,20);
		gbc3.gridx = 3;
		ingredientPanel.add(ingredientsSpinners[7], gbc3);
		
		gbc3.insets= new Insets(40,0,50,30);
		ingredientPanel.add(sucukName, gbc3);
		
				
		//####BottomPanel####
		//GridbagLayout im BottomPanel anlegen
		GridBagConstraints gbc5 = new GridBagConstraints();
		bottomPanel.setLayout(new GridBagLayout());
		
		Settings.changeSizeFont(priceLabel);
		gbc5.insets = new Insets(40,0,0,20);
		gbc5.gridx = 0;
		gbc5.gridy = 5;
		bottomPanel.add(priceLabel,gbc5);
		
		Settings.changeSizeFont(bottomValueLabel);
		gbc5.insets = new Insets(40,0,0,20);
		gbc5.gridx = 1;
		bottomPanel.add(bottomValueLabel,gbc5);
		
		gbc5.insets = new Insets(40,0,0,0);
		gbc5.gridx = 2;
		bottomPanel.add(addButton, gbc5);
		
				
		// Anordnung der Panels
		headerPanel.setBorder(new EmptyBorder(5, 180, 32, 0));
		sizeRadioPanel.setBorder(new EmptyBorder(15, 0, 10, 0));
		ingredientPanel.setBorder(new EmptyBorder(0,40,3,40));
		bottomPanel.setBorder (new EmptyBorder(0, 0, 0, 0));
		draw.add(headerPanel);
		draw.add(sizePanel);
		draw.add(sizeRadioPanel);
		draw.add(ingredientPanel);
		draw.add(bottomPanel);
		
		
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Settings.SCREEN_WIDTH,Settings.SCREEN_HEIGTH);
		setResizable(false);

	}
	
		/**
		 * Getter Methoden zur Übergabe an den Presenter
		 * @return backButton, cartButton, addButton, paprikaSpinner, cornSpinner, salamiSpinner, hamSpinner, 
		 * baconSpinner, onionSpinner, broccoliSPinner, sucukSpinner, SmallRadioButton, MediumRadioButton, LargeRadioButton, ExtraLargeRadioButton
		 */
		
		public JCustomButton getBackButton() {
			return backButton;
		}
		
		public JCustomButton getCartButton() {
			return cartButton;
		}
		
		public JCustomButton getAddButton() {
			return addButton;
		}
		
		public JLabel getBottomValueLabel() {
			return bottomValueLabel;
		}
		
		
		
		public JRadioButton getSmallRadioButton() {
			return sizeRadioButtons[0];
		}
		
		public JRadioButton getMediumRadioButton() {
			return sizeRadioButtons[1];
		}
		
		public JRadioButton getLargeRadioButton() {
			return sizeRadioButtons[2];
		}
		
		public JRadioButton getExtraLargeRadioButton() {
			return sizeRadioButtons[3];
		}
		
		
		
		
		public JSpinner getPaprikaSpinner() {
			return ingredientsSpinners[0];
		}
		
		public JSpinner getCornSpinner() {
			return (JSpinner) ingredientsSpinners[1];
		}
		
		public JSpinner getSalamiSpinner() {
			return (JSpinner) ingredientsSpinners[2];
		}
		
		public JSpinner getHamSpinner() {
			return (JSpinner) ingredientsSpinners[3];
		}
		
		public JSpinner getBaconSpinner() {
			return (JSpinner) ingredientsSpinners[4];
		}
		
		public JSpinner getOnionSpinner() {
			return (JSpinner) ingredientsSpinners[5];
		}
		
		public JSpinner getBroccoliSpinner() {
			return (JSpinner) ingredientsSpinners[6];
		}
		
		public JSpinner getSucukSpinner() {
			return (JSpinner) ingredientsSpinners[7];
		}

		
		/**
		 * Die Servicemethode skaliert die Bilder neu und setzt die Bilder in die entsprechenden Buttons
		 */
		public void createDeinePizzaIngredientPictures() {
			
			for(int i = 0; i < ingredientsPictures.length; i++) {
				((ImageIcon) ingredientsPictures[i]).setImage(((ImageIcon) ingredientsPictures[i]).getImage().getScaledInstance(50, 48, Image.SCALE_SMOOTH));
				ingredientsLabels[i] = new JLabel(ingredientsPictures[i]);
			}
		}
		
		
		/**
		 * Die Servicemethode ordnet die SpinnerModels den einzelnen JSpinnern zu
		 */
		public void createModelForJSpinner() {
			
			for(int i = 0; i < ingredientsModels.length; i++) {
				ingredientsModels[i] = new SpinnerNumberModel(0.0, 0.0, 3.0, 1.0);
				ingredientsSpinners[i] = new JSpinner(ingredientsModels[i]);
			}
		}
}