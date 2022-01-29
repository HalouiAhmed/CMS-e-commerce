package effyis.partners.socle.content.service;

import java.util.List;
import java.util.Optional;

import effyis.partners.socle.content.dto.AccountDTO;
import effyis.partners.socle.content.dto.AuthenticationDTO;
import effyis.partners.socle.content.dto.JwtDTO;
import effyis.partners.socle.content.entity.Account;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface AccountService {

	Optional<Account> findByLogin(String login);

	JwtDTO authenticateUser(AuthenticationDTO authenticationDTO);

	List<AccountDTO> getAccounts();
	String getConnectedUser();

}
