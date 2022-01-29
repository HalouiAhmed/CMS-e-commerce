package effyis.partners.socle.content.entity;


import effyis.partners.socle.content.enums.TypeFooterEnum;

import javax.persistence.*;

@Entity
public class TypeSectionFooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TypeFooterEnum type;

    public TypeSectionFooter(TypeFooterEnum type) {
        this.type = type;
    }

    public TypeSectionFooter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeFooterEnum getType() {
        return type;
    }

    public void setType(TypeFooterEnum type) {
        this.type = type;
    }
}
