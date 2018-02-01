package model;
/**
 * Die Klasse repräsentiert das Model einer BaconPizza. Hier sind alle
 * Methoden und Variablen enthalten, die diese Klasse benötigt. 
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 */
public class BaconPizza {
	
	//Preise
	private double priceSmall = 7.70;
	private double priceMedium = 9.50;
	private double priceLarge = 11.40;
	private double priceExtraLarge = 13.70;
	
	//Vorgefertige Strings, die in der GUI zu sehen sind, um den Preis zu veranschaulichen
	private String small = "Bacon Pizza S " + priceSmall + " €";
	private String medium = "Bacon Pizza M " + priceMedium + " €";
	private String large = "Bacon Pizza L " + priceLarge + " €";
	private String extraLarge = "Bacon Pizza XL " + priceExtraLarge + " €";
	
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

