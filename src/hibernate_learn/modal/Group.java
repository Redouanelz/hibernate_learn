package hibernate_learn.modal;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="GROUP")
public class Group {

	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	
	
	/* 13 - One to One Mapping  */
	@OneToMany
	private Collection<User> user = new ArrayList<User>();
	
	// @OneToMany(cascade = CascadeType.PERSIST)
	// @JoinTable(name="ACCOUNT_GROUP",joinColumns = @JoinColumn(name="group_identifiant"))
	private Collection<Account> account = new ArrayList<Account>();
	

	public Collection<Account> getAccount() {
		return account;
	}

	public void setAccount(Collection<Account> account) {
		this.account = account;
	}

	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
