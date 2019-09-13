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
        //ModelAndView mv = new ModelAndView("ShowList.jsp");
        List<ListsOfTodo> lists = repo.findByTask("task 1");
        //mv.addObject(lists);
        return lists;
    }
    /*@RequestMapping("/sort")
    public List<ListsOfTodo> sortList() {
        //ModelAndView mv = new ModelAndView("ShowList.jsp");
        List<ListsOfTodo> lists = repo.findByTaskSorted("task 1");
        //mv.addObject(lists);
        return lists;
    }
*/
}
