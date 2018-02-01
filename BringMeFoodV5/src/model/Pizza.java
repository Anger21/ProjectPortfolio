package model;
/**
 * Die Klasse repräsentiert eine selbst erstellte Pizza, die sich der Nutzer unter dem
 * Frame "DeinePizza" selber zusammenstellen kann.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 */
public class Pizza {

	//Name des gewählten Pizzaformats
	private static  String deinePizzaName = "";
	
	//Preis der zusammengestellten Pizza
	private static  double price;
	
	
	/**
	 * Der übergebende Preis wird diesem price zugeordnet.
	 * @param price für Pizza.price
	 */
	public  void setName(double price) {
		Pizza.price = price;	
	}
	
	
	/**
	 * Speichert den aktuellen Preis - bei der Zusammenstellung der Pizza - in einem String.
	 * @return deinePizzaName
	 */
	public static String getName() {
		deinePizzaName += "Deine Pizza  "+price+"€ \n";
		return deinePizzaName;		
	}
	
	/**
	 * Die Methode resettet den Preis und den String, um Komplikationen in der ArrayListe zu vermeiden.
	 */
	public void setReset () {
		price = 0;
		deinePizzaName = "";
	}	
}
