package altn72.hopehope.Service;

import altn72.hopehope.Model.Tool;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToolService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAll(List<Tool> tools) {
        for (Tool tool : tools) {
            entityManager.persist(tool);
        }
    }
}

