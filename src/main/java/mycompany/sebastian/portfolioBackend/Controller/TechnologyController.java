package mycompany.sebastian.portfolioBackend.Controller;

import mycompany.sebastian.portfolioBackend.Model.Technology;
import mycompany.sebastian.portfolioBackend.Model.UserData;
import mycompany.sebastian.portfolioBackend.Service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnologyController {
    public TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/technologies")
    public List<Technology> getAllTechnologies(){return technologyService.getAllTechnologies(); }

    @PostMapping("/technologies")
    public void addTechnology(@RequestBody Technology technology){technologyService.addTechnology(technology);}
}
