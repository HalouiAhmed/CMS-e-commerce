package effyis.partners.socle.content.service;

/**
 *
 * @author CHICHI Hamza
 *
 */
import effyis.partners.socle.content.dto.ItemSideBarDTO;
import java.util.List;


public interface ItemSideBarService {
    List<ItemSideBarDTO> getSideBar();

    void saveItemsSideBar(List<ItemSideBarDTO> itemSideBars);
}
