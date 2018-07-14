package restaurant;

public class Table {
	
	private int numSeats;
	private String id;
	private boolean available;

	public Table(int numSeats, String id, boolean available) {
		this.numSeats = numSeats;
		this.id = id;
		this.available = available;
	}
	
	public void setOccupied(boolean available) {
		this.available = available;
	}
	
	public boolean getOccupied() {
		return this.available;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String toString() {
		String tableStatus = this.available? "Free" : "Busy";
		return "'Table#" + this.id + "'   'Seats: " + this.numSeats + "'   '" + tableStatus + "'\n"; 
	}
	
}
