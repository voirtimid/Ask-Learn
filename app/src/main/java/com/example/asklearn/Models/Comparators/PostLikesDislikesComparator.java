package com.example.asklearn.Models.Comparators;

import com.example.asklearn.Models.Post;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class PostLikesDislikesComparator implements Comparator<Post> {

    // in future when we have thousands of users, this factor should become bigger
    public static final double FACTOR = 0.75;

    @Override
    public int compare(Post post, Post otherPost) {
        int compareResult = Boolean.compare(post.getPoster().isSudo(), otherPost.getPoster().isSudo());
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = Boolean.compare(post.getPoster().isVerified(), otherPost.getPoster().isVerified());
        if (compareResult != 0) {
            return compareResult;
        }

        compareResult = Boolean.compare(post.getPoster().getIsAdminIn().contains(post.getCategory()),
                                        otherPost.getPoster().getIsAdminIn().contains(otherPost.getCategory()));
        if (compareResult != 0) {
            return compareResult;
        }

        int postFinalResult = post.getLikers().size() - post.getDislikers().size();
        int otherPostFinalResult = otherPost.getLikers().size() - otherPost.getDislikers().size();

        Arrays.sort(new Post[] {post, otherPost}, ComparatorsPool.getPostDatetimeComparator());

        compareResult = -1 * post.getDatetime().compareTo(otherPost.getDatetime());

        if (postFinalResult * 1.0 / otherPostFinalResult < FACTOR) {
            // otherPost should go above post
            compareResult = otherPost.getDatetime().compareTo(post.getDatetime());
        }

        // this whole compare should be done if both have the same parent

        return compareResult;
    }
    /**
     * 1 isSudo
     * 2 isVerified
     * 3 isAdmin
     * 4 datetime -> (1 (10), 2(20)) =:= (2, 1)
     * 5 likes - dislikes
     *
     */
}
