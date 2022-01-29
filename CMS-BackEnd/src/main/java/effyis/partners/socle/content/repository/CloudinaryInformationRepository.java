package effyis.partners.socle.content.repository;


import java.util.List;
import java.util.Optional;

import effyis.partners.socle.content.entity.CloudinaryInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
*
* @author MAHLA Ilyasse Badreddine
*
*/
@Repository
public interface CloudinaryInformationRepository extends JpaRepository<CloudinaryInformation, Long> {
	
	@Query(value = "SELECT * FROM cloudinary_information where attachement_id = :idAttachement", nativeQuery = true)
	List<CloudinaryInformation> getListByAttachementId(@Param("idAttachement") Long idAttachement);
	
	@Query(value = "SELECT * FROM cloudinary_information WHERE attachement_id = :idAttachement AND active_informations > 2", nativeQuery = true)
	List<CloudinaryInformation> findDeprecatedInformations(@Param("idAttachement") Long idAttachement);

	@Query(value = "SELECT * FROM cloudinary_information where active_informations = :active_information", nativeQuery = true)
	Optional<CloudinaryInformation> findCloudinaryInformationByActive_informations(int active_information);
	
}
