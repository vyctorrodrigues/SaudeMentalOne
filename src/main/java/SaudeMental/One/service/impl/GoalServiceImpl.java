package SaudeMental.One.service.impl;

import java.util.List;
import java.util.NoSuchElementException;



import org.springframework.stereotype.Service;

import SaudeMental.One.model.Goal;
import SaudeMental.One.model.repository.GoalRepository;
import SaudeMental.One.service.GoalService;

@Service
public class GoalServiceImpl implements GoalService {
    
    private final GoalRepository goalRepository;

   
    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal findById(Long id) {
       return goalRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Goal> findAll() {
       return goalRepository.findAll();
    }

    @Override
    public Goal updateGoal(Goal goal, Long id) {
        Goal goals = goalRepository.findById(id).orElseThrow(() -> new RuntimeException("Meta não encontrada"));
        goals.setTitle(goal.getTitle());
        goals.setDescription(goal.getDescription());
        goals.setStatus(goal.getStatus());
        return goalRepository.save(goals);
    }

    @Override
    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}
