package com.example.asklearn.Models;

import java.util.UUID;

public class Device {
    private int id;
    private User user;
    private String name;
    private UUID uuid;
    private boolean isCurrentlyUsed;

    public Device(User user, UUID uuid) {
        this.user = user;
        this.uuid = uuid;
        this.isCurrentlyUsed = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isCurrentlyUsed() {
        return isCurrentlyUsed;
    }

    public void setCurrentlyUsed(boolean currentlyUsed) {
        isCurrentlyUsed = currentlyUsed;
    }
}
