package com.todoApp.TODOpage;

import com.todoApp.TODOpage.model.ListsOfTodo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodOpageApplicationTests {

	@Autowired
	private ListRepo repo;

    /*@Test
    public void searchTaskTest() {
        ListsOfTodo newTask = new ListsOfTodo();
        repo.deleteAll();
        newTask.setTask("task 1");
        repo.save(newTask);
        ListsOfTodo newTask2 = new ListsOfTodo();
        newTask2.setTask("task 2");
        repo.save(newTask2);
        ListsOfTodo newTask3 = new ListsOfTodo();
        newTask3.setTask("task 3");
        repo.save(newTask3);
        newTask2.setTask("updated task");
        repo.save(newTask2);
        Optional<ListsOfTodo> byId = repo.findById(2);
        String task = byId.get().getTask();
        assertEquals("updated task", task);
    }*/


    @Test
	public void getAllListTest() {
		assertEquals(3,repo.findAll().size());
	}

	@Test
	public void addTaskTest() {
		ListsOfTodo newTask = new ListsOfTodo();
		/*newTask.setLid(1);
		newTask.setTask("task 1");
		repo.delete(newTask);*/
		repo.deleteAll();
		newTask.setTask("task 1");
		repo.save(newTask);
		ListsOfTodo newTask2 = new ListsOfTodo();
		newTask2.setTask("task 2");
		repo.save(newTask2);
		ListsOfTodo newTask3 = new ListsOfTodo();
		newTask3.setTask("task 3");
		repo.save(newTask3);
		assertEquals(3,repo.findAll().size());
	}

	@Test
	public void updateTaskTest() {
		ListsOfTodo newTask = new ListsOfTodo();
		/*newTask.setLid(1);
		newTask.setTask("task 1");
		repo.delete(newTask);*/
		repo.deleteAll();
		newTask.setTask("task 1");
		repo.save(newTask);
		ListsOfTodo newTask2 = new ListsOfTodo();
		newTask2.setTask("task 2");
		repo.save(newTask2);
		ListsOfTodo newTask3 = new ListsOfTodo();
		newTask3.setTask("task 3");
		repo.save(newTask3);
		newTask2.setTask("updated task");
		repo.save(newTask2);
		assertEquals(3,repo.findAll().size());
	}

	@Test
	public void deleteTaskTest() {
		repo.deleteAll();
		ListsOfTodo newTask = new ListsOfTodo();
		newTask.setLid(1);
		newTask.setTask("task 1");
		repo.delete(newTask);
		assertEquals(0,repo.findAll().size());
	}


}
