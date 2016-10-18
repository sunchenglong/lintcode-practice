package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/18.
 */
public class Powxn50 {
    public double myPow(double x, int n) {
        if (n < 0) {
            double result = pow(x, -n);
            if (Double.isFinite(1 / result))
                return 1 / result;
            else
                return 0;
        } else {
            return pow(x, n);
        }

    }

    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double y = myPow(x, n / 2);
        if (n % 2 == 0) return y * y;
        else return y * y * x;
    }
}
