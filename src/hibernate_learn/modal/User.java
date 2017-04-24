package hibernate_learn.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;;


@Entity 
@Table (name="USER")
public class User {		
	
	
	/* @Entity
	   @Table 
	   @id = Primary key 
	   @GeneratedValue = Auto incremente a surrogate key (int)
	   @Column = Colonne	   
	 */
	
	
	/* Primary key - Auto Increment */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String username;
	
	
	
	/* 09 - Overriding home adress attribute */
		@AttributeOverrides({
			@AttributeOverride(name="street", column=@Column(name="local_street")),
			@AttributeOverride(name="city", column=@Column(name="local_city")),
			@AttributeOverride(name="pinCode", column=@Column(name="local_pin_code")),
		})
		private Adress adress;
		
		@AttributeOverrides({
			@AttributeOverride(name="street", column=@Column(name="home_street")),
			@AttributeOverride(name="city", column=@Column(name="home_city")),
			@AttributeOverride(name="pinCode", column=@Column(name="home_pin_code")),
		})
		private Adress homeAdress;

		
		
	/* 10 - Collections = Jointure de tables */
	@ElementCollection (fetch=FetchType.EAGER)
	@JoinTable (name="user_posts" , joinColumns = @JoinColumn (name="user_id"))
	private Set<Posts> listPosts = new HashSet<Posts>();

	
	
	
	public Set<Posts> getListPosts() {
		return listPosts;
	}
	public void setListPosts(Set<Posts> listPosts) {
		this.listPosts = listPosts;
	}
	public Adress getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(Adress homeAdress) {
		this.homeAdress = homeAdress;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
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
	
}
