package effyis.partners.socle.content.controller;


import effyis.partners.socle.content.dto.ItemSideBarDTO;
import effyis.partners.socle.content.service.ItemSideBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 *
 * @author CHICHI Hamza
 *
 */

@RestController
@RequestMapping("/effyis/api/sidebar")
public class SideBarController {

    @Autowired
    private ItemSideBarService itemSideBarService;


    //Get -> "/effyis/api/sidebar"
    @GetMapping
    public  List<ItemSideBarDTO> getSideBar(){
        return itemSideBarService.getSideBar();
    }

    //Post -> "/effyis/api/sidebar/add"
    @PostMapping("/save")
    public void addItem(@RequestBody List<@Valid ItemSideBarDTO> itemSideBars){
        itemSideBarService.saveItemsSideBar(itemSideBars);
    }

}
