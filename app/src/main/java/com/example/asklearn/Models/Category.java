package com.example.asklearn.Models;

import java.util.TreeSet;
import java.util.Set;

public class Category {
    private String name;
    private String shortName;
    private Set<User> admins;
    private Set<User> followers;
    private Set<Post> posts;
    private String description;

    private Category(String name, String shortName, String description) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;

        this.admins = new TreeSet<>();
        this.followers = new TreeSet<>();
        this.posts = new TreeSet<>();
    }

    public Category(String name, String shortName) {
        this(name, shortName, null);
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Set<User> getAdmins() {
        return admins;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
