package bikeproject;

public final class MountainBike extends Bike implements MountainParts{

	private String suspension, type;
	private int frameSize;
	
	public MountainBike()
	{
		this("Bull Horn", "Hardtail", "Maxxis", "dropper", 27, "RockShox XC32", "Pro", 19);
	}//end constructor
	
    public MountainBike(String handleBars, String frame, String tyres, String seatType, int numGears, 
    		            String suspension, String type, int frameSize) {
		super(handleBars, frame, tyres, seatType, numGears);
		this.suspension = suspension;
		this.type = type;
		this.frameSize = frameSize;
	}//end constructor
    
    public MountainBike(Bike bike, String suspension, String type, int frameSize) {
    	super(bike.getHandleBars(), bike.getFrame(), bike.getTyres(), bike.getSeatType(), bike.getNumGears());
    	this.suspension = suspension;
		this.type = type;
		this.frameSize = frameSize;
    }
    
	public void printDescription()
	{
		super.printDescription();
		System.out.println("This mountain bike is a " + this.type + " bike and has a " + this.suspension + " suspension and a frame size of " + this.frameSize + "inches.");
		
	}//end method printDescription

	@Override
	public String getSuspension() {
		return this.suspension;
	}//end method getSuspension

	@Override
	public void setSuspension(String newValue) {
		this.suspension = newValue;
	}//end method setSuspension

	@Override
	public String getType() {
		return this.type;
	}//end method getType

	@Override
	public void setType(String newValue) {
		this.type = newValue;
	}//end method setType
	
	public void setFrameSize(int newValue) {
		this.frameSize = newValue;
	}
	
	public void showBikeParts() {
		super.showBikeParts();
		System.out.println("\t[6] Suspension - "+this.suspension);
		System.out.println("\t[7] Type - "+this.type);
		System.out.println("\t[8] Frame Size - "+this.frameSize);
	}
}//end class MountainBike
