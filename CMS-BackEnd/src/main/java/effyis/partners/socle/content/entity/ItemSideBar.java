package effyis.partners.socle.content.entity;


import javax.persistence.*;

@Entity
@Table(name = "sidebar_item")
public class ItemSideBar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, unique = true)
    private Integer position;

    public ItemSideBar() {
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

    public ItemSideBar(String title, String url, Integer position) {
        this.title = title;
        this.url = url;
        this.position = position;
    }
}