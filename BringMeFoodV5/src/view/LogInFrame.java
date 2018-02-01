package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import custom.CustomJPasswordField;
import custom.CustomTextField;
import custom.JCustomButton;
import settings.Settings;
/**
 * Diese Klasse ist für das Login zuständig und erstellt entsprechend die GUI-Elemente und
 * nimmt Veränderungen von außen auf. Von hier aus gelangt man ins Mainframe und kann, insofern
 * man sich noch nicht registriert hat, ins Registerframe gelangen und sich dort registrieren.
 * Es dient als Startseite des Programms.
 * 
 * @author Sean , Kevin, Daniyal, Farid, Sven
 * @see JFrame
 * @see DrawPanel
 * @see CustomTextField
 * @see CustomJPasswordField
 * @see JCustomButton
 * @see GridBagLayout
 * @see GridBagConstraints
 * @see Settings
 * @see EmptyBorder
 * 
 */
public class LogInFrame extends JFrame{
		
	private static final long serialVersionUID = 3L;
	
	private JLabel loginlabel;
	private CustomTextField loginNameField;
	private CustomJPasswordField loginPwField;
	private JCustomButton loginButton,toRegisterButton;
	private JPanel textPanel;
	
	DrawPanel draw = new DrawPanel();
	
	/**
	 * Hier wird das Frame für den Loginscreen erstellt.
	 */
	public LogInFrame() {
		super ("LoginFrame");
				
				add(draw);
				
				// LoginLabel anpassen
				loginlabel = new JLabel("Melde Dich an");    
			    loginlabel.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 25));
				loginlabel.setForeground(Color.WHITE);
				
				// TextField mit dem Namen fï¿½r den Login
				loginNameField = new CustomTextField("Name",12);
				
				// Erstellen des Passwortfeldes
				loginPwField = new CustomJPasswordField("Passwort", 12);
				
				// Eigenen CustomButton hinzugefï¿½gt --> Man gelangt zum MainFrame
				loginButton = new JCustomButton("Anmelden");
				
				// Eigenen CustomButton hinzugefï¿½gt --> Man gelangt zum RegisterFrame
				toRegisterButton = new JCustomButton ("Registrieren");
				
				// Panel erstellen fï¿½r die GUI Komponenten mit dem GRIDBAG Layout
				textPanel = new JPanel();
				textPanel.setOpaque(false);
				GridBagConstraints gbc = new GridBagConstraints();
				textPanel.setLayout(new GridBagLayout());
				
				// Ein Label mit der ï¿½berschrift hinzugefï¿½gt
				
				gbc.gridx = 4;
			    gbc.gridy = 0;
				textPanel.add(loginlabel, gbc);
				
				// Textfeld fï¿½r den Namen hinzufï¿½gen
				gbc.insets = new Insets(50,0,0,0);
				gbc.gridy = 1;
				textPanel.add (loginNameField,gbc);
			   
				// Passwort Feld hinzufï¿½gen mit Abstand
				gbc.insets = new Insets(20,0,0,0);
			    gbc.gridy = 2;
				textPanel.add(loginPwField,gbc);
			   
				// LoginButton hinzugefï¿½gt mit Abstï¿½nden
				gbc.insets = new Insets(40,0,0,0);
			    gbc.gridy = 3;
				textPanel.add(loginButton,gbc);
			    
				// RegistrierButton hinzugefï¿½gt mit Abstï¿½nden
				gbc.insets = new Insets(20,0,0,0);
				gbc.gridy = 4;
				textPanel.add (toRegisterButton,gbc);
		    
			    textPanel.setBorder(new EmptyBorder(10, 102, 0, 104));
			    
			    draw.add(textPanel);
			    
			    
			    
			    setVisible(true);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setResizable(false);
				setSize(Settings.SCREEN_WIDTH,Settings.SCREEN_HEIGTH);
				draw.requestFocusInWindow();
	}
	
	/**
	 * Getter Methoden zur Übergabe an den Presenter
	 * @return loginButton, toRegisterButton, loginNameField, loginPwField
	 */
	public JCustomButton getLoginButton() {
		return loginButton;
	}
	
	public JCustomButton getToRegisterButton() {
		return toRegisterButton;
	}
	
	public CustomTextField getLoginNameField() {
		return loginNameField;
	}
	
	public JPasswordField getLoginPwField() {
		return loginPwField;
	}
}
