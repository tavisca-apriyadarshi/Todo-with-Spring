package com.todoApp.TODOpage;

import com.todoApp.TODOpage.model.ListsOfTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ControllerAdded {
    @Autowired
    ListRepo repo;

    @RequestMapping("/find")
    public List<ListsOfTodo> getList(@RequestParam int lid){
        List<ListsOfTodo> lists = repo.findByTask("task 1");
        return lists;
    }

   @RequestMapping("/insert")
   public ListsOfTodo setList(@RequestParam int lid, String tsk) {
       ListsOfTodo task = new ListsOfTodo();
       task.setLid(lid);
       task.setTask(tsk);
       ListsOfTodo lists = repo.save(task);
       return lists;
   }

    @RequestMapping("/update")
    public ListsOfTodo updateList(@RequestParam int lid, String tsk) {
        ListsOfTodo task = new ListsOfTodo();
        task.setLid(lid);
        task.setTask(tsk);
        ListsOfTodo lists = repo.save(task);
        return lists;
    }

    @RequestMapping("/delete")
    public void deleteFromList(@RequestParam int lid) {
        repo.deleteById(lid);
    }
}
