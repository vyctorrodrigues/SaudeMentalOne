package SaudeMental.One.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SaudeMental.One.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
