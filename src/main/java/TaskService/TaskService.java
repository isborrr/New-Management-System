package TaskService;

import TaskRepository.TaskRepository;
import model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private  TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Tasks>getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Tasks> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    // Create and save a new task
    public Tasks createTask(Tasks task) {
        return taskRepository.save(task);
    }
    private Long id;
    private String title;
    private String description;
    private String status;

    // Update an existing task
    public Optional<Tasks> updateTask(Long id, Tasks updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        });
    }

    // Delete a task by ID
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
