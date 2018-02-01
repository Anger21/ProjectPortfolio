package presenter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import model.Pizza;
import view.CartFrame;
import view.DeinePizzaFrame;
import view.LogInFrame;

/**
 * Die Klasse repr�sentiert den Presenter f�r das LoginFrame.
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see LoginFrame
 * @see JOptionPane
 */
public class LoginPresenter {

	LogInFrame loginFrame = new LogInFrame();
	
	/**
	 * �ffnet das LoginFrame und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
	 */
	public LoginPresenter() {
		
		// ###LoginFrame Listener####
		
		// Button drücken fürs anmelden
		loginFrame.getLoginButton().addActionListener(e -> {
			String pwValue = new String(loginFrame.getLoginPwField().getPassword());
			if (!(pwValue.equals("Passwort") ||loginFrame.getLoginNameField().getText().equals("Name") )){
				new MainFramePresenter();
				loginFrame.setVisible(false);
				System.out.println("Anmelden");
			}
			else { 
				JOptionPane.showMessageDialog(null,"Bitte alle Felder ausf�llen");
			}	
		});
		
		// Enter drücken fürs anmelden beim Focus vom NameField
		loginFrame.getLoginNameField().addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String pwValue = new String(loginFrame.getLoginPwField().getPassword());
					if (!(pwValue.equals("Passwort") ||loginFrame.getLoginNameField().getText().equals("") )){
						new MainFramePresenter();
						loginFrame.setVisible(false);
						System.out.println("Anmelden");
					}
					else { 
						JOptionPane.showMessageDialog(null,"Bitte alle Felder ausf�llen");
					}	
		        } 
		    }
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		
		// Enter drücken fürs anmelden beim Focus vom PwField
		loginFrame.getLoginPwField().addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String pwValue = new String(loginFrame.getLoginPwField().getPassword());
					if (!(pwValue.equals("") ||loginFrame.getLoginNameField().getText().equals("Name") )){
						new MainFramePresenter();
						loginFrame.setVisible(false);
						System.out.println("Anmelden");
					}
					else { 
						JOptionPane.showMessageDialog(null,"Bitte alle Felder ausf�llen");
					}	
		        } 
		    }
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		
		
		// Zum RegisterFrame wechseln
		loginFrame.getToRegisterButton().addActionListener(e -> {
			new RegisterPresenter();
			
			loginFrame.setVisible(false);
			System.out.println("Registrieren");
		});
	}
	
	
}
