package aptech.fpt.spring.repository;

import aptech.fpt.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findDistinctByName(String name);
}
