package mycompany.sebastian.portfolioBackend.Repository;

import mycompany.sebastian.portfolioBackend.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    UserData findByUserName(String userName);
    Optional<UserData> findById(int id);
}
