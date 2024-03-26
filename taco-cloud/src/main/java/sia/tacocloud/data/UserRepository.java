package sia.tacocloud.data;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.CrudRepository;

// in CrudRepository first object inside <>, I guess is object that 
// UserRepsitory will work with
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
