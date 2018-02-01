package presenter;

import settings.Settings;
import view.PizzaKlassikerFrame;

/**
 * Die Klasse repräsentiert den Presenter für das PizzaKlassikerFrame.
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see PizzaKlassikerFrame
 * @see Settings
 */

public class PizzaKlassikerPresenter {

	PizzaKlassikerFrame pizzaKlassikerFrame = new PizzaKlassikerFrame();
	Settings settings = new Settings();
	
	//id zum Zuordnen der Pizzen
	public static int id;
	
	/**
	 * Öffnet das PizzaKlassikerFrame und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
	 */
	public PizzaKlassikerPresenter() {
		
		pizzaKlassikerFrame.setVisible(true);
		// ###PizzaKlassiker ActionListener###
		pizzaKlassikerFrame.getBackButton().addActionListener(e -> {
			new MainFramePresenter();
			pizzaKlassikerFrame.setVisible(false);
		});
		
		pizzaKlassikerFrame.getCartButton().addActionListener(e -> {
			new CartPresenter();
			pizzaKlassikerFrame.setVisible(false);
		});
		
		pizzaKlassikerFrame.getPizzaChocolateBtn().addActionListener(e -> {
			id =0;
			id += 1;
			new SelectSizeDialogPresenter();
			System.out.println("Schokolade"+id);
		});
		
		pizzaKlassikerFrame.getPizzaSalamiBtn().addActionListener(e -> {
			id =0;
			id += 2;
			new SelectSizeDialogPresenter();
			System.out.println("Salami"+id);
		});
		
		pizzaKlassikerFrame.getPizzaVeggieBtn().addActionListener(e -> {
			id =0;
			id += 3;
			new SelectSizeDialogPresenter();
			System.out.println("Veggie"+id);
		});
		
		pizzaKlassikerFrame.getPizzaTomatoeBtn().addActionListener(e -> {
			id =0;
			id += 4;
			new SelectSizeDialogPresenter();
			System.out.println("Tomatoe"+id);
		});
		
		pizzaKlassikerFrame.getPizzaSucukBtn().addActionListener(e -> {
			id =0;
			id += 5;
			new SelectSizeDialogPresenter();
			System.out.println("Sucuk"+id);
		});
		
		pizzaKlassikerFrame.getPizzaBaconBtn().addActionListener(e -> {
			id =0;
			id += 6;
			new SelectSizeDialogPresenter();
			System.out.println("Bacon"+id);
		});
		
		
	}
	
	/**
	 * 
	 * @author Sean, Kevin, Daniyal, Farid, Sven
	 * Die Klasse repräsentiert das Dialogfenster, welches vom PizzaKlassikerFrame aufgerufen wird.
	 * 
	 */
	// SelectSize Dialog msus noch ausgelagert werden !!
	
	
}
