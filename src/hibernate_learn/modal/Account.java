package hibernate_learn.modal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery (name="Account.id" , query = "FROM Account WHERE id = :id ")
@NamedNativeQuery (name="Account.username" , query = "SELECT * FROM Account WHERE username = ? ")

public class Account {

		@Id @GeneratedValue
		private int id;
				
		private String username;
		
		private String password;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
}
