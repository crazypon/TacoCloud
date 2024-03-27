package sia.tacocloud.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sia.tacocloud.data.UserRepository;

@Configuration
public class WebSecurityConfig {
    // Cause UserDetailsService is functional interface we are able to define loadByUsername function
    // in lambda function, cause it has only one function.
    // User details service should not be use manually in any other place of code, you just should write it
    // down, other things will make Spring itself
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            //TODO Casted user into UserDetails (I Guess there is an error in the book)
            if (user != null) return (UserDetails) user;
            
            throw new UsernameNotFoundException("User '" + username + "'' not found!!!");
        };
    }
}
