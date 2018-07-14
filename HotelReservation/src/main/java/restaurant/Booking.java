package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	
	private int id;
	private List<Table> reservedTables;
	private String customerName;
	private String contactNo;

	public Booking(int id, String cusName, String contactNo) {
		this.id = id;
		this.customerName = cusName;
		this.contactNo = contactNo;
		this.reservedTables = new ArrayList<Table>();
	}
	
	public List<Table> getReservedTables(){
		return this.reservedTables;
	}
	
	public void setReservedTable(Table tb) {
		tb.setOccupied(false);
		this.reservedTables.add(tb);
	}
	
	public int getBookingID() {
		return this.id;
	}
	
	public String toString() {
		String tableNo = "";
		for(Table t: this.reservedTables) {
			tableNo += "#" + t.getID() + " ";
		}
		return this.id + ".    '" + this.customerName + "'     '" + this.contactNo + "'    '" + tableNo + "'\n";
	}
	
}
