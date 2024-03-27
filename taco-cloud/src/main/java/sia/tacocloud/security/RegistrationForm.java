package sia.tacocloud.security;

import sia.tacocloud.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
    public String username;
    public String password;
    public String fullname;
    public String street;
    public String city;
    public String state;
    public String zip;
    public String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
            username, passwordEncoder.encode(password),
            fullname, street, city, state, zip, phone);
    }
}
