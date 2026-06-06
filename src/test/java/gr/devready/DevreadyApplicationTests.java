package gr.devready;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class DevreadyApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void testGetCalls() throws Exception{
		mockMvc.perform(get("/calls"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andDo(print());
	}

	@Test
	void testGetCalId() throws Exception{
		mockMvc.perform(get("/calls/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.notes.length()").value(0))
		.andDo(print());
	}

	@Test
	void testGetCalIdWithNotes() throws Exception{
		mockMvc.perform(get("/calls/3"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.notes.length()").value(1))
		.andDo(print());
	}
	@Test
	void testGetCalIdNotFound() throws Exception{
		mockMvc.perform(get("/calls/100"))
		.andExpect(status().isNotFound())
		.andExpect(content().contentType("application/json"))
		.andDo(print());
	}

	@Test
	void testEndpointNotFound() throws Exception{
		mockMvc.perform(get("/callz"))
		.andExpect(status().isNotFound())
		.andDo(print());
	}

	@Test
	void testArchiveCall() throws Exception{
		mockMvc.perform(patch("/calls/3/archive"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.archived").value(true))
		.andDo(print());
	}

	@Test
	void testArchiveCallNotFound() throws Exception{
		mockMvc.perform(get("/calls/-1"))
		.andExpect(status().isNotFound())
		.andExpect(content().contentType("application/json"))
        
		.andDo(print());
	}

}
