package altn72.hopehope.Service;

import altn72.hopehope.Model.Tool;
import altn72.hopehope.Repository.ToolRepository;
import altn72.hopehope.Dto.ToolDTO;
import altn72.hopehope.Mapper.ToolMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAll(List<Tool> tools) {
        for (Tool tool : tools) {
            entityManager.persist(tool);
        }
    }

    public List<ToolDTO> getAllTools() {
        return toolRepository.findAll()
                .stream()
                .map(ToolMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ToolDTO> getToolById(Long id) {
        return toolRepository.findById(id)
                .map(ToolMapper::toDTO);
    }

    public Tool saveTool(Tool tool) {
        return toolRepository.save(tool);
    }

    public void deleteTool(Long id) {
        toolRepository.deleteById(id);
    }

    public List<Tool> searchTools(String keyword) {
        return toolRepository.findToolsByKeyword(keyword);
    }
}
