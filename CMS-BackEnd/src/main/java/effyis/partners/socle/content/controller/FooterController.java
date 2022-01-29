package effyis.partners.socle.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effyis.partners.socle.apiconfig.exception.ElementNotFoundException;
import effyis.partners.socle.content.dto.ItemFooterDTO;
import effyis.partners.socle.content.service.FooterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/effyis/api/footer")
public class FooterController {

	@Autowired
	private FooterService footerService;

	@GetMapping
	public List<ItemFooterDTO> getItemFooter() {
		return this.footerService.getItemFooter();
	}

	// Post -> "/effyis/api/sidebar/save"
	@PostMapping("/save")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public void saveItem(@RequestBody List<ItemFooterDTO> items) throws ElementNotFoundException {
		this.footerService.saveItemsFooter(items);
	}
}
