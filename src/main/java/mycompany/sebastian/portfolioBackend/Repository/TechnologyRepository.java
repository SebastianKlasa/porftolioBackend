package mycompany.sebastian.portfolioBackend.Repository;

import mycompany.sebastian.portfolioBackend.Model.ProjectData;
import mycompany.sebastian.portfolioBackend.Model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    Technology findByName(String name);
    Optional<Technology> findById(int id);
}
