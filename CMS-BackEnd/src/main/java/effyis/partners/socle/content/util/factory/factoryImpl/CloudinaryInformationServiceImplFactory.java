package effyis.partners.socle.content.util.factory.factoryImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import effyis.partners.socle.content.dto.response.UrlResponseDTO;
import effyis.partners.socle.content.entity.Attachement;
import effyis.partners.socle.content.entity.CloudinaryInformation;
import effyis.partners.socle.content.enums.TypeAttachement;
import effyis.partners.socle.content.repository.AttachementRepository;
import effyis.partners.socle.content.repository.CloudinaryInformationRepository;
import effyis.partners.socle.content.util.CloudinaryUtil;
import effyis.partners.socle.content.util.FileConverter;
import effyis.partners.socle.content.util.FileSizeCalculator;
import effyis.partners.socle.content.util.factory.CloudinaryInformationServiceFactory;

@Component
public class CloudinaryInformationServiceImplFactory implements CloudinaryInformationServiceFactory, CloudinaryUtil {
	
	@Autowired
	CloudinaryInformationRepository cloudinaryInformationRepository;

	@Autowired
	AttachementRepository attachementRepository;

	@Autowired
	Cloudinary cloudinary;

	@Override
	public UrlResponseDTO uploadFactoryMethod(MultipartFile multipartfile, String attachementType) throws IOException {
		List<String> imageTypes = new ArrayList<>();
		imageTypes.add("image/png");
		imageTypes.add("image/jpg");
		imageTypes.add("image/jpeg");
		UrlResponseDTO urlResponseDTO = new UrlResponseDTO();
		String message = null;
		File uploadedFile = FileConverter.convertMultiPartToFile(multipartfile); // convert MultipartFile to File
		if (TypeAttachement.LOGO.toString().equalsIgnoreCase(attachementType)) { // logo typeAttachement Case process
			if (FileSizeCalculator.filesizeInMegaBytes(uploadedFile) <= 1.5
					&& imageTypes.contains(multipartfile.getContentType())) {
				Map uploadResult = uploadGeneric(uploadedFile, cloudinary); // upload to Cloudinary
				FileConverter.cleanTemporary(uploadedFile); // Delete File from project
				urlResponseDTO.setResponse("File uploaded successfully");
				CloudinaryInformation cloudinaryInformation = new CloudinaryInformation(); //  Create a new CloudinaryInformation object set the data from
				setCloudinaryInfoGeneric(uploadResult, cloudinaryInformation);  // set the data from Cloudinary into the object
				Attachement attachement = attachementRepository.findByTypeAttachement(TypeAttachement.LOGO);
				Long idAttachementTemp = attachementRepository.findByTypeAttachement(TypeAttachement.LOGO).getId();
				cloudinaryInformation.setAttachement(attachement); // Set Parent Child Foreign key relationship
				if (cloudinaryInformationRepository.getListByAttachementId(idAttachementTemp).isEmpty()) {
					cloudinaryInformationRepository.save(cloudinaryInformation);
				} else { // apply saving logo's cloudinaryInformations logic
					for (CloudinaryInformation cloudinaryInformationTemp : cloudinaryInformationRepository
							.getListByAttachementId(idAttachementTemp)) {
						cloudinaryInformationTemp
								.setActiveInformation(cloudinaryInformationTemp.getActiveInformation() + 1);
						cloudinaryInformationRepository.save(cloudinaryInformationTemp);
						cloudinaryInformationRepository.save(cloudinaryInformation);
					}
					for (CloudinaryInformation cloudinaryInformationTemp : cloudinaryInformationRepository // Delete files which have activeInformation greater than 2 from the cloud
							.findDeprecatedInformations(idAttachementTemp)) {
						cloudinary.uploader().destroy(cloudinaryInformationTemp.getPublic_id(), uploadResult);
					}
					cloudinaryInformationRepository
							.deleteAll(cloudinaryInformationRepository.findDeprecatedInformations(idAttachementTemp));  // Delete files which have activeInformation greater than 2 from the DataBase
				}
			}
			else {
				if (FileSizeCalculator.filesizeInMegaBytes(uploadedFile) > 1.5) { // File size not respected process
					urlResponseDTO.setResponse("Veillez selectionnner un fichier de taille maximal 1.5 Mo");
					FileConverter.cleanTemporary(uploadedFile);
				}
				if (!imageTypes.contains(multipartfile.getContentType())) { // File extension not respected process
					urlResponseDTO.setResponse("Veillez selectionnner un fichier de format png, jpg, ou jpeg");
					FileConverter.cleanTemporary(uploadedFile);
				}
			}
		}
		
		if(TypeAttachement.SLIDESHOW.toString().equalsIgnoreCase(attachementType)) {   // slideshow typeAttachement Case process
			if (FileSizeCalculator.filesizeInMegaBytes(uploadedFile) <= 3		
					&& imageTypes.contains(multipartfile.getContentType())) {
				Map uploadResult = uploadGeneric(uploadedFile, cloudinary);	// upload to Cloudinary
				FileConverter.cleanTemporary(uploadedFile); // Delete File from project
				urlResponseDTO.setResponse("File uploaded successfully");
				CloudinaryInformation cloudinaryInformation = new CloudinaryInformation();
				setCloudinaryInfoGeneric(uploadResult, cloudinaryInformation);	/* Create a new CloudinaryInformation object  
				 																	and set the data from Cloudinary to the object */
				Attachement attachement = attachementRepository.findByTypeAttachement(TypeAttachement.SLIDESHOW);
				Long idAttachementTemp = attachementRepository.findByTypeAttachement(TypeAttachement.SLIDESHOW).getId();
				cloudinaryInformation.setAttachement(attachement); // Set Parent Child Foreign key relationship
				cloudinaryInformationRepository.save(cloudinaryInformation); // save into DataBase
			}
			else {
				if (FileSizeCalculator.filesizeInMegaBytes(uploadedFile) > 3) { // File size not respected process
					urlResponseDTO.setResponse("Veillez selectionnner un fichier de taille maximal 3 Mo");
					FileConverter.cleanTemporary(uploadedFile);
				}
				if (!imageTypes.contains(multipartfile.getContentType())) { // File extension not respected process
					urlResponseDTO.setResponse("Veillez selectionnner un fichier de format png, jpg, ou jpeg");
					FileConverter.cleanTemporary(uploadedFile);
				}
			}
		} 
		return urlResponseDTO;
	}
}
