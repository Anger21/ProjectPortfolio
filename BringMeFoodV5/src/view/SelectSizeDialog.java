package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import custom.JCustomButton;
import presenter.PizzaKlassikerPresenter;

/**
 * Diese Klasse ist für die Größenauswahl eines Pizzaklassikers zuständig und erstellt entsprechend die GUI-Elemente und
 * nimmt Veränderungen von außen auf. Diese Klasse wird genutzt, sobald man eine Pizza im PizzaKlassikerFrame ausgewählt hat.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JDialog
 * @see JCustomButton
 * @see ButtonGroup
 * @see GridBagLayout
 * @see GridBagConstraints
 * @see PizzaKlassikerPresenter
 * @see EmptyBorder
 */
public class SelectSizeDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
		private JRadioButton smallRadioBtn, mediumRadioBtn, largeRadioBtn, extraLargeRadioBtn; 
		private JCustomButton orderBtn, backBtn;
		private JPanel sizePanel;
		private JLabel pizzaNameLabel;
		
		
		/**
		 * Hier wird der Dialog für die Größenauswahl des Pizzaklassikers erstellt.
		 */
		public SelectSizeDialog() {
			// id Wert wird bei Aufruf des Dialoges resettet
			
			// Anlegen der RadioButtons
			smallRadioBtn = new JRadioButton("small");
			smallRadioBtn.setOpaque(false);
			smallRadioBtn.setContentAreaFilled(false);
			
			mediumRadioBtn = new JRadioButton("medium");
			mediumRadioBtn.setOpaque(false);

			largeRadioBtn = new JRadioButton("large");
			largeRadioBtn.setOpaque(false);

			extraLargeRadioBtn = new JRadioButton("extraLarge");
			extraLargeRadioBtn.setOpaque(false);
			
			// Anlegen der Buttons
			orderBtn = new JCustomButton("Bestellen");
			backBtn = new JCustomButton("Zurück");
			
			sizePanel = new JPanel();
			
			// Anlegen einer ButtonGruppe
			ButtonGroup group = new ButtonGroup();
			group.add(smallRadioBtn);
			group.add(mediumRadioBtn);
			group.add(largeRadioBtn);
			group.add(extraLargeRadioBtn);
			
			GridBagConstraints gbc = new GridBagConstraints();
			sizePanel.setLayout(new GridBagLayout());
			
			//Je nach id wird die Überschrift der Pizza entsprechend angezeigt
		    String pizzaName;
	        switch (PizzaKlassikerPresenter.id) {
	            case 1:  pizzaName = "Schokolade";
	                     break;
	            case 2:  pizzaName = "Salami";
	                     break;
	            case 3:  pizzaName = "Veggie";
	                     break;
	            case 4:  pizzaName = "Tomatoe";
	                     break;
	            case 5:  pizzaName = "Sucuk";
	                     break;
	            case 6:  pizzaName = "Bacon";
	                     break;
	            default: pizzaName = "Invalid pizza";
	                     break;
	        }
	        
	        
	        pizzaNameLabel = new JLabel(pizzaName);
	        pizzaNameLabel.setFont(new Font("Arial Rounded MT BOLD", Font.BOLD, 18));
	        pizzaNameLabel.setForeground(Color.WHITE);
	        
	        //RadioButton Schriftart anpassen
	        smallRadioBtn.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 12));
			smallRadioBtn.setForeground(Color.WHITE);
			
			mediumRadioBtn.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 12));
			mediumRadioBtn.setForeground(Color.WHITE);

			largeRadioBtn.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 12));
			largeRadioBtn.setForeground(Color.WHITE);
			
			extraLargeRadioBtn.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 12));
			extraLargeRadioBtn.setForeground(Color.WHITE);
			
	        
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.weightx = 0.0;
	        gbc.gridwidth = 2;
	        gbc.insets = new Insets(0, 0, 15, 0);	        
			sizePanel.add(pizzaNameLabel, gbc);
			
			
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.insets = new Insets(0, 0, 0, 0);	        
			sizePanel.add(smallRadioBtn, gbc);
			
			
			gbc.gridx = 1;
			sizePanel.add(mediumRadioBtn, gbc);			

			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.insets = new Insets(0, 0, 0, 3);
			sizePanel.add(largeRadioBtn, gbc);			
			
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.insets = new Insets(0, 17, 0, 0);
			sizePanel.add(extraLargeRadioBtn, gbc);			
			
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.weightx = 0.0;
			gbc.gridwidth = 2;
			gbc.insets = new Insets(15, 0, 0, 0);
			sizePanel.add(orderBtn, gbc);
			
			
			gbc.gridy = 4;
			gbc.weightx = 0.0;
			gbc.gridwidth = 2;
			gbc.insets = new Insets(5, 0, 0, 0);
			sizePanel.add(backBtn, gbc);
			
			sizePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
			sizePanel.setBackground(new Color(255, 72, 72));
			add(sizePanel);
			
			
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(false);
			setResizable (false);
			pack();
		}
		
		
		/**
		 * Getter Methoden zur Übergabe an den Presenter
		 * @return smallRadioBtn, mediumRadioBtn, largeRadioBtn, extraLargeRadioBtn, orderBtn
		 */
		public JRadioButton getSmallRadioBtn() {
			return smallRadioBtn;
		}
		
		public JRadioButton getMediumRadioBtn() {
			return mediumRadioBtn;
		}
		
		public JRadioButton getLargeRadioBtn() {
			return largeRadioBtn;
		}
		
		public JRadioButton getExtraLargeRadioBtn() {
			return extraLargeRadioBtn;
		}
		
		public JCustomButton getOrderBtn() {
			return orderBtn;
		}

		public JCustomButton getBackBtn() {
			return backBtn;
		}
}
