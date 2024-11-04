package SaudeMental.One.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import SaudeMental.One.model.MoodEntry;
import SaudeMental.One.service.MoodEntryService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/moodEntry")
public class MoodEntryController {
    
    private final MoodEntryService moodEntryService;

     public MoodEntryController(MoodEntryService moodEntryService) {
        this.moodEntryService = moodEntryService;
    }

    @PostMapping("/api/moodEntry") 
    public ResponseEntity<MoodEntry> createMoodEntry(@Valid @RequestBody MoodEntry moodEntry){
        var moodEntries = moodEntryService.createMoodEntry(moodEntry);
        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(moodEntry.getId())
            .toUri();
        return ResponseEntity.created(location).body(moodEntries);
    }

    @GetMapping("/api/moodEntries") 
    public ResponseEntity<List<MoodEntry>> findAll(){
        List<MoodEntry> moods = moodEntryService.findAll();
        return ResponseEntity.ok(moods);
    }

    @GetMapping("/api/moodEntries/{id}") 
    public ResponseEntity<MoodEntry> findById(@PathVariable Long id){
        MoodEntry mood = moodEntryService.findById(id);
        return ResponseEntity.ok(mood);
    }

    @PutMapping("/api/moodEntries/{id}") 
    public ResponseEntity<MoodEntry> updateMoodEntry(@PathVariable Long id, @RequestBody MoodEntry moodEntry){
        MoodEntry updateMood = moodEntryService.updateMoodEntry(moodEntry, id);
        return ResponseEntity.ok(updateMood);
    }

    @DeleteMapping("/api/moodEntries/{id}") 
    public ResponseEntity<Void> deleteMoodEntry(@PathVariable Long id){
        moodEntryService.deleteMoodEntry(id);
        return ResponseEntity.noContent().build();
    }

}

