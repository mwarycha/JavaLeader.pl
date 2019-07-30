package pl.javaleader.githubrestwrapperapi.service;

import pl.javaleader.githubrestwrapperapi.model.GitHubEntity;
import pl.javaleader.githubrestwrapperapi.util.GitHubHelper;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repositories")
public class GithubControllerRestApiController {

    @RequestMapping("/{owner}/{repositoryName}")
    public ResponseEntity<?> getRepoDetailsByOwner(@PathVariable String owner, @PathVariable String repositoryName) {

        final String FULL_NAME    = "full_name";
        final String DESCRIPTION  = "description";
        final String CLONE_URL    = "clone_url";
        final String CREATED_AT   = "created_at";

        Map map = getMapFromJson(githubWrapperRepo(owner,repositoryName));

        String fullNameRepo    = map.get(FULL_NAME).toString();
        String descriptionRepo = map.get(DESCRIPTION).toString();
        String cloneUrlRepo    = map.get(CLONE_URL).toString();
        String createdDateRepo = map.get(CREATED_AT).toString();

        int stars              = githubWrapperStarGazersQuantity(owner,repositoryName);

        return new ResponseEntity(createModel(fullNameRepo,descriptionRepo,cloneUrlRepo,createdDateRepo, stars), HttpStatus.OK);

    }

    private int githubWrapperStarGazersQuantity(String user, String repo) {

        HttpEntity<String> entity = new HttpEntity("parameters", GitHubHelper.getUserAgentHeader());

        RestTemplate rest               = new RestTemplate();
        ResponseEntity<String> exchange = rest.exchange(
                "https://api.github.com/repos/" + user + "/" + repo + "/stargazers",
                HttpMethod.GET,
                entity,
                String.class);

        return getGson().fromJson(exchange.getBody(), Map[] .class).length;

    }

    private String githubWrapperRepo(String user, String repo) {

        HttpEntity<String> entity = new HttpEntity("parameters", GitHubHelper.getUserAgentHeader());

        RestTemplate rest               = new RestTemplate();
        ResponseEntity<String> exchange = rest.exchange(
                "https://api.github.com/repos/" + user + "/" + repo,
                HttpMethod.GET,
                entity,
                String.class);

        return exchange.getBody();
    }

    private Gson getGson() {
        return new Gson();
    }

    private Map getMapFromJson(String jsonString) {
        return getGson().fromJson(jsonString, Map.class);
    }

    private GitHubEntity createModel(String fullNameRepo,String descriptionRepo, String cloneUrlRepo, String createdDateRepo, int stars) {

        GitHubEntity gitHubEntity = new GitHubEntity();

        gitHubEntity.setNameOfRepository(fullNameRepo);
        gitHubEntity.setDescriptionOfRepository(descriptionRepo);
        gitHubEntity.setGitCloneUrlRepository(cloneUrlRepo);
        gitHubEntity.setNumberOfStargazerRepository(stars);
        gitHubEntity.setDateOfCreationRepository(createLocalDate(createdDateRepo));

        return gitHubEntity;
    }

    private String createLocalDate(String createdDateRepo) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(createdDateRepo);
        return zonedDateTime.toLocalDate().toString();
    }
}
