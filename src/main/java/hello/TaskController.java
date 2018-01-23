package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

@RestController
public class TaskController {

    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/task")
    public Task task(@RequestParam(value="name", defaultValue="Task") String name, @RequestParam(value="dueDate", defaultValue="dueDate") String dueDate) {
    	Task t=new Task(name, dueDate);
    	return t;
        //return new Task((int)counter.incrementAndGet(),name, dueDate);
    }

    @RequestMapping("/getPendingTasks")
    public ArrayList<Task> getTaskList() {  
    	return Task.getPendingTasks();
        //return new Task((int)counter.incrementAndGet(),name, dueDate);
    }


    @RequestMapping("/addTask")
    public void addTask(Task task) {
        task.setId((int)counter.incrementAndGet());
        Task.addTask(task);
        //return new Task((int)counter.incrementAndGet(),name, dueDate);
    }

    @RequestMapping("/searchTask")
    public Task searchTask(String name) {
        System.out.println("This is what I get from angular: " + name);
        return Task.searchTask(name);
    }

    @RequestMapping("/completeTask")
    public boolean completeTask(Integer id) {
        boolean completed=Task.completeTask(id);
        return completed;
    }

    @RequestMapping("/deleteTask")
    public boolean deleteTask(Integer id) {
        boolean deleted=Task.deleteTask(id);
        return deleted;
    }

    @RequestMapping("/updateTask")
    public boolean updateTask(Integer id, String name, String dueDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try
        {
            date = format.parse(dueDate);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }     
        boolean updated=Task.updateTask(id, name, date);
        return updated;
    }
}
