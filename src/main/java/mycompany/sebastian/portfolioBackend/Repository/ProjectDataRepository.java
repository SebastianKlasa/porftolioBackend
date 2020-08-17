package mycompany.sebastian.portfolioBackend.Repository;

import mycompany.sebastian.portfolioBackend.Model.ProjectData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProjectDataRepository extends JpaRepository<ProjectData, Long> {
    ProjectData findByName(String userName);
    Optional<ProjectData> findById(int id);
}
