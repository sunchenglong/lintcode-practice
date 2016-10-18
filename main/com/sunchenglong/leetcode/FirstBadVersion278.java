package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class FirstBadVersion278 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int media = left + (right - left) / 2;
            if (isBadVersion(media)) right = media - 1;
            else {
                left = media + 1;
            }
        }
        if (isBadVersion(right)) return right;
        return right + 1;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}
