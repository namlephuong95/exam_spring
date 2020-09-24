package aptech.fpt.spring.repository;

import aptech.fpt.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
