package effyis.partners.socle.content.repository;


import effyis.partners.socle.content.entity.SideBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideBarRepository extends JpaRepository<SideBar,Long> {
}
