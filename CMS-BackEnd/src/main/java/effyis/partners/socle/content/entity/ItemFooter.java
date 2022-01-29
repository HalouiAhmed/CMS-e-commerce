package effyis.partners.socle.content.entity;


import effyis.partners.socle.content.enums.TypeFooterEnum;

import javax.persistence.*;

@Entity
@Table(name = "footerItems")
public class ItemFooter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeFooterEnum typeSection;

    private String itemTitle;

    @Column(unique = true)
    private Integer position;

    private String content;


    public ItemFooter(Long id, TypeFooterEnum typeSection, String itemTitle, Integer position, String content) {
        this.id = id;
        this.typeSection = typeSection;
        this.itemTitle = itemTitle;
        this.position = position;
        this.content = content;
    }

    public ItemFooter() {
    }

    public ItemFooter(TypeFooterEnum typeSection, String itemTitle, Integer position, String content) {
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

    public TypeFooterEnum getTypeSection() {
        return typeSection;
    }

    public void setTypeSection(TypeFooterEnum typeSection) {
        this.typeSection = typeSection;
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

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    @Override
    public String toString() {
        return "ItemFooter{" +
                "id=" + id +
                ", typeSectionFooter=" + typeSection +
                ", itemTitle='" + itemTitle + '\'' +
                ", position=" + position +
                ", content='" + content + '\'' +
                '}';
    }
}
