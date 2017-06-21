package app.serviceImpl;

import app.dto.ProjectDTO;
import app.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ProjectDTO addProject(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public ProjectDTO findProjectById(Long projectId) {
        return null;
    }

    @Override
    public List<ProjectDTO> getProjectByUserId(Long userId) {
        return null;
    }

    @Override
    public void deleteProjectById(Long id) {

    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        return null;
    }
}
