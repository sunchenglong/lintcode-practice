package com.sunchenglong.javalearn;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class RectangleArea223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - intersectArea(A, B, C, D, E, F, G, H);
    }

    public int intersectArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int intersectX = intersect(A, C, E, G);
        int intersectY = intersect(B, D, F, H);
        if (intersectX == 0 || intersectY == 0) return 0;
        return intersectX * intersectY;
    }

    public int intersect(int A, int B, int C, int D) {
        if (B <= C || A >= D) return 0;
        return Math.max(A, C) - Math.min(B, D);
    }

}
