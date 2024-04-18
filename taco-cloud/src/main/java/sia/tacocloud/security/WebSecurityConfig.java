package sia.tacocloud.security;

import sia.tacocloud.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import sia.tacocloud.data.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    // Cause UserDetailsService is functional interface we are able to define loadByUsername function
    // in lambda function, cause it has only one function.
    // User details service should not be use manually in any other place of code, you just should write it
    // down, other things will make Spring itself
    // @Bean
    // public UserDetailsService userDetailsService(UserRepository userRepository) {
    //     return username -> {
    //         User user = userRepository.findByUsername(username);
    //         System.out.println("!!!!!!!!<,,,,,..,mdaf" + " " + user);
    //         if (user != null) return user;
            
    //         throw new UsernameNotFoundException("User '" + username + "'' not found!!!");
    //     };
    // }

    private final JpaUserDetailsService myUserDetailsService;

    public WebSecurityConfig(JpaUserDetailsService myDetailsService) {
        this.myUserDetailsService = myDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/design", "/orders").hasRole("USER")
                .requestMatchers("/", "/**").permitAll()
            )
            .userDetailsService(myUserDetailsService)
            .formLogin( form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/design")
            )
            .httpBasic(Customizer.withDefaults());
            
        
        return http.build();
    }
}
