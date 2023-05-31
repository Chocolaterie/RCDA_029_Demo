package fr.example.demo.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Article {

	@NotBlank
	@Size(min = 4 , max = 255)
	private String title;
	

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
