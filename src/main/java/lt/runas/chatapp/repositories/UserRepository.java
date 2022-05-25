package lt.runas.chatapp.repositories;

import lt.runas.chatapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("Select u from User u Where u.username = :username")
    //public User findByUsername(@Param("username")String username);

    User findByUsername(String username);
}
