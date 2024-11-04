package SaudeMental.One.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import SaudeMental.One.model.Goal;
import SaudeMental.One.service.GoalService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Goal")
public class GoalController {
    
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/api/goal")
    public ResponseEntity<List<Goal>> findAll(){
        List<Goal> goals = goalService.findAll();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/api/goals/{id}") 
    public ResponseEntity<Goal> findById(@PathVariable Long id){
        Goal goal = goalService.findById(id);
        return ResponseEntity.ok(goal);
    }

    @PostMapping("/api/goal")
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal){
        var goalss = goalService.createGoal(goal);
        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(goal.getId())
            .toUri();
        return ResponseEntity.created(location).body(goalss);
    }

    @PutMapping("/api/goal/{id}") 
    public ResponseEntity<Goal> uptadeGoal(@PathVariable Long id, @RequestBody Goal goal){
        Goal upGoal = goalService.updateGoal(goal, id);
        return ResponseEntity.ok(upGoal);
    }

    @DeleteMapping("/api/goal/{id}") 
    public ResponseEntity<Void> deleteGoal(Long id){
        return ResponseEntity.noContent().build();    
    }


    

}
