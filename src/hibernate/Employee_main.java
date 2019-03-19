package hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Employee_main {
	
	public static void main(String[] args) {
		
		SessionFactory factor = new Configuration().configure().buildSessionFactory();
		Session session = factor.openSession();
		
		Scanner sr = new Scanner(System.in);
		
				while(true) {
				System.out.println("1) INSERT EMPLOYEE DETAILS \n2) UPDATE \n3) DISPLAY \n4) DELETE \n5) EXIT");
				System.out.println("Enter the choice of operation: ");
				int choice =  sr.nextInt();
				
					switch(choice) {
					
					case 1: 
							add(factor ,sr);
							break;
					
					case 2: update(factor,sr);
							break;
					
					case 3:
							display(factor,sr);
							break;
					
					case 5:
							
					}
				}
	}
		//This is to take the number of employees to input and then input into the table
		
		
		public static void add(SessionFactory factor, Scanner sr){
			Session sess = factor.openSession();
			Transaction tx = sess.beginTransaction();
			System.out.println("Enter number of employees to Enter : ");
			int obj = sr.nextInt();
		
		
			for(int i=0;i<obj;i++) {
				Employee e1 = new Employee();
				
				System.out.println("Enter First Name: ");
				String fn = sr.next();
				e1.setFirstName(fn);
				
				System.out.println("Enter Last Name: ");
				String ln = sr.next();
				e1.setLastName(ln);
				
				System.out.println("Enter Salary: ");
				int sal = sr.nextInt();
				e1.setSalary(sal);
				
				sess.save(e1);
			}
			
			tx.commit();
			sess.close();
		}
		
		
		
		public static void update(SessionFactory factor, Scanner sr) {
			Session sess= factor.openSession();
			Transaction tx = sess.beginTransaction();
			System.out.println("Enter ID to Update : ");
			int frst = sr.nextInt();
			
			Employee e = new Employee();
		      e.setId(frst);
		      
		      System.out.println("Enter new First Name : ");
		      String fn = sr.next();
		      e.setFirstName(fn);
		      
		      System.out.println("Enter new Last Name : ");
		      String ln = sr.next();
		      e.setLastName(ln);
		      
		      System.out.println("Enter new Salary : ");
		      int sal = sr.nextInt();
		      e.setSalary(sal);
		      
				sess.update(e);
				tx.commit();
				System.out.println("Succesfully updated...!!!");
		      sess.close();
			
			
		}
		
		
		public static void display(SessionFactory factor, Scanner sr) {
			Session sess= factor.openSession();
			Transaction tx = sess.beginTransaction();
			System.out.println("Enter first name to display : ");
			String frst = sr.next();
			
			List bookList = sess.createQuery("from Employee where firstName = '"+frst+"'").list();
			Iterator itr = bookList.iterator();
			 
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		
		}
		
		
		
		
		//to display all values in the data
		/*
		session = factory.openSession();
		List bookList = session.createQuery("from Employee").list();
		Iterator itr = bookList.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		session.close();
		*/
		
		
		//to display a specific name content
	
		
		 /* Update employee's records */
		/*
		session = factory.openSession();
	      Employee e = new Employee();
	      e.setId(9000);
	      e.setFirstName("Wolfman");
	      e.setLastName("Crooney");
	      e.setSalary(150000);
	      Transaction ts = session.beginTransaction();
			session.update(e);
			ts.commit();
			System.out.println("Succesfully updated...!!!");
	      session.close();
	      */
	}

