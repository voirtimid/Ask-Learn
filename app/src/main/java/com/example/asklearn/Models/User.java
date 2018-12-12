package com.example.asklearn.Models;

import com.example.asklearn.Models.Comparators.ComparatorsPool;
import com.example.asklearn.Models.Comparators.PostDatetimeComparator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.function.Function;

public class User {
    private String username;
    private String email;
    private String salt;
    private String passwordHash;
    private Set<Post> posts;
    private Set<Post> likes;
    private Set<Post> dislikes;
    private boolean isSudo;
    private Set<Category> isAdminIn;
    private Set<Category> followings;
    private boolean isVerified;
    private String specialName;
    private Set<Device> devices;

    private User(String username, String email, String salt, String passwordHash) {
        this.username = username;
        this.email = email;
        this.salt = salt;
        this.passwordHash = passwordHash;

        this.posts = new TreeSet<>(ComparatorsPool.getPostDatetimeComparator());
        this.likes = new HashSet<>();
        this.dislikes = new HashSet<>();
        this.isSudo = false;
        this.isAdminIn = new HashSet<>();
        this.followings = new TreeSet<>(ComparatorsPool.getCategoryNameComparator());
        this.isVerified = false;
        this.specialName = null;
        this.devices = new TreeSet<>(ComparatorsPool.getDeviceIsCurrentlyUsedAndNameComparator());
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public Set<Post> getLikes() {
        return likes;
    }

    public Set<Post> getDislikes() {
        return dislikes;
    }

    public boolean isSudo() {
        return isSudo;
    }

    public Set<Category> getIsAdminIn() {
        return isAdminIn;
    }

    public Set<Category> getFollowings() {
        return followings;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        if (isVerified()) {
            this.specialName = specialName;
        }
    }

    public Set<Device> getDevices() {
        return devices;
    }
}
