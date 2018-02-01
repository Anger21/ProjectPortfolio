package presenter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import view.MainFrame;
import view.RegisterFrame;


/**
 * Die Klasse repr�sentiert den Presenter f�r das RegisterFrame.
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see RegisterFrame
 * @see JOptionPane
 * @see Arrays
 * @see MainFrame
 * @see LoginPresenter
 *
 */
public class RegisterPresenter {

	RegisterFrame registerFrame = new RegisterFrame();
	
	/**
	 * �ffnet das RegisterFrame und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
	 */
	public RegisterPresenter(){
		
		registerFrame.setVisible(true);
		// ###RegisterFrame Listener###
		
				// geht zurück zum LoginFrame
				registerFrame.getBackButton().addActionListener(e -> {
					new LoginPresenter();
					registerFrame.setVisible(false);	
				});
				
				//  Abfrage ob gleiches Passwort und ob die Textfelder, Passwortfelder richtig ausgef�lllt sind 
				registerFrame.getRegistrierButton().addActionListener(e -> {
					String pwValue = new String(registerFrame.getLoginPwField().getPassword());
					String pwWValue = new String(registerFrame.getLoginRepeatPwField().getPassword());
					if ((pwValue.equals("Passwort") || pwWValue.equals("W. Passwort") ||registerFrame.getRegisterNameField().getText().equals("Name") )){
						JOptionPane.showMessageDialog(null, "Registrierung Fehlgeschlagen");
						new RegisterPresenter();
						registerFrame.dispose();
					}

					else if (Arrays.equals(registerFrame.getLoginPwField().getPassword(),registerFrame.getLoginRepeatPwField().getPassword())) {
						new MainFrame();
						
						JOptionPane.showMessageDialog(null, "Erfolgreich registriert");
						new MainFramePresenter();
						registerFrame.setVisible(false);
					} 
					else {
						JOptionPane.showMessageDialog(null, "Password nicht gleich");
						new RegisterPresenter();
						registerFrame.dispose();
					}
				});
				
				// Enter drücken fürs anmelden beim Focus vom NameField
				registerFrame.getRegisterNameField().addKeyListener(new KeyListener() {
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							String pwValue = new String(registerFrame.getLoginPwField().getPassword());
							String pwWValue = new String(registerFrame.getLoginRepeatPwField().getPassword());
							if ((pwValue.equals("Passwort") || pwWValue.equals("W. Passwort") ||registerFrame.getRegisterNameField().getText().equals("Name") )){
								JOptionPane.showMessageDialog(null, "Registrierung Fehlgeschlagen");
								new RegisterPresenter();
								registerFrame.dispose();
							}

							else if (Arrays.equals(registerFrame.getLoginPwField().getPassword(),registerFrame.getLoginRepeatPwField().getPassword())) {
								new MainFrame();
								
								JOptionPane.showMessageDialog(null, "Erfolgreich registriert");
								new MainFramePresenter();
								registerFrame.setVisible(false);
							} 
							else {
								JOptionPane.showMessageDialog(null, "Password nicht gleich");
								new RegisterPresenter();
								registerFrame.dispose();
							}
				        } 
				    }
					@Override
					public void keyTyped(KeyEvent e) {}
					@Override
					public void keyReleased(KeyEvent e) {}
				});
				
				// Enter drücken fürs anmelden beim Focus PwField
				registerFrame.getLoginPwField().addKeyListener(new KeyListener() {
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							String pwValue = new String(registerFrame.getLoginPwField().getPassword());
							String pwWValue = new String(registerFrame.getLoginRepeatPwField().getPassword());
							if ((pwValue.equals("") || pwWValue.equals("W. Passwort") ||registerFrame.getRegisterNameField().getText().equals("Name") )){
								JOptionPane.showMessageDialog(null, "Registrierung Fehlgeschlagen");
								new RegisterPresenter();
								registerFrame.dispose();
							}

							else if (Arrays.equals(registerFrame.getLoginPwField().getPassword(),registerFrame.getLoginRepeatPwField().getPassword())) {
								new MainFrame();
								
								JOptionPane.showMessageDialog(null, "Erfolgreich registriert");
								new MainFramePresenter();
								registerFrame.setVisible(false);
							} 
							else {
								JOptionPane.showMessageDialog(null, "Password nicht gleich");
								new RegisterPresenter();
								registerFrame.dispose();
							}
				        } 
				    }
					@Override
					public void keyTyped(KeyEvent e) {}
					@Override
					public void keyReleased(KeyEvent e) {}
				});
				
				// Enter drücken fürs anmelden beim Focus RepeatPwField
				registerFrame.getLoginRepeatPwField().addKeyListener(new KeyListener() {
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							String pwValue = new String(registerFrame.getLoginPwField().getPassword());
							String pwWValue = new String(registerFrame.getLoginRepeatPwField().getPassword());
							if ((pwValue.equals("Passwort") || pwWValue.equals("") ||registerFrame.getRegisterNameField().getText().equals("Name") )){
								JOptionPane.showMessageDialog(null, "Registrierung Fehlgeschlagen");
								new RegisterPresenter();
								registerFrame.dispose();
							}

							else if (Arrays.equals(registerFrame.getLoginPwField().getPassword(),registerFrame.getLoginRepeatPwField().getPassword())) {
								new MainFrame();
								
								JOptionPane.showMessageDialog(null, "Erfolgreich registriert");
								new MainFramePresenter();
								registerFrame.setVisible(false);
							} 
							else {
								JOptionPane.showMessageDialog(null, "Password nicht gleich");
								new RegisterPresenter();
								registerFrame.dispose();
							}
				        } 
				    }
					@Override
					public void keyTyped(KeyEvent e) {}
					@Override
					public void keyReleased(KeyEvent e) {}
				});
		
	}
}
