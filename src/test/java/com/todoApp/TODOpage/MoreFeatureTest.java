package com.todoApp.TODOpage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todoApp.TODOpage.model.ListsOfTodo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ControllerAdded.class, secure = false)
public class MoreFeatureTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListRepo repo;
    List<ListsOfTodo> mockTasks = new ArrayList<ListsOfTodo>();

    @Test
    public void getListTest() throws Exception {
        ListsOfTodo task = new ListsOfTodo();
        task.setLid(1);
        task.setTask("task 1");
        mockTasks.add(task);

        Mockito.when(repo.findByTask("task 1")).thenReturn(mockTasks);
        mockMvc.perform(get("/find?lid=1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'lid': 1,'task': 'task 1'}]"));

    }

    @Test
    public void insertListTest() throws Exception {
        ListsOfTodo task = new ListsOfTodo();
        task.setLid(1);
        task.setTask("newTask");

        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/insert?lid=1&tsk=newTask")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(task)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTodoTest() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        ListsOfTodo task = new ListsOfTodo();
        task.setLid(1);
        task.setTask("newTask");
        repo.save(task);
        mockMvc.perform(put("/update?lid=1&tsk=updated")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(task)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTaskTest() throws Exception {
        mockMvc.perform(delete("/delete?lid=1")).andExpect(status().isOk());
    }
}