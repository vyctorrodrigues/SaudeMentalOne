package SaudeMental.One.service;

import java.util.List;

import SaudeMental.One.model.Goal;


public interface GoalService {

    Goal createGoal(Goal goal);

    Goal findById(Long id);

    List<Goal> findAll();

    Goal updateGoal(Goal goal, Long id);

    void deleteGoal(Long id);
}
