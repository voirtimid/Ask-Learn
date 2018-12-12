package com.example.asklearn.Models.Comparators;

import com.example.asklearn.Models.Post;

import java.util.Comparator;

public class PostDatetimeComparator implements Comparator<Post> {
    @Override
    public int compare(Post post, Post otherPost) {
        return -1 * post.getDatetime().compareTo(otherPost.getDatetime());
    }
}
