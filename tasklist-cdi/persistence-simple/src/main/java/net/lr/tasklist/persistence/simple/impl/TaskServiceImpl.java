package net.lr.tasklist.persistence.simple.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import net.lr.tasklist.model.Task;
import net.lr.tasklist.model.TaskService;

@OsgiServiceProvider(classes = {TaskService.class})
@Properties({
    @Property(name = "service.exported.interfaces", value = "*")
})
@Singleton
public class TaskServiceImpl implements TaskService {
        Map<Integer, Task> taskMap;
        
        public TaskServiceImpl() {
                taskMap = new HashMap<Integer, Task>();
                Task task = new Task();
                task.setId(1);
                task.setTitle("Buy some coffee");
                task.setDescription("Take the extra strong");
                addTask(task);
                task = new Task();
                task.setId(2);
                task.setTitle("Finish karaf tutorial");
                task.setDescription("Last check and wiki upload");
                addTask(task);
        }
        
        @Override
        public Task getTask(Integer id) {
                return taskMap.get(id);
        }

        @Override
        public void addTask(Task task) {
                taskMap.put(task.getId(), task);
        }

        @Override
        public Collection<Task> getTasks() {
                return taskMap.values();
        }

    @Override
    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);        
    }

    @Override
    public void deleteTask(Integer id) {
        taskMap.remove(id);
    }

}