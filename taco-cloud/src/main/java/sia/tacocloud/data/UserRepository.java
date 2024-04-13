package sia.tacocloud.data;

import sia.tacocloud.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

// in CrudRepository first object inside <>, I guess is object that 
// UserRepsitory will work with
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
