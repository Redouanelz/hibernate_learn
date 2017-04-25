package hibernate_learn.main;



import java.util.List;

import hibernate_learn.modal.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Crud {

		public static void main ( String[] args)
		{
			/* save */	
			SessionFactory SF = new Configuration().configure().buildSessionFactory();		
			Session session;
		    session = SF.openSession();		
			session.beginTransaction();		
			
			String id = "1";
			String username = "Account1";
			String password = "1";
			
			/* simple query */
			
		
		    Query query = session.createQuery("FROM Account WHERE username = :username AND password = :password AND id = :id ");
			query.setInteger("id", Integer.parseInt(id) );
			query.setString("username", username);
			query.setString("password", password);  
			
			
			/* NamedQuery */
			/*Query query = session.getNamedQuery("Account.id");
			query.setInteger("id", Integer.parseInt(id) );*/
			
			
			/* NamedNativeQuery */
			/*Query query = session.getNamedNativeQuery("Account.username");
			query.setString(0, username); */
	
			

			List<Account> Accounts = (List<Account>) query.list();
			/*query.setFirstResult(1);
			query.setMaxResults(3);*/
			
			session.getTransaction().commit();		
			session.close();
			System.out.println("Size Count : " + Accounts.size());
			
			
			for(Account A : Accounts)
				System.out.println(A.getUsername());
		}
}
