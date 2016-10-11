package com.sunchenglong.javalearn;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        int sqrt = mySqrt(num);
        if (Math.abs(1.0 * num / sqrt - sqrt) < 0.000001) return true;
        return false;
    }

    public int mySqrt(int x) {
        return search(1, x, x);
    }

    public int search(int start, int end, int x) {
        if (start >= end) {
            if (start <= x / start) return start;
            else return start - 1;
        }
        int media = start + (end - start) / 2;
        if (media == x / media) return media;
        else if (media < x / media) return search(media + 1, end, x);
        else return search(start, media, x);
    }

}
