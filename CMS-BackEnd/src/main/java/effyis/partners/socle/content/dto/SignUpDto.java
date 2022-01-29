package effyis.partners.socle.content.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import effyis.partners.socle.content.validation.ValidPassword;

public class SignUpDto {
	@NotBlank(message = "enter ur firstName")
	private String firstName;
	@NotBlank(message = "enter ur LastName")
	private String lastName;
	@NotBlank
	@Email(message = "email not valid")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ValidPassword
	@NotBlank
	private String password;
    private boolean agreement;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String oldPassword;
	
	private String adresse;
	
	public boolean isAgreement() {
		return agreement;
	}
	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}
	private String tel;
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
