package effyis.partners.socle.content.service.implService;


import effyis.partners.socle.content.service.ItemSideBarService;
import effyis.partners.socle.content.dto.ItemSideBarDTO;
import effyis.partners.socle.content.entity.ItemSideBar;
import effyis.partners.socle.content.entity.SideBar;
import effyis.partners.socle.content.repository.ItemSideBarRepository;
import effyis.partners.socle.content.repository.SideBarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author CHICHI Hamza
 *
 */

@Service
public class ItemSideBarImplService implements ItemSideBarService {
    @Autowired
    private SideBarRepository sideBarRepository;
    @Autowired
    private ItemSideBarRepository itemSideBarRepository;
    @Autowired
    private ModelMapper modelMapper;

    //GetMapping method to get all the items from db
    @Override
    public List<ItemSideBarDTO> getSideBar() {
        if(this.checkSideBarIsEmpty()){
            SideBar _sideBar = new SideBar();
            sideBarRepository.save(_sideBar);
        }
        return this.sideBarRepository.findAll().stream().findFirst().get().getItemSideBarList().stream()
                .map(item -> this.modelMapper.map(item, ItemSideBarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveItemsSideBar(List<ItemSideBarDTO> itemSideBarDTOList) {
        itemSideBarRepository.truncateItemSidebarTable();
        itemSideBarRepository.flush();
        if(this.checkSideBarIsEmpty()){
            SideBar _sideBar = new SideBar();
            sideBarRepository.save(_sideBar);
        }
        List<ItemSideBar> itemSideBarList = itemSideBarDTOList
                .stream()
                .map(itemSideBarDTO -> this.modelMapper.map(itemSideBarDTO, ItemSideBar.class))
                .collect(Collectors.toList());
        Optional<SideBar> sideBarOptional = sideBarRepository.findAll().stream().findFirst();
        sideBarOptional.get().getItemSideBarList().clear();
        sideBarOptional.get().getItemSideBarList().addAll(itemSideBarList);
    }

    public boolean checkSideBarIsEmpty(){
        Optional<SideBar> sideBar = sideBarRepository.findAll().stream().findFirst();
        return !sideBar.isPresent();
    }
}