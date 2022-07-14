import java.text.DecimalFormat;

public class Money {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	String currency;
	float value = 0;
	
	Money(String currency, float value){
		this.currency = currency;
		this.value = value;
	}
	
	public String toString(){
		return currency + " " + df.format(value);
	}
}