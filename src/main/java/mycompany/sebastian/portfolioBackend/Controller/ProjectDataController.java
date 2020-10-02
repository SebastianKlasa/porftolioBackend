package mycompany.sebastian.portfolioBackend.Controller;

import mycompany.sebastian.portfolioBackend.Model.ProjectData;
import mycompany.sebastian.portfolioBackend.Service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectDataController {
    private ProjectDataService projectDataService;

    @Autowired
    public ProjectDataController(ProjectDataService projectDataService){
        this.projectDataService = projectDataService;
    }

    @GetMapping("/projectData")
    public List<ProjectData> getAllProjectData(){

        return projectDataService.findAllProjects();
    }

    @GetMapping("/projectData/id/{id}")
    Optional<ProjectData> getProjectDataById(@PathVariable int id) {

        return projectDataService.findById(id);
    }

//    @GetMapping("/projectData/id/{id}")
//    public ModelAndView getProjectDataById(@PathVariable int id) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("currentProj", projectDataService.findById(id));
//        mav.setViewName("project");
//
//        return mav;
//    }

    @PostMapping("/projectData")
    public void addProject(@RequestBody ProjectData projectData){

        projectDataService.addUpdateProject(projectData);
    }

    @PutMapping("/projectData")
    public void updateProject(@RequestBody ProjectData projectData){
        projectDataService.addUpdateProject(projectData);
    }

    @DeleteMapping("/projectData/{id}")
    public void deleteProject(int id){
        projectDataService.deleteById(id);
    }
}
