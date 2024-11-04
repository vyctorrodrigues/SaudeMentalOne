package SaudeMental.One.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SaudeMental.One.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    
}
