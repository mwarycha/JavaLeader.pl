package pl.javaleader.githubrestwrapperapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubEntity {

    @JsonProperty("fullName")
    private String nameOfRepository;

    @JsonProperty("description")
    private String descriptionOfRepository;

    @JsonProperty("cloneUrl")
    private String gitCloneUrlRepository;

    @JsonProperty("stars")
    private Integer numberOfStargazerRepository;

    @JsonProperty("createdAt")
    private String dateOfCreationRepository;

    public String getNameOfRepository() {
        return nameOfRepository;
    }

    public void setNameOfRepository(String nameOfRepository) {
        this.nameOfRepository = nameOfRepository;
    }

    public String getDescriptionOfRepository() {
        return descriptionOfRepository;
    }

    public void setDescriptionOfRepository(String descriptionOfRepository) {
        this.descriptionOfRepository = descriptionOfRepository;
    }

    public String getGitCloneUrlRepository() {
        return gitCloneUrlRepository;
    }

    public void setGitCloneUrlRepository(String gitCloneUrlRepository) {
        this.gitCloneUrlRepository = gitCloneUrlRepository;
    }

    public Integer getNumberOfStargazerRepository() {
        return numberOfStargazerRepository;
    }

    public void setNumberOfStargazerRepository(Integer numberOfStargazerRepository) {
        this.numberOfStargazerRepository = numberOfStargazerRepository;
    }

    public String getDateOfCreationRepository() {
        return dateOfCreationRepository;
    }

    public void setDateOfCreationRepository(String dateOfCreationRepository) {
        this.dateOfCreationRepository = dateOfCreationRepository;
    }
}
