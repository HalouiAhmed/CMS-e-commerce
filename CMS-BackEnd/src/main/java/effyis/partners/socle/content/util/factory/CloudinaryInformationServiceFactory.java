package effyis.partners.socle.content.util.factory;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import effyis.partners.socle.content.dto.response.UrlResponseDTO;

public interface CloudinaryInformationServiceFactory {

	public UrlResponseDTO uploadFactoryMethod(MultipartFile multipartfile, String attachementType) throws IOException;
}
