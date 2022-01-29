package effyis.partners.socle.content.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import effyis.partners.socle.content.dto.response.DeleteResponseDTO;
import effyis.partners.socle.content.dto.response.UrlResponseDTO;
import effyis.partners.socle.content.service.CloudinaryInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */

@RestController
@RequestMapping(path = "/effyis/api/cloudinary")
public class CloudinaryInformationController {

	@Autowired
	CloudinaryInformationService cloudinaryInformationService;

	@PostMapping(path = "/upload/{typeAttachement}")
	public UrlResponseDTO uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String typeAttachement)
			throws IOException {
		UrlResponseDTO urlResponseDTO = this.cloudinaryInformationService.uploadFile(file, typeAttachement);
		return urlResponseDTO;
	}

	@GetMapping(path = "/delete/{idInformation}")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public DeleteResponseDTO DeleteInformation(@PathVariable Long idInformation) throws IOException {
		DeleteResponseDTO deleteResponseDTO = this.cloudinaryInformationService.DeleteInformation(idInformation);
		return deleteResponseDTO;
	}
}
