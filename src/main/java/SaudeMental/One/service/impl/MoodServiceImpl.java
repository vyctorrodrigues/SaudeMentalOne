package SaudeMental.One.service.impl;

import java.util.List;
import java.util.NoSuchElementException;



import org.springframework.stereotype.Service;

import SaudeMental.One.model.MoodEntry;
import SaudeMental.One.model.repository.MoodEntryRepository;
import SaudeMental.One.service.MoodEntryService;

@Service
public class MoodServiceImpl implements MoodEntryService {

    private final MoodEntryRepository moodEntryRepository;

    public MoodServiceImpl(MoodEntryRepository moodEntryRepository) {
        this.moodEntryRepository = moodEntryRepository;
    }

    @Override
    public MoodEntry createMoodEntry(MoodEntry moodEntry) {
        return moodEntryRepository.save(moodEntry);
    }

    @Override
    public MoodEntry findById(Long id) {
        return moodEntryRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<MoodEntry> findAll() {
        return moodEntryRepository.findAll();
    }

    @Override
    public MoodEntry updateMoodEntry(MoodEntry moodEntry, Long id) {
        moodEntry.setId(id);
        return moodEntryRepository.save(moodEntry);
    }

    @Override
    public void deleteMoodEntry(Long id) {
        moodEntryRepository.deleteById(id);
    }
    

}