package bikeproject;

public final class RoadBike extends Bike implements RoadParts{
	
	private int  tyreWidth, postHeight;
	
	public RoadBike()
	{
		this("drop", "racing", "tread less", "razor", 19, 20, 22);
	}//end constructor
	
	public RoadBike(int postHeight)
	{
		this("drop", "racing", "tread less", "razor", 19, 20, postHeight);
	}//end constructor
		
	public RoadBike(String handleBars, String frame, String tyres, String seatType, int numGears, int tyreWidth, int postHeight) {
		super(handleBars, frame, tyres, seatType, numGears);
		this.tyreWidth = tyreWidth;
		this.postHeight = postHeight;
	}//end constructor
	
	public RoadBike(Bike bike, int tyreWidth, int postHeight) {
		super(bike.getHandleBars(), bike.getFrame(), bike.getTyres(), bike.getSeatType(), bike.getNumGears());
		this.tyreWidth = tyreWidth;
		this.postHeight = postHeight;
	}
	
	public void printDescription()
	{
		super.printDescription();
		System.out.println("This Roadbike bike has " + this.tyreWidth + "mm tyres and a post height of " + this.postHeight + ".");
	}//end method printDescription

	@Override
	public int getTyreWidth() {
		return this.tyreWidth;
	}//end method 

	@Override
	public void setTyreWidth(int newValue) {
		this.tyreWidth = newValue;
	}//end method 

	@Override
	public int getPostHeight() {
		return this.postHeight;
	}//end method 

	@Override
	public void setPostHeight(int newValue) {
		this.postHeight = newValue;
	}//end method 
	
	public void showBikeParts() {
		super.showBikeParts();
		System.out.println("\t[6] Tyre Width - "+this.tyreWidth);
		System.out.println("\t[7] Post Height - "+this.postHeight);
	}
}//end class RoadBike
