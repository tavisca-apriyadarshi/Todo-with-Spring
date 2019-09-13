package com.todoApp.TODOpage;

import com.todoApp.TODOpage.model.ListsOfTodo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void getListTest() throws Exception{
        ListsOfTodo task = new ListsOfTodo();
        task.setLid(1);
        task.setTask("task 1");
        mockTasks.add(task);

        /*Mockito.when(
        controller.getList(1)).thenReturn(mockTasks);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/find").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{lid:1,task: task 1}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);*/
        //given(todoRepository.isEmpty()).willReturn(false);
        Mockito.when(repo.findByTask("task 1")).thenReturn(mockTasks);
        mockMvc.perform(get("/find?lid=1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'lid': 1,'task': 'task 1'}]"));

    }

}/*	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
	@Test
	public void retrieveDetailsForCourse() throws Exception {

	}

}*/