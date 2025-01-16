package altn72.hopehope.Repository;

import altn72.hopehope.Model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    @Query("SELECT t FROM Tool t WHERE t.id = :Id")
    Optional<Tool> findById(String Id);

    @Query("SELECT t FROM Tool t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(t.domain) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Tool> findToolsByKeyword(@Param("keyword") String keyword);

}
