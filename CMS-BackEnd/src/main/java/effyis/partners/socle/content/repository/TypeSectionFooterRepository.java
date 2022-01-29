package effyis.partners.socle.content.repository;



import effyis.partners.socle.content.entity.TypeSectionFooter;
import effyis.partners.socle.content.enums.TypeFooterEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeSectionFooterRepository extends JpaRepository<TypeSectionFooter,Long> {

    Optional<TypeSectionFooter> findTypeSectionFooterByType(TypeFooterEnum typeSectionFooter);
}
