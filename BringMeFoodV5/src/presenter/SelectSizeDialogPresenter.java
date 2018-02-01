package presenter;

import java.util.Formatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import model.BaconPizza;
import model.ChocolatePizza;
import model.SalamiPizza;
import model.SucukPizza;
import model.TomatoePizza;
import model.VeggiePizza;
import settings.Settings;
import view.CartFrame;
import view.PizzaKlassikerFrame;
import view.SelectSizeDialog;
/**
 * Die Klasse repräsentiert den Presenter für das SelectSizeDialog.
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see SelectSizeDialog
 * @see BaconPizza
 * @see ChocolatePizza
 * @see SalamiPizza
 * @see SucukPizza
 * @see TomatoePizza
 * @see VeggiePizza
 * @see PizzaKlassikerPresenter
 * @see JOptionPane
 * @see CartFrame
 * @see Formatter
 * @see Settings
 */
public class SelectSizeDialogPresenter {
	
		SelectSizeDialog selectSizeDialog = new SelectSizeDialog();
		
		BaconPizza baconPizza = new BaconPizza();
		ChocolatePizza chocolatePizza = new ChocolatePizza();
		SalamiPizza salamiPizza = new SalamiPizza();
		SucukPizza sucukPizza = new SucukPizza();
		TomatoePizza tomatoePizza = new TomatoePizza();
		VeggiePizza veggiePizza = new VeggiePizza();
		
		CartFrame cartFrame = new CartFrame();
		
		/**
		 * Öffnet das SelectSizeDialog und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
		 */
		public SelectSizeDialogPresenter() {
			
			selectSizeDialog.setVisible(true);
			
			// Fügt eine Pizzabestellung dem WarenkorbWert hinzu
			selectSizeDialog.getOrderBtn().addActionListener(e -> {
				// Schokoladen Pizza
				if(PizzaKlassikerPresenter.id==1) {
					if(selectSizeDialog.getSmallRadioBtn().isSelected()) {//Small
						changeCartPrice(chocolatePizza.getPriceSmall());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(chocolatePizza.getSmallPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getMediumRadioBtn().isSelected()) {//Medium
						changeCartPrice(chocolatePizza.getPriceMedium());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(chocolatePizza.getMediumPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getLargeRadioBtn().isSelected()) {//Large
						changeCartPrice(chocolatePizza.getPriceLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(chocolatePizza.getLargePizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getExtraLargeRadioBtn().isSelected()) {//extraLarge
						changeCartPrice(chocolatePizza.getPriceExtraLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(chocolatePizza.getExtraLargePizza());
						selectSizeDialog.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Wähle eine Größe aus");
				}
				
				// Salami Pizza
				if(PizzaKlassikerPresenter.id==2) {
					if(selectSizeDialog.getSmallRadioBtn().isSelected()) {//Small
						changeCartPrice(salamiPizza.getPriceSmall());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(salamiPizza.getSmallPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getMediumRadioBtn().isSelected()) {//Medium
						changeCartPrice(salamiPizza.getPriceMedium());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(salamiPizza.getMediumPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getLargeRadioBtn().isSelected()) {//Large
						changeCartPrice(salamiPizza.getPriceLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(salamiPizza.getLargePizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getExtraLargeRadioBtn().isSelected()) {//extraLarge
						changeCartPrice(salamiPizza.getPriceExtraLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(salamiPizza.getExtraLargePizza());
						selectSizeDialog.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Wähle eine Größe aus");
				}
				
				// Veggie Pizza
				if(PizzaKlassikerPresenter.id==3) {
					if(selectSizeDialog.getSmallRadioBtn().isSelected()) {//Small
						changeCartPrice(veggiePizza.getPriceSmall());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(veggiePizza.getSmallPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getMediumRadioBtn().isSelected()) {//Medium
						changeCartPrice(veggiePizza.getPriceMedium());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(veggiePizza.getMediumPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getLargeRadioBtn().isSelected()) {//Large
						changeCartPrice(veggiePizza.getPriceLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(veggiePizza.getLargePizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getExtraLargeRadioBtn().isSelected()) {//extraLarge
						changeCartPrice(veggiePizza.getPriceExtraLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(veggiePizza.getExtraLargePizza());
						selectSizeDialog.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
				}
				
				// Tomate Pizza
				if(PizzaKlassikerPresenter.id==4) {
					if(selectSizeDialog.getSmallRadioBtn().isSelected()) {//Small
						changeCartPrice(tomatoePizza.getPriceSmall());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(tomatoePizza.getSmallPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getMediumRadioBtn().isSelected()) {//Medium
						changeCartPrice(tomatoePizza.getPriceMedium());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(tomatoePizza.getMediumPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getLargeRadioBtn().isSelected()) {//Large
						changeCartPrice(tomatoePizza.getPriceLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(tomatoePizza.getLargePizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getExtraLargeRadioBtn().isSelected()) {//extraLarge
						changeCartPrice(tomatoePizza.getPriceExtraLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(tomatoePizza.getExtraLargePizza());
						selectSizeDialog.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Wähle eine Größe aus");
				}
				
				// Sucuk Pizza
				if(PizzaKlassikerPresenter.id==5) {
					if(selectSizeDialog.getSmallRadioBtn().isSelected()) {//Small
						changeCartPrice(sucukPizza.getPriceSmall());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(sucukPizza.getSmallPizza());			
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getMediumRadioBtn().isSelected()) {//Medium
						changeCartPrice(sucukPizza.getPriceMedium());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(sucukPizza.getMediumPizza());	
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getLargeRadioBtn().isSelected()) {//Large
						changeCartPrice(sucukPizza.getPriceLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(sucukPizza.getLargePizza());	
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getExtraLargeRadioBtn().isSelected()) {//extraLarge
						changeCartPrice(sucukPizza.getPriceExtraLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(sucukPizza.getExtraLargePizza());	
						selectSizeDialog.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Wähle eine Größe aus");
				}
				
				// Bacon Pizza
				if(PizzaKlassikerPresenter.id==6) {
					if(selectSizeDialog.getSmallRadioBtn().isSelected()) {//Small
						changeCartPrice(baconPizza.getPriceSmall());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(baconPizza.getSmallPizza()); 
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getMediumRadioBtn().isSelected()) {//Medium
						changeCartPrice(baconPizza.getPriceMedium());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(baconPizza.getMediumPizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getLargeRadioBtn().isSelected()) {//Large
						changeCartPrice(baconPizza.getPriceLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(baconPizza.getLargePizza());
						selectSizeDialog.dispose();
					}
					else if(selectSizeDialog.getExtraLargeRadioBtn().isSelected()) {//extraLarge
						changeCartPrice(baconPizza.getPriceExtraLarge());
						JOptionPane.showMessageDialog(null, "Pizza hinzugefügt");
						// Jlist im CartFrame wird die ausgewählte Pizza hinzugefügt
						cartFrame.setCartList(baconPizza.getExtraLargePizza());
						selectSizeDialog.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Wähle eine Größe aus");
				}
				
			});
			
			
			//Back-Button unter "Bestellen"
			selectSizeDialog.getBackBtn().addActionListener(i -> {
				selectSizeDialog.dispose();
				System.out.println("Gehe aus SelectSizeDialog raus.");
			});
		}
		/**
		 *  Bei einer Pizzabestellung wird der Warenkorb Wert verändert
		 *  Aufaddieren des Warenkorb Wertes
		 *
		 * @param pizzaPrice
		 */
		
		@SuppressWarnings("resource")
		public static void changeCartPrice (double pizzaPrice) {
		double gesamtpreis=0.00;
			if(pizzaPrice==0.0) {
				gesamtpreis =0.0;
//				 Settings.cartPriceLabel.setText(String.valueOf(gesamtpreis));
		        Formatter formatter = new Formatter(new StringBuilder(), Locale.US);
				Settings.cartPriceLabel.setText(formatter.format("%.2f", gesamtpreis).toString());
			}
			else {
				gesamtpreis = Double.parseDouble(Settings.cartPriceLabel.getText()); // Bekommt aktuellen Wert aus dem Warenkorb
//				Settings.cartPriceLabel.setText(String.valueOf(pizzaPrice+gesamtpreis));
		        Formatter formatter = new Formatter(new StringBuilder(), Locale.US);
				Settings.cartPriceLabel.setText(formatter.format("%.2f", pizzaPrice+gesamtpreis).toString());
			}
		}
}
