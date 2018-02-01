package model;
/**
 * Die Klasse repräsentiert das Model einer VeggiePizza. Hier sind alle
 * Methoden und Variablen enthalten, die diese Klasse benötigt. 
 *  
 * @author Sean, Kevin, Daniyal, Farid, Sven
 */
public class VeggiePizza {
	
	//Preise
	private double priceSmall = 6.70;
	private double priceMedium = 8.10;
	private double priceLarge = 9.50;
	private double priceExtraLarge = 12.80;
	
	//Vorgefertige Strings, die in der GUI zu sehen sind, um den Preis zu veranschaulichen
	private String small = "Veggie Pizza S " + priceSmall + " €";
	private String medium = "Veggie Pizza M " + priceMedium + " €";
	private String large = "Veggie Pizza L " + priceLarge + " €";
	private String extraLarge = "Veggie Pizza XL " + priceExtraLarge + " €";
	
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
