package fr.example.demo.bo;

public class AppUser {

	protected String email;
	protected String password;
	protected String pseudo;
	
	/**
	 * @param email
	 * @param password
	 * @param pseudo
	 */
	public AppUser(String email, String password, String pseudo) {
		super();
		this.email = email;
		this.password = password;
		this.pseudo = pseudo;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
