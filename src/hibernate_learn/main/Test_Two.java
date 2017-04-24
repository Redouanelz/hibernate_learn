package hibernate_learn.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_learn.modal.Account;
import hibernate_learn.modal.Etudiant;
import hibernate_learn.modal.Enseignant;


public class Test_Two {

		public static void main (String[] args)
		{
			
			Account account1 = new Account();
			account1.setUsername("Account1");
			
			Etudiant etudiant1 = new Etudiant();
			etudiant1.setUsername("Etudiant1");
			etudiant1.setNote("20/20");
			
			Enseignant enseignant1 = new Enseignant();
			enseignant1.setUsername("Enseignant1");
			enseignant1.setClasse("Classe Num F5");
			
		 /*	Group group = new Group();
			group.setId(100);
			group.setName("DWM");
			group.getAccount().add(account); */
			
			
			/* save */	
			SessionFactory SF = new Configuration().configure().buildSessionFactory();		
			Session session;
		    session = SF.openSession();		
			session.beginTransaction();		

			session.save(account1);
			session.save(etudiant1);
			session.save(enseignant1);

			
			session.getTransaction().commit();		
			session.close();
		}
}
