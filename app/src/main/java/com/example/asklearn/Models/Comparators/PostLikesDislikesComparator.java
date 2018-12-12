package com.example.asklearn.Models.Comparators;

import com.example.asklearn.Models.Post;

import java.util.Comparator;

public class PostLikesDislikesComparator implements Comparator<Post> {

    // in future when we have thousands of users, this factor should become bigger
    public static final double FACTOR = 0.75;

    /**
     * 1 isSudo
     * 2 isVerified
     * 3 isAdmin
     * 4 datetime -> (1 (10), 2(20)) =:= (2, 1)
     * 5 likes - dislikes
     *
     */
    @Override
    public int compare(Post post, Post otherPost) {

        int compareResult = 0;

        if (post.getParent() != otherPost.getParent()) {
            return compareResult;
        }

        // if post and otherPost are comments and from same parent
        if (post.getParent() != null) {
            // 1 isSudo
            compareResult = Boolean.compare(post.getPoster().isSudo(), otherPost.getPoster().isSudo());
            if (compareResult != 0) {
                return compareResult;
            }

            // 2 isVerified
            compareResult = Boolean.compare(post.getPoster().isVerified(), otherPost.getPoster().isVerified());
            if (compareResult != 0) {
                return compareResult;
            }

            // 3 isAdmin of this post's category
            compareResult = Boolean.compare(post.getPoster().getIsAdminIn().contains(post.getCategory()),
                    otherPost.getPoster().getIsAdminIn().contains(otherPost.getCategory()));
            if (compareResult != 0) {
                return compareResult;
            }
        }

        // if post and otherPost are posts or comments

        // 4 first newer post should be first, but if one of the posts has more likes, then it goes up

        // 1 -> first otherPost then post
        // -1 -> first post then otherPost

        int postFinalResult = post.getLikers().size() - post.getDislikers().size();
        int otherPostFinalResult = otherPost.getLikers().size() - otherPost.getDislikers().size();

        compareResult = -1 * post.getDatetime().compareTo(otherPost.getDatetime());

        double ratio;

        // don't ask, it's black magic
        if (postFinalResult < otherPostFinalResult) {
            ratio = postFinalResult * 1.0 / otherPostFinalResult;
            if (ratio <= FACTOR) {
                compareResult = otherPost.getDatetime().compareTo(post.getDatetime());
            }
        } else {
            ratio = otherPostFinalResult * 1.0 / postFinalResult;
            if (ratio <= FACTOR) {
                compareResult = post.getDatetime().compareTo(otherPost.getDatetime());
            }
        }

        // this whole compare should be done if both have the same parent

        return compareResult;

    }
}
