package effyis.partners.socle.content.service;

import effyis.partners.socle.content.dto.response.AttachementResponseDTO;
import effyis.partners.socle.content.dto.response.UpdateResponseDTO;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */
public interface AttachementService {

	AttachementResponseDTO findAttachementById(Long idAttachement);
	UpdateResponseDTO updateActiveAttachement(int activeLogo, int position);
}
