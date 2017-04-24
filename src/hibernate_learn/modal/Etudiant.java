package hibernate_learn.modal;

import javax.persistence.Entity;


@Entity
public class Etudiant  extends Account{
	private String Note;

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}
	
}
