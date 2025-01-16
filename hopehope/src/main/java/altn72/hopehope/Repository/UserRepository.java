package altn72.hopehope.Repository;

import altn72.hopehope.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.id = :Id")
    Optional<User> findById(String Id);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(String role);
}
