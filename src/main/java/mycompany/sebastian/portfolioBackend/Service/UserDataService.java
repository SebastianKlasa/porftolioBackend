package mycompany.sebastian.portfolioBackend.Service;

import mycompany.sebastian.portfolioBackend.Model.UserData;
import mycompany.sebastian.portfolioBackend.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService implements UserDetailsService {
    private UserDataRepository userDataRepository;

    @Autowired
    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @Override
    public UserData loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDataRepository.findByUserName(s);
    }

    public List<UserData> findAllUsers(){

        return userDataRepository.findAll();
    }

    public Optional<UserData> findById(int id){
        return userDataRepository.findById(id);
    }

    public void addUpdateUser(UserData userData){
        if(userData.getUserName()==null ||
                userData.getPassword() == null ||
                userData.getRole() == null) {
            return;
        }
        else {
            userDataRepository.save(userData);
        }
    }

    public void deleteById(int id){
        userDataRepository.deleteById(Long.valueOf(id));
    }

}
