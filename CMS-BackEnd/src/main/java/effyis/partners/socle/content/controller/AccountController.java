package effyis.partners.socle.content.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effyis.partners.socle.content.dto.AccountDTO;
import effyis.partners.socle.content.dto.AuthenticationDTO;
import effyis.partners.socle.content.dto.JwtDTO;
import effyis.partners.socle.content.dto.SignUpDto;
import effyis.partners.socle.content.service.AccountService;
import effyis.partners.socle.content.service.SignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@RestController
@RequestMapping("/effyis/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	SignUpService signUpService;

	@PostMapping("/login")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public JwtDTO authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
		return this.accountService.authenticateUser(authenticationDTO);
	}

	@PutMapping("/update")
	public ResponseEntity<SignUpDto> UpdateUser(@RequestBody SignUpDto signUpDto) {
		SignUpDto UpdatedUser = this.signUpService.putUser(signUpDto);
		return new ResponseEntity<SignUpDto>(UpdatedUser, HttpStatus.ACCEPTED);
	}

	@PostMapping("/SignUp")
	public SignUpDto CreateUser(@Valid @RequestBody SignUpDto signUpDto) {
		return this.signUpService.crreateUser(signUpDto);
	}

	@GetMapping()
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public List<AccountDTO> getAccounts() {
		return this.accountService.getAccounts();
	}
}
