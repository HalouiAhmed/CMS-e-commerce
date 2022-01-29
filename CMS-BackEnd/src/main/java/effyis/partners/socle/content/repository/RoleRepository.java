package effyis.partners.socle.content.repository;

import java.util.Optional;

import effyis.partners.socle.content.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRole(String role);
}
