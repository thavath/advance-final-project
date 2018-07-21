package restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order implements CRUD<Food> {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "table_id")
	private Tables table;
	
	@ManyToOne
	@JoinColumn(name ="food_id")
	private List<Food> foodList;
	
	public Order(int id, Tables table) {
		this.id = id;
		this.table = table;
		foodList = new ArrayList<Food>();
	}
	
	public void create(Food f) {
		foodList.add(f);
	}
	
	public ArrayList<Food> read(){
		return (ArrayList<Food>)this.foodList;
	}
	
	public void update(Food f) {
		for(Food food: this.foodList) {
			if(food.getFoodID() == f.getFoodID()) {
				int ind = this.foodList.indexOf(food);
				this.foodList.set(ind,f);
				break;
			}
		}
	}
	
	public void delete(Food f) {
		foodList.remove(f);
	}
	
	public String toString() {
		String orderList = "";
		orderList += "Order #" + this.id + " | " + " Table #" + this.table.getID() + "\n";
		orderList += "----------------------------------------------------" + "\n";
		orderList += "[Code        Name                           Price]" + "\n";
		for(Food food : this.read()) {
			orderList += food.toString() + "\n";
		}
		return orderList;
	}
	
}
