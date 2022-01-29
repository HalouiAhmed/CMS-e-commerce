package effyis.partners.socle.content.repository;


import effyis.partners.socle.content.entity.ItemFooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ItemFooterRepository extends JpaRepository<ItemFooter,Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE footer_items CASCADE;\n" +
            "ALTER SEQUENCE footer_items_id_seq RESTART WITH 1;", nativeQuery = true)
    void truncateItemFooterTable();

}
