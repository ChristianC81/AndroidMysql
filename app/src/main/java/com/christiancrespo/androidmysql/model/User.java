package com.christiancrespo.androidmysql.model;

public class User {
    private int id;
    private String nickname;
    private String github_profile;
    private String link;

    public User() {
    }

    public User(int id, String nickname, String github_profile, String link) {
        this.id = id;
        this.nickname = nickname;
        this.github_profile = github_profile;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGithub_profile() {
        return github_profile;
    }

    public void setGithub_profile(String github_profile) {
        this.github_profile = github_profile;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
