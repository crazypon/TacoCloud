package sia.tacocloud.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


// loadByUsername function looks up username and uses it to look up a UserDetails obj
// ******* It is implemented by User.java ***********
// so it gets informatin from that entity
public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
