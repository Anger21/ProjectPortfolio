package custom;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

/**
 * Die Klasse stellt ein selbst geschriebenes TextField dar.
 * Hier wurde mit dem FocusListener gearbeitet, um seinen Nutzen zu erweitern.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JPassworldField
 * @see FocusListener
 */
public class CustomJPasswordField extends JPasswordField {
	private static final long serialVersionUID = 1L;

	/**
	 * Der Konstruktor nimmt zwei Parameter entgegen. Hier wird der Text aus dem
	 * Passwordfeld entfernt und in "" gesetzt, sodass man erkennt, dass der Fokus 
	 * auf dem Feld liegt. Dann wird der im Passworldfeld eingegebene Text in '*' 
	 * umgewandelt - so, wie es auch im normalen PasswordField der Fall ist.
	 * 
	 * @param text für den eingegebenen Text
	 * @param size für Anzahl der Spalten des Textes
	 */
	public CustomJPasswordField (String text, int size){
        super(text);
        setVisible(true);
		setFocusable(true);
		setColumns(size);
		setEchoChar((char)0);
		
		//Sobald der Fokus da ist, sollen die chars zu '*' umgewandelt werden
		this.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	String value = new String(getPassword());
	        	setEchoChar('*');
	        	if(value.equals(text)) {
	        		setText("");
				}
	        	
	        }

			@Override
			public void focusLost(FocusEvent e) {
				String value2 = new String(getPassword());
				if(value2.equals(text) || value2.equals("")) {
					setEchoChar((char)0);
					setText(text);
				}
			}
	    });
    }
}
