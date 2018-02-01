package model;
/**
 * Die Klasse repräsentiert das Model einer SucukPizza. Hier sind alle
 * Methoden und Variablen enthalten, die diese Klasse benötigt. 
 *  
 * @author Sean, Kevin, Daniyal, Farid, Sven
 */
public class SucukPizza {
	
	//Preise
	private double priceSmall = 7.60;
	private double priceMedium = 9.40;
	private double priceLarge = 11.30;
	private double priceExtraLarge = 13.70;
	
	//Vorgefertige Strings, die in der GUI zu sehen sind, um den Preis zu veranschaulichen
	private String small = "Sucuk Pizza S " + priceSmall + " €";
	private String medium = "Sucuk Pizza M " + priceMedium + " €";
	private String large = "Sucuk Pizza L " + priceLarge + " €";
	private String extraLarge = "Sucuk Pizza XL " + priceExtraLarge + " €";
	
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
