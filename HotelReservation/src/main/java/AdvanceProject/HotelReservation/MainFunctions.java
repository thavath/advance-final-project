package AdvanceProject.HotelReservation;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import restaurant.Booking;
import restaurant.BookingDetail;
import restaurant.Food;
import restaurant.Tables;


public class MainFunctions {

//	public static void main(String[] args) {
//		
//		MainFunctions m = new MainFunctions();
//		m.retrieveFoodTest();
//	}
//	
	
	//	-----------------------Get data From Table-------------------------------------------------
	public void getDataFromTable() {
		SessionFactory factoryStudent =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tables.class)
				.buildSessionFactory();
		Session session = factoryStudent.getCurrentSession();
		try {
			
			session.beginTransaction();
			List table = new ArrayList();
			table = session.createQuery("from tables").getResultList(); 
			
			
			System.out.println(table);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factoryStudent.close();
		}
	
	}
//	-----------------------Create Table Model-------------------------------------------------
	public void createTable(int numSeat,String id,Boolean status ) {
		SessionFactory factoryStudent =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tables.class)
				.buildSessionFactory();
		Session session = factoryStudent.getCurrentSession();
		try {
			Tables tableObject = new Tables(numSeat, id, status);
			session.beginTransaction();
			session.save(tableObject);
			
			session.getTransaction().commit();
			System.out.println("Inserted!!!!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factoryStudent.close();
		}
		
	
	}
	
	//	-----------------------Create Food Model-------------------------------------------------
	public void createFood (String id ,String name,double price) {
		SessionFactory factoryStudent =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Food.class)
				.buildSessionFactory();
		Session session = factoryStudent.getCurrentSession();
		try {
			Food food = new Food(id, name,price);
			session.beginTransaction();
			session.save(food);
			
			session.getTransaction().commit();
			System.out.println("Inserted!!!!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factoryStudent.close();
		}
		
	
	
	}
	

	
	public void retrieveFoodTest() {
		SessionFactory factoryStudent =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Food.class)
				.buildSessionFactory();
		Session session = factoryStudent.getCurrentSession();
		try {
			
			session.beginTransaction();
			Query queryResult = session.createQuery("from Food");
			
			List<Food> foodList  = queryResult.getResultList();

			for (int i = 0; i < foodList.size(); i++) {
				Food food =  (Food) foodList.get(i);
				
				System.out.println(food.toString());
				
			}
			
			System.out.println("Database contents delivered...");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
//	public void createBookingDetail (String bookingId ,String tableID) {
//		SessionFactory factoryStudent =  new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(BookingDetail.class)
//				.buildSessionFactory();
//		Session session = factoryStudent.getCurrentSession();
//		try {
//			BookingDetail bDetail = new BookingDetail(bookingId, tableID);
//			session.beginTransaction();
//			session.save(bDetail);
//			
//			session.getTransaction().commit();
//			System.out.println("Booking Detail Inserted!!!!");
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			factoryStudent.close();
//		}
//		
//	
//	
//	}
	// ============================= Create Reservation Section =====================
//	public void createReservation (int id ,String name,String phone) {
//		SessionFactory factoryStudent =  new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Booking.class)
//				.buildSessionFactory();
//		Session session = factoryStudent.getCurrentSession();
//		try {
//			Booking booking = new Booking(id, name,phone);
//			booking.setReservedTable(null);
//			session.beginTransaction();
//			session.save(booking);
//			
//			session.getTransaction().commit();
//			System.out.println("Inserted!!!!");
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			factoryStudent.close();
//		}
//			
//	}
	

	
}
