package hibernate_learn.modal;

import javax.persistence.Entity;

@Entity
public class Enseignant extends Account {
	
	public String Classe;

	public String getClasse() {
		return Classe;
	}

	public void setClasse(String classe) {
		Classe = classe;
	}
	
	
}
