package model;
/**
 * Die Klasse repräsentiert das Model einer TomatoePizza. Hier sind alle
 * Methoden und Variablen enthalten, die diese Klasse benötigt. 
 *  
 * @author Sean, Kevin, Daniyal, Farid, Sven
 */
public class TomatoePizza {
	
	//Preise
	private double priceSmall = 7.20;
	private double priceMedium = 8.90;
	private double priceLarge = 10.10;
	private double priceExtraLarge = 13.10;
	
	//Vorgefertige Strings, die in der GUI zu sehen sind, um den Preis zu veranschaulichen
	private String small = "Tomaten Pizza S " + priceSmall + " €";
	private String medium = "Tomaten Pizza M " + priceMedium + " €";
	private String large = "Tomaten Pizza L " + priceLarge + " €";
	private String extraLarge = "Tomaten Pizza XL " + priceExtraLarge + " €";
	
	/**
	 * Getter für die Übergabe der Preise und Strings an den Presenter.
	 * @return priceSmall, priceMedium, priceLarge, priceExtraLarge, small, medium, large, extraLarge
	 */
	public double getPriceSmall() {
		return priceSmall;
	}
	
	public double getPriceMedium() {
		return priceMedium;
	}
	
	public double getPriceLarge() {
		return priceLarge;
	}
	
	public double getPriceExtraLarge() {
		return priceExtraLarge;
	}
	
	
	public String getSmallPizza() {
		return small;
	}
	
	public String getMediumPizza() {
		return medium;
	}
	
	public String getLargePizza() {
		return large;
	}
	
	public String getExtraLargePizza() {
		return extraLarge;
	}
}
