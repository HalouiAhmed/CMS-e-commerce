package effyis.partners.socle.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import effyis.partners.socle.SocleEffyisApplication;
import effyis.partners.socle.content.dto.ItemFooterDTO;
import effyis.partners.socle.content.enums.TypeFooterEnum;
import effyis.partners.socle.content.repository.FooterRepository;
import effyis.partners.socle.content.service.FooterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SocleEffyisApplication.class)
@AutoConfigureMockMvc
class FooterControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    FooterService footerService;

    @Autowired
    ModelMapper modelMapper;


    @Test
    void getItemFooter() throws Exception {
        ItemFooterDTO item1 = new ItemFooterDTO(1L, TypeFooterEnum.URL_IMAGE, "Image", 0, "/URL");
        ItemFooterDTO item2 = new ItemFooterDTO(2L, TypeFooterEnum.TEXT, "About us", 1, "Lorem Ipsum");
        ItemFooterDTO item3 = new ItemFooterDTO(3L,TypeFooterEnum.LIST, "My list", 2, "Contact|/URL");

        List<ItemFooterDTO> itemFooterDTOS = new ArrayList<>();
        itemFooterDTOS.add(item1);
        itemFooterDTOS.add(item2);
        itemFooterDTOS.add(item3);

        when(footerService.getItemFooter()).thenReturn(itemFooterDTOS);

        mvc.perform(get("/effyis/api/footer"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemTitle", is("Image")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type", is("URL_IMAGE")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].itemTitle", is("About us")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].type", is("TEXT")));
    }

    @Test
    @WithMockUser(username = "zakaria", roles = "ADMIN")
    void saveItem() throws Exception {

        ItemFooterDTO item1 = new ItemFooterDTO(1L, TypeFooterEnum.URL_IMAGE, "Image", 0, "/URL");
        ItemFooterDTO item2 = new ItemFooterDTO(2L, TypeFooterEnum.TEXT, "About us", 1, "Lorem Ipsum");
        ItemFooterDTO item3 = new ItemFooterDTO(3L,TypeFooterEnum.LIST, "My list", 2, "Contact|/URL");

        List<ItemFooterDTO> itemFooterDTOS = new ArrayList<>();
        itemFooterDTOS.add(item1);
        itemFooterDTOS.add(item2);
        itemFooterDTOS.add(item3);

        mvc.perform(post("/effyis/api/footer/save")
                .content(asJsonString(itemFooterDTOS))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}