package hibernate_learn.modal;

import javax.persistence.Embeddable;

@Embeddable
public class Posts {
	
	private String title;
	
	private String post;
		
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
}
