package lt.runas.chatapp.repositories;

import lt.runas.chatapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u Where u.username = :username")
    public User getUserByUsername(@Param("username")String username);
}
