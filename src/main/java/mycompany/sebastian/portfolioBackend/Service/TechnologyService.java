package mycompany.sebastian.portfolioBackend.Service;

import mycompany.sebastian.portfolioBackend.Model.ProjectData;
import mycompany.sebastian.portfolioBackend.Model.Technology;
import mycompany.sebastian.portfolioBackend.Repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {
    TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public List<Technology> getAllTechnologies(){return technologyRepository.findAll(); }

    public void addTechnology(Technology technology){
        if(technology.getName()==null) {
            return;
        }
        else {
            technologyRepository.save(technology);
        }
    }

}
