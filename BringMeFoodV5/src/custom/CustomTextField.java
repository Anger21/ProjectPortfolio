package custom;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * Die Klasse stellt ein selbst geschriebenes TextField dar.
 * Hier wurde mit dem FocusListener gearbeitet, um seinen Nutzen zu erweitern.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see JTextField
 * @see FocusListener
 */
public class CustomTextField extends JTextField {
	private static final long serialVersionUID = 1L;

	/**
	 * Der Kontruktor nimmt zwei Parameter entgegen. Hier wird der default-String
	 * im Textfeld in "" geändert, sodass man erkennt, dass der Fokus auf dem Feld liegt.
	 * 
	 * @param text für den eingegebenen Text
	 * @param size für Anzahl der Spalten des Textes
	 */
	public CustomTextField (String text, int size){
        super(text);
        setVisible(true);
		setFocusable(true);
		setColumns(size);

		
		// FocusListener Erzeugen
		this.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	if(getText().equals(text)) {
					setText("");	
				}
	        	
	        }

			@Override
			public void focusLost(FocusEvent e) {
				if(getText().equals("")) {
					setText(text);	
				}
			}
	    });
    }
}
