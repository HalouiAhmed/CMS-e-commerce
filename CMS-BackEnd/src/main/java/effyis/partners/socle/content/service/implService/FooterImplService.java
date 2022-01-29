package effyis.partners.socle.content.service.implService;


import effyis.partners.socle.content.service.FooterService;
import effyis.partners.socle.content.dto.ItemFooterDTO;
import effyis.partners.socle.content.entity.*;
import effyis.partners.socle.content.enums.TypeAttachement;
import effyis.partners.socle.content.enums.TypeFooterEnum;
import effyis.partners.socle.apiconfig.exception.ElementNotFoundException;
import effyis.partners.socle.content.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author CHICHI Hamza
 *
 */

@Service
public class FooterImplService implements FooterService {

    @Value("${footer.max.section}")
    private int max_footer_section;
    @Autowired
    ItemFooterRepository itemFooterRepository;
    @Autowired
    TypeSectionFooterRepository typeSectionFooterRepository;
    @Autowired
    FooterRepository footerRepository;
    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    CloudinaryInformationRepository cloudinaryInformationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemFooterDTO> getItemFooter() {
        return this.footerRepository.findAll().get(0).getItems().stream()
                .map(item -> this.modelMapper.map(item, ItemFooterDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveItemsFooter(List<ItemFooterDTO> itemsFooterDTOList) {
        itemFooterRepository.truncateItemFooterTable();
        itemFooterRepository.flush();

        //List of item footer to save
        List<ItemFooter> itemFooterList = new ArrayList<>();
        this.checkListIsGreaterThanMaxSection(max_footer_section,itemsFooterDTOList);

        itemsFooterDTOList.forEach(itemFooterDTO -> {
            TypeFooterEnum typeFooterEnum = itemFooterDTO.getType();

            //itemFooter to save it in the itemFooterRepository
            ItemFooter itemFooter = new ItemFooter();

            //If the client want to insert a logo in the footer
            if (typeFooterEnum.name().equals(TypeFooterEnum.URL_IMAGE.name())){
                CloudinaryInformation logo_image = this.getActiveLogo();
                itemFooter.setTypeSection(typeFooterEnum);
                //Set the url of the logo in the dto
                itemFooterDTO.setContent(logo_image.getSecure_url());
                this.modelMapper.map(itemFooterDTO,itemFooter);
            }
            else {
                itemFooter.setTypeSection(typeFooterEnum);
                this.modelMapper.map(itemFooterDTO,itemFooter);
            }
            //Fill the list with itemFooter
            itemFooterList.add(itemFooter);
        });

        //Clear the footer_x_item join table and add the itemFooterList to the database
        Optional<Footer> footerOptional = footerRepository.findAll().stream().findFirst();
        footerOptional.get().getItems().clear();
        footerOptional.get().getItems().addAll(itemFooterList);
    }


    private void checkListIsGreaterThanMaxSection(int max_footer_section, List<ItemFooterDTO> itemsFooterDTOList){
        if ( max_footer_section < itemsFooterDTOList.size()){
            throw new IllegalStateException("Max section number is : " + max_footer_section );
        }
    }
    public CloudinaryInformation getActiveLogo(){
        Attachement attachement_logo = attachementRepository.findByTypeAttachement(TypeAttachement.LOGO);
        int active_information = attachement_logo.getActiveAttachement();
        //Get the logo from the database
        Optional<CloudinaryInformation> logo_image = cloudinaryInformationRepository
                .findCloudinaryInformationByActive_informations(active_information);
        if (!logo_image.isPresent()){
            throw new ElementNotFoundException("logo");
        }
        return logo_image.get();
    }
}
