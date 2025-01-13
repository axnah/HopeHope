package altn72.hopehope.Repository;

import altn72.hopehope.Model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    @Query("SELECT f FROM FeedBack f WHERE f.tool.id = :toolId")
    List<FeedBack> findByToolId(Long toolId);


}
