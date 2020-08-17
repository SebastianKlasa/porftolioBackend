package mycompany.sebastian.portfolioBackend.Controller;

import mycompany.sebastian.portfolioBackend.Model.UserData;
import mycompany.sebastian.portfolioBackend.Service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserDataController {
    UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService){

        this.userDataService = userDataService;
    }

    @GetMapping("/userData")
    public List<UserData> getAllUserData(){
        return userDataService.findAllUsers();
    }

    @GetMapping("/userData/id/{id}")
    Optional<UserData> getUserDataById(@PathVariable int id) {

        return userDataService.findById(id);
    }

    @GetMapping("/userData/userName/{userName}")
    UserData getUserDataByUserName(@PathVariable String userName){
        return userDataService.loadUserByUsername(userName);
    }

    @PostMapping("/userData")
    public void addUser(@RequestBody UserData userData){
        userDataService.addUpdateUser(userData);
    }

    @PutMapping("/userData")
    public void updateUser(@RequestBody UserData userData){
        userDataService.addUpdateUser(userData);
    }

    @DeleteMapping("/userData/{id}")
    public void deleteUser(int id){
        userDataService.deleteById(id);
    }
}
