package effyis.partners.socle.content.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import effyis.partners.socle.content.dto.response.DeleteResponseDTO;
import effyis.partners.socle.content.dto.response.UrlResponseDTO;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */
public interface CloudinaryInformationService {

	public UrlResponseDTO uploadFile(MultipartFile file, String typeAttachement) throws IOException;
	public DeleteResponseDTO DeleteInformation(Long idInformation) throws IOException;
}
