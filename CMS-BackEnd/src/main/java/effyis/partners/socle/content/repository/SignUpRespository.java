package effyis.partners.socle.content.repository;

import effyis.partners.socle.content.entity.Account;
import effyis.partners.socle.content.entity.EffyisUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository 
public interface SignUpRespository extends JpaRepository<EffyisUser,Long> {
	
EffyisUser findByUserId(String userId);
EffyisUser findByAccount(Account account);
}

