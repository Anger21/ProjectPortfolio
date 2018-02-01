package presenter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import network.Client;
import settings.Settings;
import view.CartFrame;
import view.SelectSizeDialog;

/**
 * Die Klasse repräsentiert den Presenter für das CartFrame.
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @throws Exception
 * @see CartFrame
 * @see Settings
 * @see JOptionPane
 * @see File
 * @see PrintWriter
 * @see BufferedWriter
 * @see Client
 * @see SelectSizeDialog
 * @see SelectSizeDialogPresenter
 * @see MainFramePresenter
 */

public class CartPresenter {
	private int index = -1;
	
	CartFrame cartFrame = new CartFrame ();
	
	/**
	 * Öffnet das CartFrame und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
	 */
	public CartPresenter() {
		
		cartFrame.setVisible(true);
		
		
		//Bringt den Nutzer zurück ins MainFrame und setzt die Sichtbarkeit des Frames auf false
		cartFrame.getBackButton().addActionListener(e -> {
			new MainFramePresenter();
			cartFrame.setVisible(false);			
		});

		
		//Hier werden die Eingaben im CartFrame überprüft. Falls Fehler auftreten, wird die Bestellung
		//erst einmal nicht getätigt und dem Nutzer wird gemeldet, dass dieser die Felder zu
		//korrigieren hat. Erst danach werden die Eingaben in eine Datei gesendet und über den Client gesendet.
		cartFrame.getOrderButton().addActionListener(e -> {
			// Abfrage Ob Textfelder ausgefüllt sind oder nicht
			if (!(cartFrame.getFirstNameField().getText().equals("Vorname") || 
				  cartFrame.getLastNameField().getText().equals("Nachname") ||
				  cartFrame.getStreetField().getText().equals("Straße") || 
				  cartFrame.getStreetNumField().getText().equals("Nr.") || 
				  cartFrame.getPlzField().getText().equals("PLZ") || 
				  cartFrame.getAreaField().getText().equals("Ort") || 
				  cartFrame.getTelField().getText().equals("Telefon") ||
				  Settings.cartPriceLabel.getText().equals("0.00"))) {	
				
				if(cartFrame.getFirstNameField().getText().matches("[a-zA-Z]+") && 
				   cartFrame.getLastNameField().getText().matches("[a-zA-Z]+") &&
				   cartFrame.getStreetField().getText().matches("[a-zA-Z]+") && 
				   (cartFrame.getStreetField().getText().length() >= 5) &&
				   cartFrame.getStreetNumField().getText().matches("[0-9]+") && 
				   cartFrame.getPlzField().getText().matches("[0-9]+") &&
				   (cartFrame.getPlzField().getText().length() >= 5) &&
				   cartFrame.getAreaField().getText().matches("[a-zA-Z]+") && 
				   (cartFrame.getAreaField().getText().length() >= 3) &&
				   cartFrame.getTelField().getText().matches("[0-9]+") &&
				   (cartFrame.getTelField().getText().length() >= 9)) {
					
					JOptionPane.showMessageDialog(null,"Die Bestellung ist abgeschickt");
					
					// Absendung der Bestellung schreibt die KundenDaten in eien Datei
					File file = new File("Kunde.txt");
					try (
					PrintWriter printWriter = new PrintWriter(file);
					BufferedWriter bufferedWriter = new BufferedWriter (printWriter);) {
					bufferedWriter.write("Kundendaten");
					bufferedWriter.newLine();
					bufferedWriter.write("Vorname: "+cartFrame.getFirstNameField().getText());
					bufferedWriter.newLine();
					bufferedWriter.write("Nachname: "+cartFrame.getLastNameField().getText());
					bufferedWriter.newLine();
					bufferedWriter.write("Straße: "+cartFrame.getStreetField().getText());
					bufferedWriter.newLine();
					bufferedWriter.write("Nr.: "+cartFrame.getStreetNumField().getText());
					bufferedWriter.newLine();
					bufferedWriter.write("PLZ: "+cartFrame.getPlzField().getText());
					bufferedWriter.newLine();
					bufferedWriter.write("Ort: "+cartFrame.getAreaField().getText());
					bufferedWriter.newLine();
					bufferedWriter.write("Tel: "+cartFrame.getTelField().getText());
					bufferedWriter.newLine();
					
					for (int i = 0; i < CartFrame.getList().size(); i++) {
						bufferedWriter.write(CartFrame.getList().get(i));
						bufferedWriter.newLine();
					}
					bufferedWriter.close();
					Client client = new Client();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				// Absendung der Bestellung führt zum Reset des Warenkorbs 
				SelectSizeDialog pizzaKlassikerPresenterInstanz = new SelectSizeDialog();
				pizzaKlassikerPresenterInstanz.setVisible(false);
				SelectSizeDialogPresenter.changeCartPrice(0.0);
				
				// Nach erfolgreicher Bestellung wird die ArrayListe geleert
				CartFrame.getList().clear();
				
				// cartFrame schließt, MainFrame öffnet sich
				new MainFramePresenter();
				cartFrame.setVisible(false);
				}
				
				//Abfangen der falschen Eingaben
				else {
					if(!(cartFrame.getFirstNameField().getText().matches("[a-zA-Z]+"))) {
						JOptionPane.showMessageDialog(null, "Geben Sie Ihren richtigen Vornamen ein!");
					}
					else if (!(cartFrame.getLastNameField().getText().matches("[a-zA-Z]+"))){
						JOptionPane.showMessageDialog(null, "Geben Sie Ihren richtigen Nachnamen ein!");
					}
					else if (!(cartFrame.getStreetField().getText().matches("[a-zA-Z]+")) || !(cartFrame.getStreetField().getText().length() >= 5)) {
						JOptionPane.showMessageDialog(null, "Geben Sie Ihre richtige Straße ein!");
					}
					else if (!(cartFrame.getStreetNumField().getText().matches("[0-9]+"))) {
						JOptionPane.showMessageDialog(null, "Geben Sie Ihre richtige Hausnummer ein!");
					}
					else if (!(cartFrame.getPlzField().getText().matches("[0-9]+")) || !(cartFrame.getPlzField().getText().length() >= 5)) {
						JOptionPane.showMessageDialog(null, "Geben Sie Ihre richtige PLZ ein!");
					}
					else if (!(cartFrame.getAreaField().getText().matches("[a-zA-Z]+")) || !(cartFrame.getAreaField().getText().length() >= 3)) {
						JOptionPane.showMessageDialog(null, "Geben Sie Ihren richtigen Ort ein!");
					}
					else if (!(cartFrame.getTelField().getText().matches("[0-9]+")) || !(cartFrame.getTelField().getText().length() >= 9)) {
						JOptionPane.showMessageDialog(null, "Geben Sie Ihre richtige Telefonnumer ein!");
					}
					
				}
			}
			
			//Abfangen vom falschen Bestellwert bzw. leerem/nicht ausgefülltem Formular
			else { 
				if(Settings.cartPriceLabel.getText().equals("0.00")) {
					JOptionPane.showMessageDialog(null,"Eine leere Bestellung ist nicht möglich");
				}
				else {
					JOptionPane.showMessageDialog(null,"Bitte Textfelder ausfüllen");
				}
			}		
		});
		
//		#######################################################Wird nicht mehr verwendet
//		//Delete Button 
//		cartFrame.getDeleteButton().addActionListener(e -> {
//			index = cartFrame.getJlist().getSelectedIndex();
//			if (index != -1) {
//				CartFrame.getList().remove(index);
//				
//				// Refresh des Frames
//				cartFrame.setVisible(false);
//				new CartPresenter();
//				
//			}
//			System.out.println(index);
//		});
		
		
		//Delete All Button
		cartFrame.getDeleteAllButton().addActionListener(e -> {
			
			// Der Warenkorb Wert wird gelöscht dabei das DialogFenster geschlossen
			SelectSizeDialog pizzaKlassikerPresenterInstanz = new SelectSizeDialog();
			pizzaKlassikerPresenterInstanz.setVisible(false);
			SelectSizeDialogPresenter.changeCartPrice(0.0);
			
			// Liste wird geleert
			CartFrame.getList().clear();
			// Refresh des Frames
			cartFrame.setVisible(false);
			new CartPresenter();
		});

	}
}
	
