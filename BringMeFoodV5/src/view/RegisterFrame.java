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
 * Diese Klasse ist für das Registrieren zuständig und erstellt entsprechend die GUI-Elemente und
 * nimmt Veränderungen von außen auf. Diese Klasse wird genutzt, um einen Account anzulegen und
 * sich schließlich mit diesem Account dann anzumelden.
 * 
 * @author Sean , Kevin, Daniyal, Farid, Sven
 * @see JFrame
 * @see CustomTextField
 * @see CustomJPasswordField
 * @see JCustomButton
 * @see DrawPanel
 * @see GridBagLayout
 */
public class RegisterFrame extends JFrame {
private static final long serialVersionUID = 3L;
	
	private JLabel registerlabel;
	private CustomTextField registrierNameField;
	private CustomJPasswordField registrierPwField, registrierRepeatPw;
	private JCustomButton backButton,registrierButton;
	private JPanel textPanel;

	DrawPanel draw = new DrawPanel();
	
	/**
	 * Hier wird das Frame fürs Registrieren erstellt.
	 */
	public RegisterFrame () {
		super ("RegisterFrame");
		
		add(draw);
		
		// LoginLabel fï¿½r die ï¿½berschrift anpassen
		registerlabel = new JLabel("Registriere dich");
		registerlabel.setFont(new Font("Arial Rounded MT BOLD", Font.PLAIN, 25));
		registerlabel.setForeground(Color.WHITE);
		
		// Erstellen des NameField
		registrierNameField = new CustomTextField("Name", 12);
		
		// Erstellen der PasswortFeldern
		registrierPwField = new CustomJPasswordField("Passwort", 12);
		registrierRepeatPw = new CustomJPasswordField("W. Passwort", 12);
		
		// Erstellen von CustomButtons
		registrierButton = new JCustomButton("Registrieren");
		backButton = new JCustomButton("Back");
		
		// Panel erstellen fï¿½r die GUI Komponenten mit dem GRIDBAG Layout
		textPanel = new JPanel();
		textPanel.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		textPanel.setLayout(new GridBagLayout());
		
		// Ein Label mit der ï¿½berschrift hinzugefï¿½gt
		gbc.gridx = 4;
	    gbc.gridy = 0;
		textPanel.add(registerlabel, gbc);
		
		// Textfeld fï¿½r den Namen hinzufï¿½gen
		gbc.insets = new Insets(50,0,0,0);
		gbc.gridy = 1;
		textPanel.add (registrierNameField,gbc);
	   
		// Passwort Feld hinzufï¿½gen mit Abstanden
		gbc.insets = new Insets(20,0,0,0);
	    gbc.gridy = 2;
		textPanel.add(registrierPwField,gbc);
	   
		// Passwordfeld Repeat hinzugefï¿½gt mti Abstï¿½nden
	    gbc.gridy = 3;
		textPanel.add(registrierRepeatPw,gbc);
	    
		// RegistrierButton hinzugefï¿½gt mit Abstï¿½nden
		gbc.insets = new Insets(20,0,0,0);
		gbc.gridy = 4;
		textPanel.add (registrierButton,gbc);
    
		// BackButton hinzugefï¿½gt um zurï¿½ck zum LoginFrame zu gelangen 
		gbc.insets = new Insets(20,0,0,0);
		gbc.gridy = 5;
		textPanel.add (backButton,gbc);
		
		textPanel.setBorder(new EmptyBorder(10, 102, 0, 104));
	    
		draw.add(textPanel);
    
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(Settings.SCREEN_WIDTH,Settings.SCREEN_HEIGTH);
		
		}
	
	/**
	 * Getter Methoden zur Übergabe an den Presenter
	 * @return backButton, registerButton, registrierNameField, registrierPwField, registrierRepeatPw
	 */
	public JCustomButton getBackButton() {
		return backButton;
	}

	public JCustomButton getRegistrierButton() {
		return registrierButton;
	}
	
	public CustomTextField getRegisterNameField() {
		return registrierNameField;
	}

	public JPasswordField getLoginPwField() {
		return registrierPwField;
	}
	
	public JPasswordField getLoginRepeatPwField() {
		return registrierRepeatPw;
	}
	
}
