package engkoskostaman.belajarspringrestfullapi.repository;

import engkoskostaman.belajarspringrestfullapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
