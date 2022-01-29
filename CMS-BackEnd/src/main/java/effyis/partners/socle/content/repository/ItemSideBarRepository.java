package effyis.partners.socle.content.repository;


import effyis.partners.socle.content.entity.ItemSideBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ItemSideBarRepository extends JpaRepository<ItemSideBar,Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE sidebar_item CASCADE;\n" +
            "ALTER SEQUENCE sidebar_item_id_seq RESTART WITH 1;", nativeQuery = true)
    void truncateItemSidebarTable();


}