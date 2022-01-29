package effyis.partners.socle.content.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "effyis_user")
public class EffyisUser {

	@Id // clés primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncremente
	private long Id;
	@Column(nullable = false, name = "user_id") // valeur non null et longeur ne depaase pas 50
	private String userId;
	@Column(nullable = false, name = "first_name") // valeur non null et longeur ne depaase pas 50
	private String firstName;
	@Column(nullable = false, name = "last_name") // valeur non null et longeur ne depaase pas 50
	private String lastName;
	/*
	 * @Column(nullable = false,name="valide" ) // valeur non null et longeur ne
	 * depaase pas 50 private Boolean verifiedMail=true;
	 */
	@Column(nullable = false, name = "adress") // valeur non null et longeur ne depaase pas 50
	private String adresse;
	@Column(nullable = false, name = "tel") // valeur non null et longeur ne depaase pas 50
	private String tel;
	@Column(nullable = false, name = "agreement") // valeur non null et longeur ne depaase pas 50
	private boolean agreement;

	public boolean isAgreement() {
		return this.agreement;
	}

	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	@NotNull
	private Account account;

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getId() {
		return this.Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public Boolean getVerifiedMail() { return verifiedMail; } public void
	 * setVerifiedMail(Boolean verifiedMail) { this.verifiedMail = verifiedMail; }
	 */
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
