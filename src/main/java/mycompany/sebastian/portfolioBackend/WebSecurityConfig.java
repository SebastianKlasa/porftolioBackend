package mycompany.sebastian.portfolioBackend;

import mycompany.sebastian.portfolioBackend.Model.UserData;
import mycompany.sebastian.portfolioBackend.Repository.UserDataRepository;
import mycompany.sebastian.portfolioBackend.Service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDataRepository userDataRepository;
    private UserDataService userDataService;

    @Autowired
    public WebSecurityConfig(UserDataRepository userDataRepository, UserDataService userDataService) {
        this.userDataRepository = userDataRepository;
        this.userDataService = userDataService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDataService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/test2").permitAll()
                //userData permissions
                .antMatchers(HttpMethod.GET, "/userData/id/{id}").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/userData/userName/{userName}").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/userData").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/userData").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/userData").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/userData").permitAll()//.hasRole("ADMIN")
                //projectData permissions
                .antMatchers(HttpMethod.GET, "/projectData/id/{id}").permitAll()//.hasRole("ADMIN")
               .antMatchers(HttpMethod.GET, "/projectData").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/projectData").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/projectData").permitAll()//.hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/projectData").permitAll()//.hasRole("ADMIN")
                //.anyRequest().authenticated()
            .and()
                .formLogin()
                .permitAll()
            .and()
                .logout()
                .permitAll().and()
            .csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addUser(){
//        UserData appUser1 = new UserData("UserJan", passwordEncoder().encode("123"), "ROLE_USER");
//        UserData appUser2 = new UserData("AdminJan", passwordEncoder().encode("123"), "ROLE_ADMIN");
//       // UserData appUser3 = new UserData(null, null, null);
//        userDataRepository.save(appUser1);
//        userDataRepository.save(appUser2);
//      //  userDataRepository.save(appUser3);
    }

}