package com.trending.git.gittrending.classes;

public class Repos {
    private String repo_name;
    private String repo_desc;
    private float score;
    private String owner_name;
    private String UrlImage;

    //constructer

    public Repos(String repo_name, String repo_desc, float score, String owner_name, String urlImage) {
        this.repo_name = repo_name;
        this.repo_desc = repo_desc;
        this.score = score;
        this.owner_name = owner_name;
        UrlImage = urlImage;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public String getRepo_desc() {
        return repo_desc;
    }

    public void setRepo_desc(String repo_desc) {
        this.repo_desc = repo_desc;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }
}
