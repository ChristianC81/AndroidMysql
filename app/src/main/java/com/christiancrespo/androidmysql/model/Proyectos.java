package com.christiancrespo.androidmysql.model;

public class Proyectos {
    private String Description;
    private String github_url;
    private String main_language;

    public Proyectos() {
    }

    public Proyectos(String description, String github_url, String main_language) {
        Description = description;
        this.github_url = github_url;
        this.main_language = main_language;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getGithub_url() {
        return github_url;
    }

    public void setGithub_url(String github_url) {
        this.github_url = github_url;
    }

    public String getMain_language() {
        return main_language;
    }

    public void setMain_language(String main_language) {
        this.main_language = main_language;
    }

}
