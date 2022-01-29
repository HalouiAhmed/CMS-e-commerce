package effyis.partners.socle.content.service;


import effyis.partners.socle.content.dto.SignUpDto;

public interface SignUpService {
		
	SignUpDto crreateUser(SignUpDto signUpDto);
	SignUpDto putUser(SignUpDto signUpDto);
	
}
