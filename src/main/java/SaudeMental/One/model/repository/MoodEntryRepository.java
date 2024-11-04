package SaudeMental.One.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SaudeMental.One.model.MoodEntry;

@Repository
public interface  MoodEntryRepository  extends JpaRepository<MoodEntry, Long>{
    
}
