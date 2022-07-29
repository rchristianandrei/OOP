
public class Data {
	
	private String [] columns;
	private Object[][] entries;
	
	Data(String [] columns, Object[][] entries){
		
		this.columns = columns;
		this.entries = entries;
	}
	
	String[] getColumns() {
		return this.columns;
	}
	
	Object[][] getEntries() {
		return this.entries;
	}
}
