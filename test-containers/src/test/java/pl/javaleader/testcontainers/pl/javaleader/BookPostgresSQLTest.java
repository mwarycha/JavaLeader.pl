package pl.javaleader.testcontainers.pl.javaleader;

import pl.javaleader.testcontainers.model.Book;
import pl.javaleader.testcontainers.repositories.BookRepository;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BookPostgresSQLTest extends AbstractIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    @Order(1)
    void should_be_able_to_save_one_book() throws Exception {
        // Given
        final var book = new Book();
        book.setAuthor("author");
        book.setTitle("title");
        book.setYear(2000);

        // When & Then
        mockMvc.perform(post("/create/book")
                .content(new ObjectMapper().writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.author").value("author"))
                .andExpect(jsonPath("$.title").value("title"))
                .andExpect(jsonPath("$.year").value("2000"));
    }

    @Test
    @Order(2)
    void shouldGetAllBooks() throws Exception {
        // Given
        bookRepository.saveAll(List.of(new Book(), new Book(), new Book()));

        // When
        mockMvc.perform(get("/fetch/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        // Then
        assertThat(bookRepository.findAll()).hasSize(3);
    }

}
