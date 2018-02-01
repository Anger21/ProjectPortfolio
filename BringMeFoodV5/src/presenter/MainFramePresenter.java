package presenter;

import settings.Settings;
import view.MainFrame;
import view.SelectSizeDialog;

/**
 * Die Klasse repräsentiert den Presenter für das MainFrame.
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see MainFrame
 * @see Settings
 * @see SelectSizeDialog
 * @see SelectSizeDialogPresenter
 * 
 */
public class MainFramePresenter {
		
	MainFrame mainFrame = new MainFrame();
	Settings settings = new Settings();

	/**
	 * Öffnet das MainFrame und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
	 */
	public MainFramePresenter() {
	
		mainFrame.setVisible(true);
		// ###MainFrame Listener###
		mainFrame.getLogoutPlainJButton().addActionListener(e -> {
			new LoginPresenter();
			mainFrame.setVisible(false);
			
			
			// Logout führt zum Reset des Warenkorbs 
			SelectSizeDialog selectSizeDialog = new SelectSizeDialog();
			selectSizeDialog.setVisible(false);
			SelectSizeDialogPresenter.changeCartPrice(0.0);
		});

		mainFrame.getCartPlainJButton().addActionListener(e -> {
			new CartPresenter();
			mainFrame.setVisible(false);
		});
		
		mainFrame.getDeinePizzaButton().addActionListener(e -> {
			new DeinePizzaPresenter();
			mainFrame.setVisible(false);
		});
		mainFrame.getKlassikerButton().addActionListener(e -> {
			new PizzaKlassikerPresenter();
			mainFrame.setVisible(false);
		});
	}
}
