package effyis.partners.socle.content.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import effyis.partners.socle.content.entity.Attachement;
import effyis.partners.socle.content.enums.TypeAttachement;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */
@Repository
public interface AttachementRepository extends JpaRepository<Attachement, Long> {

	Attachement findByTypeAttachement(TypeAttachement typeAttachement);

	@EntityGraph(value = "Attachement.cloudinaryInformationList", type = EntityGraphType.FETCH)
	Attachement findAttachementById(Long attachementId);

}
