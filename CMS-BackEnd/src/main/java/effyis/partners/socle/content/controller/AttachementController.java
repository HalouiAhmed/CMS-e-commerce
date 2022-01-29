package effyis.partners.socle.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effyis.partners.socle.content.dto.response.AttachementResponseDTO;
import effyis.partners.socle.content.dto.response.UpdateResponseDTO;
import effyis.partners.socle.content.service.AttachementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */

@RestController
@RequestMapping(path = "/effyis/api/attachement/")
public class AttachementController {

	@Autowired
	AttachementService attachementService;

	@GetMapping(path = "get/{idAttachement}")
	public AttachementResponseDTO getAttachementsById(@PathVariable Long idAttachement) {
		return this.attachementService.findAttachementById(idAttachement);
	}

	@PutMapping(path = "{active}/{position}")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public UpdateResponseDTO updateActiveAndPosition(@PathVariable(name = "active") int activeLogo,
			@PathVariable(name = "position") int position) {
		return this.attachementService.updateActiveAttachement(activeLogo, position);
	}

}
