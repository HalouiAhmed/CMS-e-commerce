package effyis.partners.socle.content.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sidebar")
public class SideBar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sidebarId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "items_by_sidebar",
            joinColumns=@JoinColumn(name="sidebar_id"), inverseJoinColumns=@JoinColumn(name="items_id")
    )
    private List<ItemSideBar> itemSideBarList = new ArrayList<>();

    public SideBar(List<ItemSideBar> itemSideBarList) {
        this.itemSideBarList = itemSideBarList;
    }

    public Long getSidebarId() {
        return sidebarId;
    }

    public void setSidebarId(Long sidebarId) {
        this.sidebarId = sidebarId;
    }

    public List<ItemSideBar> getItemSideBarList() {
        return itemSideBarList;
    }

    public void setItemSideBarList(List<ItemSideBar> itemSideBarList) {
        this.itemSideBarList = itemSideBarList;
    }

    public SideBar(Long sidebarId, List<ItemSideBar> itemSideBarList) {
        this.sidebarId = sidebarId;
        this.itemSideBarList = itemSideBarList;
    }

    public SideBar() {
    }
}
