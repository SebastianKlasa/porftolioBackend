package mycompany.sebastian.portfolioBackend.Service;

import mycompany.sebastian.portfolioBackend.Model.ProjectData;
import mycompany.sebastian.portfolioBackend.Repository.ProjectDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDataService {
    private ProjectDataRepository projectDataRepository;

    @Autowired
    public ProjectDataService(ProjectDataRepository projectDataRepository){
        this.projectDataRepository = projectDataRepository;
    }

    public List<ProjectData> findAllProjects(){
        return projectDataRepository.findAll();
    }

    public Optional<ProjectData> findById(int id){
        return projectDataRepository.findById(id);
    }

    public void addUpdateProject(ProjectData projectData){
        if(projectData.getTitle()==null ||
                projectData.getGitUrl() == null ||
                projectData.getActionOnClick() == null||
                projectData.getDescription() == null) {
            return;
        }
        else {
            projectDataRepository.save(projectData);
        }
    }

    public void deleteById(int id){
        projectDataRepository.deleteById(id);
    }
}
