package effyis.partners.socle.content.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author CHICHI Hamza
 */

@Entity
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "items_by_footer",
            joinColumns=@JoinColumn(name="footer_id"), inverseJoinColumns=@JoinColumn(name="items_id")
    )
    private List<ItemFooter> items;


    public Footer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemFooter> getItems() {
        return items;
    }

    public void setItems(List<ItemFooter> items) {
        this.items = items;
    }
}
