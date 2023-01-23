package net.javaguides.springboot;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.repository.StudentRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * The type Springboot test containers application tests.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringbootTestContainersApplicationTests extends AbstractContainerBaseTest{
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private MockMvc mokMvc;

	/**
	 * Given students when get all students then list of students.
	 *
	 * @throws Exception the exception
	 */
// given/when/then format - (Behavioural Driven Development) BDD style
	@Test
	public void givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception {

		//given  - setup or precondition
		List<Student> students=List.of(
				Student.builder()
						.firstName("Ramesh")
						.lastName("Kumar")
						.email("ramesh@gmail.com")
						.build(),
				Student.builder()
						.firstName("tony")
						.lastName("stark")
						.email("tony@gmail.com")
						.build());

		studentRepository.saveAll(students);

		//when  - action/actual testing
		ResultActions response = mokMvc.perform(MockMvcRequestBuilders.get("/api/students"));

		//then  - verify the output
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(students.size())));
	}
}