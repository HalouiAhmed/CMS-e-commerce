package effyis.partners.socle.content.repository;


import effyis.partners.socle.content.entity.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CHICHI Hamza
 */

@Repository
public interface FooterRepository extends JpaRepository<Footer,Long> {
}
