package effyis.partners.socle.content.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import effyis.partners.socle.content.validation.ValidURL;

import javax.validation.constraints.NotBlank;

public class ItemSideBarDTO {

    private static final long serialVersionUID = 1L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    private String title;

    @ValidURL
    @NotBlank
    private String url;

    @NotBlank
    private Integer position;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ id: ").append(this.id).append(",\n  titlesidebar: ").append(this.title)
                .append(",\n  urlsidebar: ").append(this.url)
                .append(",\n  poisition: ").append(this.position).append(" }");

        return sb.toString();
    }

    public ItemSideBarDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
