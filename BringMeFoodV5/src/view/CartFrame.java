package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import settings.Settings;
import custom.CustomTextField;
import custom.JCustomButton;
/**
 * Diese Klasse ist für den Warenkorb zuständig und erstellt entsprechend die GUI-Elemente und
 * nimmt Veränderungen von außen auf. Hier wird die Bestellung aufgelistet und der Nutzer kann 
 * seine Lieferadresse angeben.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JFrame
 * @see JCustomButton
 * @see CustomTextField
 * @see CartDrawPanel
 * @see ArrayList
 * @see GridBagLayout
 * @see GridBagConstraints
 * @see Settings
 */
public class CartFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel addressPanel, cartListPanel, backButtonPanel;
	private JCustomButton backButton, orderButton, deleteAllButton, deleteButton;
	private CustomTextField firstNameField, lastNameField, streetField, streetNumField, plzField, areaField, telField;
	private JLabel deliveryAddress, totalPrize, actualTotalPrize;
	private JList<String> cartList;
	private JScrollPane cartListPane;
	CartDrawPanel cartDrawPanel = new CartDrawPanel();
	static ArrayList<String> list = new ArrayList<String>();
	
	/**
	 * Hier wird das Frame für den Warenkorb erstellt.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CartFrame() {
		super ("Warenkorb");
	
	
		//dieses Panel zeichnet den Hintergrund 
		add(cartDrawPanel);
		
		//Adresse-Panel (für die Lieferadresse)
		addressPanel = new JPanel();
		addressPanel.setOpaque(false);
		
		//Einkaufsliste (kann bei Bedarf gelöscht werden)
		cartListPanel = new JPanel();
		cartListPanel.setOpaque(false);
		
		//Ein Panel für den backButton, damit wir den Button nach rechts schieben können
		backButtonPanel = new JPanel();
		backButtonPanel.setOpaque(false);
		
		//JCustomButton, die für "Zurück","Bestellen" und "Alles Löschen" stehen
		backButton = new JCustomButton("Zurück");
		
		orderButton = new JCustomButton("Bestellen");
		
		deleteButton = new JCustomButton("Löschen");
		deleteAllButton = new JCustomButton("Alles Löschen");
		
		//####addressPanel-Components####
		//TextFields, die im adressPanel zu finden sind + entsprechendes JLabel
		firstNameField = new CustomTextField("Vorname", 13);
		lastNameField = new CustomTextField("Nachname", 13);
		streetField = new CustomTextField("Straße", 20);
		streetNumField = new CustomTextField("Nr.", 4);
		plzField = new CustomTextField("PLZ", 13);
		areaField = new CustomTextField("Ort", 13);
		telField = new CustomTextField("Telefon", 28);
		
		deliveryAddress = new JLabel("LIEFERADRESSE");
		changeHeadingFont(deliveryAddress);
		
		//Hinzufügen des addressPanels und des Layouts
		GridBagConstraints gbc = new GridBagConstraints();
		addressPanel.setLayout(new GridBagLayout());
		
		//Setzen über gridx = 4 alles in die Mitte
		//Setzen über gridy auf verschiedene Ebenen
		gbc.gridx = 4;
	    gbc.gridy = 0;
		addressPanel.add(deliveryAddress, gbc);
		
		//Setzen über insets die Abstände ein: top, left, bottom, right
		gbc.insets = new Insets(30,0,0,160);
	    gbc.gridy = 1;
		addressPanel.add(firstNameField,gbc);
		
		gbc.insets = new Insets(30,160,0,0);
		addressPanel.add(lastNameField,gbc);
		
		//Haben es auf 20 gesetzt für die JTextField-Abstände
		gbc.insets = new Insets(20,258,0,0);
		gbc.gridy = 2;
		addressPanel.add(streetNumField,gbc);
				
		gbc.insets = new Insets(20,0,0,84);
		addressPanel.add(streetField,gbc);
		
		gbc.insets = new Insets(20,0,0,160);
	    gbc.gridy = 3;
		addressPanel.add(plzField,gbc);
		
		gbc.insets = new Insets(20,160,0,0);
		gbc.gridy = 3;
		addressPanel.add(areaField,gbc);
		
		gbc.insets = new Insets(20,0,0,0);
	    gbc.gridy = 4;
		addressPanel.add(telField,gbc);
		
		gbc.insets = new Insets(25,0,0,0);
		gbc.gridy = 5;
		addressPanel.add(orderButton, gbc);
		
		addressPanel.setBorder(new EmptyBorder(60, 102, 0, 104));
        
		
		//####cartListPanel-Components + Überschrift####
		//JList, die dem cartListPanel hinzugefügt wird
		
		// Fügt der Jlist eine ArrayList hinzu
		cartList = new JList(list.toArray());
		cartList.setCellRenderer(new TransparentListCellRenderer());
		cartList.setOpaque(false);
		
		cartList.setFixedCellHeight(Settings.SCREEN_HEIGTH/37);
		cartList.setFixedCellWidth(Settings.SCREEN_WIDTH - 100);
		
		cartListPane = new JScrollPane(cartList);
		cartListPane.setOpaque(false);
		cartListPane.getViewport().setOpaque(false);
		
		cartListPanel.add (cartListPane);
		
		//überschrift ganz oben
		totalPrize = new JLabel ("GESAMTBETRAG");
		actualTotalPrize = new JLabel(Settings.cartPriceLabel.getText());
		changeHeadingFont(totalPrize);
		changeHeadingFont(actualTotalPrize);
		totalPrize.setBorder(new EmptyBorder(30, 20, 0, 104));
		actualTotalPrize.setBorder(new EmptyBorder(30, 360, 0, 104));
		
		
		//Hinzufügen des cartListPanel und des Layouts
		GridBagConstraints gbc2 = new GridBagConstraints();
		cartListPanel.setLayout(new GridBagLayout());
		
		//Setzen über gridx = 4 alles in die Mitte
		//Setzen über gridy auf verschiedene Ebenen
		gbc2.gridx = 4;
	    gbc2.gridy = 0;
	    cartListPanel.add(totalPrize, gbc2);
	    cartListPanel.add(actualTotalPrize, gbc2);
	    
	    gbc2.gridy = 1;
	    gbc2.insets = new Insets(15,0,0,0);
	    cartListPanel.add(cartListPane, gbc2);
	    
	    gbc2.gridy = 2;

	    gbc2.insets = new Insets(20,0,0,0);
	    cartListPanel.add(deleteAllButton, gbc2);
	    
		
		cartListPanel.setBorder(new EmptyBorder(5, 102, 0, 104));
		
		//Hinzufügen des backButtons zu seinem entsprechenden Panel
		backButtonPanel.add(backButton);
		backButtonPanel.setBorder(new EmptyBorder(10, 235, 0, 0));
		
		//Zurück-Button + addressPanel +  cartListPanel werden dem cartDrawPanel übergeben
		cartDrawPanel.add(backButtonPanel);
		cartDrawPanel.add(addressPanel);
		cartDrawPanel.add(cartListPanel);
		
		
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Settings.SCREEN_WIDTH,Settings.SCREEN_HEIGTH);
		setResizable(false);
	}
	
	
	/**
	 * Getter Methoden zur Übergabe an den Presenter
	 * @return backButton, orderButton, firstNameField, lastNameField, streetField, streetNumField, plzField, areaField, telField, list
	 */
	public JCustomButton getOrderButton(){
		 return orderButton;
	}
	
	public JCustomButton getBackButton(){
		 return backButton;
	}
	
	public CustomTextField getFirstNameField() {
		return firstNameField;	
	}
	
	public CustomTextField getLastNameField() {
		return lastNameField;
	}
	
	public CustomTextField getStreetField() {
		return streetField;	
	}
	
	public CustomTextField getStreetNumField() {
		return streetNumField;
	}
	
	public CustomTextField getPlzField() {
		return plzField;	
	}
	
	public CustomTextField getAreaField() {
		return areaField;
	}
	
	public CustomTextField getTelField() {
		return telField;	
	}
	

	public static ArrayList<String> getList() {
		return list;
	}
	
	public JList<String> getJlist() {
		return cartList;

	}
	
	public JCustomButton getDeleteButton() {
		return deleteButton;
	}
	
	public JCustomButton getDeleteAllButton() {
		return deleteAllButton;
	}
	
	/**
	 * Der Setter fügt neue Elemente der ArrayListe hinzu
	 * @param string für das neue Element
	 */
	public void setCartList(String string) {
		
		CartFrame.list.add(string);
	}
	
	/**
	 * Die ServiceMethode um die Font zu ändern
	 * @param headingLabel, das Label, welches verändert werden soll
	 */
	public void changeHeadingFont(JLabel headingLabel) {
		headingLabel.setFont(new Font("Arial Rounded MT BOLD", Font.BOLD, 25));
		headingLabel.setForeground(Color.WHITE);
	}
	
	
	
	
	/**
	 * Die Klasse ist dafür da um den Hintergrund der JList transparent zu gestalten.
	 */
	public class TransparentListCellRenderer extends DefaultListCellRenderer {
	
		private static final long serialVersionUID = 1L;

		@Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setForeground(Color.WHITE);
            setOpaque(isSelected);
            return this;
        }
    }
	
	
	
	/**
	 * Die Klasse zeichnet mithilfe der paintComponent Methode den Background für das CartFrame
	 * 
	 * @author Sean, Kevin, Daniyal, Farid, Sven
	 */
	class CartDrawPanel extends JPanel{
		 
		private static final long serialVersionUID = 1L;
		
		private  ImageIcon logo = new ImageIcon(getClass().getResource("../img/logo-klein.png"));
		private  ImageIcon background = new ImageIcon(getClass().getResource("../img/background.jpg"));
		private  ImageIcon border = new ImageIcon(getClass().getResource("../img/border.jpg"));

	
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0,0,null);
			g.drawImage(border.getImage(), 0,95,null);
			
			g.drawImage(border.getImage(), 0,400,null);				
			g.drawImage(logo.getImage(), 10,5,null);
		}
	}
}