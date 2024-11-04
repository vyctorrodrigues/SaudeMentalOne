package SaudeMental.One.service;

import java.util.List;


import SaudeMental.One.model.MoodEntry;

public interface MoodEntryService {
    
    MoodEntry createMoodEntry(MoodEntry moodEntry);

    MoodEntry findById(Long id);

    MoodEntry updateMoodEntry(MoodEntry moodEntry, Long id);

    void deleteMoodEntry(Long id);

    List<MoodEntry> findAll();
}
