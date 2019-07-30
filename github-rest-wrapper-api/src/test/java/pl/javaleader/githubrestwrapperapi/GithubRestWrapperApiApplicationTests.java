package pl.javaleader.githubrestwrapperapi;

import pl.javaleader.githubrestwrapperapi.model.GitHubEntity;
import pl.javaleader.githubrestwrapperapi.util.RetrieveUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRestWrapperApiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void checkStatusCode() throws IOException {

		// Given
		HttpUriRequest request = new HttpGet( "http://localhost:8080//repositories/mwarycha/SpringMVC4");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}

    @Test
	public void checkNameOfRepository() throws IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080//repositories/mwarycha/SpringMVC4" );

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Then
        GitHubEntity resource = RetrieveUtil.retrieveResourceFromResponse(response, GitHubEntity.class);
        assertThat( "mwarycha/SpringMVC4", Matchers.is(resource.getNameOfRepository()));
    }

}
