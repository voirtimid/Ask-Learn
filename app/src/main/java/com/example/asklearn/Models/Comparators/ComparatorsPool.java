package com.example.asklearn.Models.Comparators;

public final class ComparatorsPool {
    private static PostDatetimeComparator postDatetimeComparator;
    private static CategoryNameComparator categoryNameComparator;
    private static DeviceIsCurrentlyUsedAndNameComparator deviceIsCurrentlyUsedAndNameComparator;
    private static PostLikesDislikesComparator postLikesDislikesComparator;

    private ComparatorsPool() {}

    public static PostDatetimeComparator getPostDatetimeComparator() {
        if (postDatetimeComparator == null) {
            postDatetimeComparator = new PostDatetimeComparator();
        }
        return postDatetimeComparator;
    }

    public static CategoryNameComparator getCategoryNameComparator() {
        if (categoryNameComparator == null) {
            categoryNameComparator = new CategoryNameComparator();
        }
        return categoryNameComparator;
    }

    public static DeviceIsCurrentlyUsedAndNameComparator getDeviceIsCurrentlyUsedAndNameComparator() {
        if (deviceIsCurrentlyUsedAndNameComparator == null) {
            deviceIsCurrentlyUsedAndNameComparator = new DeviceIsCurrentlyUsedAndNameComparator();
        }
        return deviceIsCurrentlyUsedAndNameComparator;
    }

    public static PostLikesDislikesComparator getPostLikesDislikesComparator() {
        if (postLikesDislikesComparator == null) {
            postLikesDislikesComparator = new PostLikesDislikesComparator();
        }
        return postLikesDislikesComparator;
    }
}
