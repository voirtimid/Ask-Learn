package com.example.asklearn.Models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post {
    private int id;
    private String title;
    private String context;
    private User poster;
    private Date datetime;
    private Set<User> likers;
    private Set<User> dislikers;
    private Category category;
    private Post parent;
    private Set<Post> comments;
    private boolean isEdited;

    public Post(String title, String context, User poster, Date datetime, Category category, Post parent) {
        this.title = title;
        this.context = context;
        this.poster = poster;
        this.datetime = datetime;
        this.category = category;
        this.parent = parent;

        this.likers = new HashSet<>();
        this.dislikers = new HashSet<>();
        this.comments = new HashSet<>();
        this.isEdited = false;
    }

    public Post(String context, User poster, Date datetime, Category category, Post parent) {
        this(null, context, poster, datetime, category, parent);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
        setEdited(false);
    }

    public User getPoster() {
        return poster;
    }

    public Date getDatetime() {
        return datetime;
    }

    public Set<User> getLikers() {
        return likers;
    }

    public Set<User> getDislikers() {
        return dislikers;
    }

    public Category getCategory() {
        return category;
    }

    public Post getParent() {
        return parent;
    }

    public Set<Post> getComments() {
        return comments;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }
}
