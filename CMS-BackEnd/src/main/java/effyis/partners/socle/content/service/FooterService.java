package effyis.partners.socle.content.service;


import effyis.partners.socle.content.dto.ItemFooterDTO;
import effyis.partners.socle.apiconfig.exception.ElementNotFoundException;

import java.util.List;

public interface FooterService {
    List<ItemFooterDTO> getItemFooter();


    void saveItemsFooter(List<ItemFooterDTO> itemsFooter) throws ElementNotFoundException;
}
