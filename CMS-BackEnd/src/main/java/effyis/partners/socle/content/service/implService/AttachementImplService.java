package effyis.partners.socle.content.service.implService;

import java.util.ArrayList;
import java.util.List;

import effyis.partners.socle.content.service.AttachementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import effyis.partners.socle.content.dto.response.AttachementResponseDTO;
import effyis.partners.socle.content.dto.response.UpdateResponseDTO;
import effyis.partners.socle.content.entity.Attachement;
import effyis.partners.socle.content.enums.TypeAttachement;
import effyis.partners.socle.content.repository.AttachementRepository;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */
@Service
public class AttachementImplService implements AttachementService {

	@Autowired
	AttachementRepository attachementRepository;

	@Override
	public AttachementResponseDTO findAttachementById(Long idAttachement) {
		AttachementResponseDTO attachementResponseDTO = new AttachementResponseDTO();
		if (attachementRepository.findAttachementById(idAttachement).getCloudinaryInformationList().isEmpty()) {
			attachementResponseDTO.setStoreName("StoreDefaultName");
			return attachementResponseDTO;
		} else {
			Attachement attachement = attachementRepository.findAttachementById(idAttachement);
			ModelMapper mapper = new ModelMapper();
			attachementResponseDTO = mapper.map(attachement, AttachementResponseDTO.class);
			return attachementResponseDTO;
		}
	}

	@Override
	public UpdateResponseDTO updateActiveAttachement(int activeLogo, int position) {
		UpdateResponseDTO updateDto = new UpdateResponseDTO();
		List<Integer> activeValues = new ArrayList<>();
		activeValues.add(0);
		activeValues.add(1);
		activeValues.add(2);
		List<Integer> positionValues = new ArrayList<>();
		positionValues.add(0);
		positionValues.add(1);
		if (activeValues.contains(activeLogo) && positionValues.contains(position)) {
			Attachement attachement = attachementRepository.findByTypeAttachement(TypeAttachement.LOGO);
			attachement.setActiveAttachement(activeLogo);
			attachement.setPositionAttachement(position);
			attachementRepository.save(attachement);
			updateDto.setRespone("updated successfully");
		} else {
			if (!activeValues.contains(activeLogo)) {
				updateDto.setRespone("activeLogo must be one of the 3: {0,1,2}");
			}
			if (!positionValues.contains(position)) {
				updateDto.setRespone("position must be one of the 2: {0,1}");
			}
		}
		return updateDto;
	}
}
