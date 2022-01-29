package effyis.partners.socle.content.service.implService;

import java.io.IOException;

import effyis.partners.socle.content.service.CloudinaryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import effyis.partners.socle.content.dto.response.DeleteResponseDTO;
import effyis.partners.socle.content.dto.response.UrlResponseDTO;
import effyis.partners.socle.content.repository.AttachementRepository;
import effyis.partners.socle.content.repository.CloudinaryInformationRepository;
import effyis.partners.socle.content.util.factory.CloudinaryInformationServiceFactory;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */
@Service
public class CloudinaryInformationImplService implements CloudinaryInformationService {

	@Autowired
	CloudinaryInformationRepository cloudinaryInformationRepository;

	@Autowired
	AttachementRepository attachementRepository;
	
	@Autowired
	CloudinaryInformationServiceFactory factory;
	
	@Autowired
	Cloudinary cloudinary;
	
	@Override
	public UrlResponseDTO uploadFile(MultipartFile file, String typeAttachement) throws IOException {
		return factory.uploadFactoryMethod(file, typeAttachement); // call the factory method to process according to attachement type
	}

	@Override
	public DeleteResponseDTO DeleteInformation(Long idInformation) throws IOException {
		DeleteResponseDTO deleteResponseDTO = new DeleteResponseDTO();
			if (cloudinaryInformationRepository.findAll().isEmpty()) {
				deleteResponseDTO.setResponse("no attachement");
			} else {
				cloudinary.uploader().destroy(cloudinaryInformationRepository.findById(idInformation).get().getPublic_id(), ObjectUtils.emptyMap());
				cloudinaryInformationRepository.deleteById(idInformation);
				deleteResponseDTO.setResponse("success");
			}
		return deleteResponseDTO;
	}
}
