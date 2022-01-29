package effyis.partners.socle.content.repository;

import java.util.Optional;

import effyis.partners.socle.content.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByLogin(String login);
	Optional<Account> findById(Long id);

}
