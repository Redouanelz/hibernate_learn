package hibernate_learn.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_learn.modal.*;
import hibernate_learn.modal.User;

public class Test {

	public static void main(String[] args){
		
		User user1 = new User();
				
				user1.setUsername("redouanelz");
				
				/* Embedded value object */
				Adress adrr = new Adress();
				adrr.setCity("Temara");
				adrr.setStreet("lot anne marie 04");
				adrr.setPinCode("12000");
				
				Adress adrr2= new Adress();
				adrr2.setCity("Temara");
				adrr2.setStreet("lot anne marie 04");
				adrr2.setPinCode("12000");
		
				user1.setAdress(adrr);
				user1.setHomeAdress(adrr2);
				
				/* Saving Collections  */
				Posts posts = new Posts();
				posts.setTitle("Hello");
				posts.setPost("this is my first post");
				
				Posts posts2 = new Posts();
				posts2.setTitle("Hey everyone");
				posts2.setPost("this is my second post");
				
				user1.getListPosts().add(posts);
				user1.getListPosts().add(posts2);
				
		
		User user2 = new User();
				user2.setUsername("hichamlz");											
				
		User user3 = new User();
				user3.setUsername("youneslz");
				
				
				
		/* One To One Mapping  */
		Group group = new Group();
		group.setId(100);
		group.setName("DWM");			
	    group.getUser().add(user1);
	    
	    Group group2 = new Group();
	    group2.setId(102);
	    group2.setName("SIE");			
	    group2.getUser().add(user1);
		
		/* save */	
		SessionFactory SF = new Configuration().configure().buildSessionFactory();		
		Session session;
	    session = SF.openSession();		
		session.beginTransaction();		

		session.save(user1);	
	    session.save(group); /* save group - one to one mapping */	
		session.save(user2);	
		session.save(user3);	

		

		session.getTransaction().commit();		
		session.close();
		
		
		
		
	  
		/* Proxy Objects and Eager and Lazy Fetch Types */	
		User user = new User();
		user = null;		
		Session session_two;
		session_two = SF.openSession();
		session_two.beginTransaction();		    
		user = (User) session_two.get(User.class, 1);		
		System.out.println(" Size : " +user.getListPosts().size() );
		System.out.println("Username : " +user.getUsername());  	
		
		
		
		
		
		
		
	}
}
