package effyis.partners.socle.content.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import effyis.partners.socle.content.enums.TypeFooterEnum;

import javax.validation.constraints.NotBlank;

public class ItemFooterDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private TypeFooterEnum typeSection;
    private String itemTitle;
    @NotBlank
    private Integer position;
    private String content;

    public ItemFooterDTO() {
    }

    public ItemFooterDTO(Long id, TypeFooterEnum typeSection, String itemTitle, Integer position, String content) {
        this.id = id;
        this.typeSection = typeSection;
        this.itemTitle = itemTitle;
        this.position = position;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeFooterEnum getType() {
        return typeSection;
    }

    public void setType(TypeFooterEnum typeSection) {
        this.typeSection = typeSection;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ItemFooterDTO{" +
                "id=" + id +
                ", type=" + typeSection +
                ", itemTitle='" + itemTitle + '\'' +
                ", position=" + position +
                ", content='" + content + '\'' +
                '}';
    }
}
